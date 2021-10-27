package com.dwarfeng.familyhelper.clannad.sdk.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份证校验注解。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Documented
@Constraint(
        validatedBy = {IdNumber.IdNumberConstraintValidator.class}
)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdNumber {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class IdNumberConstraintValidator implements ConstraintValidator<IdNumber, Object> {

        final static Map<Integer, String> zoneNum = new HashMap<>();

        final static int[] PARITY_BIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        final static int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

        static {
            zoneNum.put(11, "北京");
            zoneNum.put(12, "天津");
            zoneNum.put(13, "河北");
            zoneNum.put(14, "山西");
            zoneNum.put(15, "内蒙古");
            zoneNum.put(21, "辽宁");
            zoneNum.put(22, "吉林");
            zoneNum.put(23, "黑龙江");
            zoneNum.put(31, "上海");
            zoneNum.put(32, "江苏");
            zoneNum.put(33, "浙江");
            zoneNum.put(34, "安徽");
            zoneNum.put(35, "福建");
            zoneNum.put(36, "江西");
            zoneNum.put(37, "山东");
            zoneNum.put(41, "河南");
            zoneNum.put(42, "湖北");
            zoneNum.put(43, "湖南");
            zoneNum.put(44, "广东");
            zoneNum.put(45, "广西");
            zoneNum.put(46, "海南");
            zoneNum.put(50, "重庆");
            zoneNum.put(51, "四川");
            zoneNum.put(52, "贵州");
            zoneNum.put(53, "云南");
            zoneNum.put(54, "西藏");
            zoneNum.put(61, "陕西");
            zoneNum.put(62, "甘肃");
            zoneNum.put(63, "青海");
            zoneNum.put(64, "宁夏");
            zoneNum.put(65, "新疆");
            zoneNum.put(71, "台湾");
            zoneNum.put(81, "香港");
            zoneNum.put(82, "澳门");
            zoneNum.put(91, "外国");
        }

        // 执行校验操作
        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            context.disableDefaultConstraintViolation();
            if (!(value instanceof String)) {
                context.buildConstraintViolationWithTemplate("校验的对象必须是文本");
                return false;
            }

            String mayIdNumber = (String) value;
            if (!isIdNumber(mayIdNumber)) {
                context.buildConstraintViolationWithTemplate("校验的对象不是身份证");
                return false;
            }

            return true;
        }

        private boolean isIdNumber(String certNo) {
            try {
                if (certNo == null || (certNo.length() != 15 && certNo.length() != 18)) {
                    return false;
                }

                final char[] cs = certNo.toUpperCase().toCharArray();
                // 1. 校验位数
                int power = 0;
                for (int i = 0; i < cs.length; i++) {
                    if (i == cs.length - 1 && cs[i] == 'X')
                        break;//最后一位可以 是X或x
                    if (cs[i] < '0' || cs[i] > '9')
                        return false;
                    if (i < cs.length - 1) {
                        power += (cs[i] - '0') * POWER_LIST[i];
                    }
                }

                // 2. 校验区位码
                if (!zoneNum.containsKey(Integer.valueOf(certNo.substring(0, 2)))) {
                    return false;
                }

                // 3. 校验年份
                String year;
                year = certNo.length() == 15 ? getIdCardCalendar(certNo) : certNo.substring(6, 10);

                final int intYear = Integer.parseInt(year);
                if (intYear < 1900 || intYear > Calendar.getInstance().get(Calendar.YEAR))
                    return false;//1900年的PASS，超过今年的PASS

                // 4. 校验月份
                String month = certNo.length() == 15 ? certNo.substring(8, 10) : certNo.substring(10, 12);
                final int intMonth = Integer.parseInt(month);
                if (intMonth < 1 || intMonth > 12) {
                    return false;
                }

                // 5. 校验天数
                String day = certNo.length() == 15 ? certNo.substring(10, 12) : certNo.substring(12, 14);
                final int intDay = Integer.parseInt(day);
                if (intDay < 1 || intDay > 31)
                    return false;

                // 6. 校验"校验码"
                if (certNo.length() == 15)
                    return true;
                return cs[cs.length - 1] == PARITY_BIT[power % 11];
            } catch (Exception e) {
                return false;
            }
        }

        private String getIdCardCalendar(String certNo) throws Exception {
            // 获取出生年月日
            String birthday = certNo.substring(6, 12);
            SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");
            Date birthdate = ft.parse(birthday);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(birthdate);
            return String.valueOf(calendar.get(Calendar.YEAR));
        }
    }
}
