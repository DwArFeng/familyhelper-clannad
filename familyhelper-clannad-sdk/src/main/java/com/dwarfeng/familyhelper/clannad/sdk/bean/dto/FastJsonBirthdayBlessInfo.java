package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.BirthdayBlessInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Objects;

/**
 * FastJson 生日祝福信息。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
public class FastJsonBirthdayBlessInfo implements Dto {

    private static final long serialVersionUID = -8374608656505769596L;

    public static FastJsonBirthdayBlessInfo of(BirthdayBlessInfo birthdayBlessInfo) {
        if (Objects.isNull(birthdayBlessInfo)) {
            return null;
        } else {
            return new FastJsonBirthdayBlessInfo(
                    FastJsonStringIdKey.of(birthdayBlessInfo.getKey()),
                    birthdayBlessInfo.getBirthday(), birthdayBlessInfo.getAge()
            );
        }
    }

    @JSONField(name = "user_key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "birthday", ordinal = 2)
    private String birthday;

    @JSONField(name = "age", ordinal = 3)
    private int age;

    public FastJsonBirthdayBlessInfo() {
    }

    public FastJsonBirthdayBlessInfo(FastJsonStringIdKey key, String birthday, int age) {
        this.key = key;
        this.birthday = birthday;
        this.age = age;
    }

    public FastJsonStringIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonStringIdKey key) {
        this.key = key;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FastJsonBirthdayBlessInfo{" +
                "key=" + key +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                '}';
    }
}
