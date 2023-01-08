package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.BirthdayBlessInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.handler.BirthdayBlessHandler;
import com.dwarfeng.familyhelper.clannad.stack.handler.PushHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.ProfileMaintainService;
import com.dwarfeng.subgrade.impl.handler.CuratorDistributedLockHandler;
import com.dwarfeng.subgrade.impl.handler.Worker;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.BehaviorAnalyse;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

@Component
public class BirthdayBlessHandlerImpl implements BirthdayBlessHandler {

    private final CuratorDistributedLockHandler handler;

    public BirthdayBlessHandlerImpl(
            CuratorFramework curatorFramework,
            @Value("${curator.latch_path.birthday_bless.leader_latch}") String leaserLatchPath,
            BirthdayBlessWorker birthdayBlessWorker
    ) {
        handler = new CuratorDistributedLockHandler(curatorFramework, leaserLatchPath, birthdayBlessWorker);
    }

    @BehaviorAnalyse
    @Override
    public boolean isOnline() {
        return handler.isOnline();
    }

    @BehaviorAnalyse
    @Override
    public void online() throws HandlerException {
        handler.online();
    }

    @BehaviorAnalyse
    @Override
    public void offline() throws HandlerException {
        handler.offline();
    }

    @BehaviorAnalyse
    @Override
    public boolean isStarted() {
        return handler.isStarted();
    }

    @BehaviorAnalyse
    @Override
    public void start() throws HandlerException {
        handler.start();
    }

    @BehaviorAnalyse
    @Override
    public void stop() throws HandlerException {
        handler.stop();
    }

    @BehaviorAnalyse
    @Override
    public boolean isLockHolding() {
        return handler.isLockHolding();
    }

    @BehaviorAnalyse
    @Override
    public boolean isWorking() {
        return handler.isWorking();
    }

    @Component
    public static class BirthdayBlessWorker implements Worker {

        private static final Logger LOGGER = LoggerFactory.getLogger(BirthdayBlessWorker.class);

        private static final String BIRTHDAY_DELIMITER = "-";

        private final ApplicationContext ctx;

        private final ProfileMaintainService profileMaintainService;

        private final PushHandler pushHandler;

        private final ThreadPoolTaskScheduler scheduler;

        @Value("${birthday_bless.task.cron}")
        private String cron;

        private ScheduledFuture<?> future;

        public BirthdayBlessWorker(
                ApplicationContext ctx,
                ProfileMaintainService profileMaintainService,
                PushHandler pushHandler,
                ThreadPoolTaskScheduler scheduler
        ) {
            this.ctx = ctx;
            this.profileMaintainService = profileMaintainService;
            this.pushHandler = pushHandler;
            this.scheduler = scheduler;
        }

        @Override
        public void work() {
            // 记录日志。
            LOGGER.info("生日祝福处理器开始工作...");

            // 生成任务。
            BirthdayBlessTask task = ctx.getBean(BirthdayBlessTask.class, this);

            // 启动定时计划。
            future = scheduler.schedule(task, new CronTrigger(cron));
        }

        @Override
        public void rest() {
            // 记录日志。
            LOGGER.info("生日祝福处理器停止工作...");

            // 停止定时计划。
            future.cancel(true);
        }

        @Component
        @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        public class BirthdayBlessTask implements Runnable {

            @Override
            public void run() {
                try {
                    // 获取所有人的生日。
                    List<Profile> profiles = profileMaintainService.lookupAsList();

                    // 过滤出所有今天是生日的用户信息。
                    profiles = profiles.stream().filter(this::birthdayFilter).collect(Collectors.toList());

                    // 将消息发送到推送器中。
                    List<BirthdayBlessInfo> birthdayBlessInfos = profiles.stream().map(this::birthdayMapper)
                            .collect(Collectors.toList());
                    pushHandler.birthdayBlessHappened(birthdayBlessInfos);
                } catch (Exception e) {
                    LOGGER.warn("生日祝福计划执行时发生异常, 计划中止, 异常信息如下: ", e);
                }
            }

            // 为了程序的可读性，此处不简化条件判断语句。
            @SuppressWarnings("RedundantIfStatement")
            private boolean birthdayFilter(Profile profile) {
                // 获取生日字符串。
                // 格式: 1992-12-18。
                String birthday = profile.getBirthday();

                // 分割字符，构造生日参数，判断字符串是否合法，如果不合法直接返回 false。
                if (StringUtils.isEmpty(birthday)) {
                    return false;
                }
                int year, month, day;
                String[] split = birthday.split(BIRTHDAY_DELIMITER);
                if (split.length != 3) {
                    return false;
                }
                try {
                    year = Integer.parseInt(split[0]);
                    month = Integer.parseInt(split[1]);
                    day = Integer.parseInt(split[2]);
                } catch (Exception e) {
                    String message = "用户 " + profile.getKey().getStringId() + " 的生日字符串 " + birthday +
                            " 解析失败, 将不参与本次生日祝福判断, 异常信息如下: ";
                    LOGGER.warn(message, e);
                    return false;
                }

                // 获取当前日历。
                GregorianCalendar current = (GregorianCalendar) GregorianCalendar.getInstance();

                // 如果当前年份小于等于生日年份，则不参与生日祝福。
                int currentYear = current.get(Calendar.YEAR);
                if (currentYear <= year) {
                    return false;
                }

                // 如果当前的月份和日期等于出生月和日期，则今天是生日。
                // Calendar 的月份从 0 开始，因此需要 + 1。
                int currentMonth = current.get(Calendar.MONTH) + 1;
                int currentDay = current.get(Calendar.DAY_OF_MONTH);
                if ((month == currentMonth) && (day == currentDay)) {
                    return true;
                }

                // 特殊情况：如果出生日期是 2 月 29 日，且今年不是闰年，且今天是 3 月 1 日，则当天是生日。
                if (leapYearCondition(current, month, day, currentYear, currentMonth, currentDay)) {
                    return true;
                }

                // 上述条件都不满足，返回 false。
                return false;
            }

            // 为了程序的可读性，此处不简化条件判断语句。
            @SuppressWarnings("RedundantIfStatement")
            private boolean leapYearCondition(
                    GregorianCalendar current, int month, int day, int currentYear, int currentMonth, int currentDay
            ) {
                /*
                 * 1. 出生日期是 2 月 29 日。
                 * 2. 今年不是闰年。
                 * 3. 今天是 3 月 1 日，则当天是生日。
                 *
                 * 上述条件任何一个不满足，返回 false。
                 */
                if (!(month == 2) && (day == 29)) {
                    return false;
                }
                if (current.isLeapYear(currentYear)) {
                    return false;
                }
                if (!((currentMonth == 3) && (currentDay == 1))) {
                    return false;
                }

                return true;
            }

            private BirthdayBlessInfo birthdayMapper(Profile profile) {
                // 获取生日字符串。
                // 格式: 1992-12-18。
                // 此处的字符串经过前方法过滤，保证是有效的，且保证生日年份小于等于当前年份。
                String birthday = profile.getBirthday();

                // 获取生日年份，用于计算用户年龄。
                int year = Integer.parseInt(birthday.split(BIRTHDAY_DELIMITER)[0]);

                // 获取当前日历。
                GregorianCalendar current = (GregorianCalendar) GregorianCalendar.getInstance();
                // 获取当前年份。
                int currentYear = current.get(Calendar.YEAR);

                // 此处的数字大于等于 0 。
                int age = currentYear - year;

                // 返回生日祝福信息。
                return new BirthdayBlessInfo(profile.getKey(), profile.getBirthday(), age);
            }
        }
    }
}
