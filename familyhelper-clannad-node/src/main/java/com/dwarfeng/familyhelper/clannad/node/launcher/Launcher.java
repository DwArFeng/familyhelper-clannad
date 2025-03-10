package com.dwarfeng.familyhelper.clannad.node.launcher;

import com.dwarfeng.familyhelper.clannad.node.handler.LauncherSettingHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.BirthdayBlessQosService;
import com.dwarfeng.springterminator.sdk.util.ApplicationUtil;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;

/**
 * 程序启动器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class Launcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {
        ApplicationUtil.launch(new String[]{
                "classpath:spring/application-context*.xml",
                "file:opt/opt*.xml",
                "file:optext/opt*.xml"
        }, ctx -> {
            // 根据启动器设置处理器的设置，选择性上线生日祝福服务。
            mayOnlineBirthdayBless(ctx);
            // 根据启动器设置处理器的设置，选择性启动生日祝福服务。
            mayStartBirthdayBless(ctx);
        });
    }

    private static void mayOnlineBirthdayBless(ApplicationContext ctx) {
        // 获取启动器设置处理器，用于获取启动器设置，并按照设置选择性执行功能。
        LauncherSettingHandler launcherSettingHandler = ctx.getBean(LauncherSettingHandler.class);

        // 获取程序中的 ThreadPoolTaskScheduler，用于处理计划任务。
        ThreadPoolTaskScheduler scheduler = ctx.getBean(ThreadPoolTaskScheduler.class);

        // 获取生日祝福 QOS 服务。
        BirthdayBlessQosService birthdayBlessQosService = ctx.getBean(BirthdayBlessQosService.class);

        // 判断生日祝福处理器是否上线生日祝福服务，并按条件执行不同的操作。
        long onlineBirthdayBlessDelay = launcherSettingHandler.getOnlineBirthdayBlessDelay();
        if (onlineBirthdayBlessDelay == 0) {
            LOGGER.info("立即上线生日祝福服务...");
            try {
                birthdayBlessQosService.online();
            } catch (ServiceException e) {
                LOGGER.error("无法上线生日祝福服务，异常原因如下", e);
            }
        } else if (onlineBirthdayBlessDelay > 0) {
            LOGGER.info("{} 毫秒后上线生日祝福服务...", onlineBirthdayBlessDelay);
            scheduler.schedule(
                    () -> {
                        LOGGER.info("上线生日祝福服务...");
                        try {
                            birthdayBlessQosService.online();
                        } catch (ServiceException e) {
                            LOGGER.error("无法上线生日祝福服务，异常原因如下", e);
                        }
                    },
                    new Date(System.currentTimeMillis() + onlineBirthdayBlessDelay)
            );
        }
    }

    private static void mayStartBirthdayBless(ApplicationContext ctx) {
        // 获取启动器设置处理器，用于获取启动器设置，并按照设置选择性执行功能。
        LauncherSettingHandler launcherSettingHandler = ctx.getBean(LauncherSettingHandler.class);

        // 获取程序中的 ThreadPoolTaskScheduler，用于处理计划任务。
        ThreadPoolTaskScheduler scheduler = ctx.getBean(ThreadPoolTaskScheduler.class);

        // 获取生日祝福 QOS 服务。
        BirthdayBlessQosService birthdayBlessQosService = ctx.getBean(BirthdayBlessQosService.class);

        // 判断生日祝福处理器是否启动生日祝福服务，并按条件执行不同的操作。
        long startBirthdayBlessDelay = launcherSettingHandler.getStartBirthdayBlessDelay();
        if (startBirthdayBlessDelay == 0) {
            LOGGER.info("立即启动生日祝福服务...");
            try {
                birthdayBlessQosService.start();
            } catch (ServiceException e) {
                LOGGER.error("无法启动生日祝福服务，异常原因如下", e);
            }
        } else if (startBirthdayBlessDelay > 0) {
            LOGGER.info("{} 毫秒后启动生日祝福服务...", startBirthdayBlessDelay);
            scheduler.schedule(
                    () -> {
                        LOGGER.info("启动生日祝福服务...");
                        try {
                            birthdayBlessQosService.start();
                        } catch (ServiceException e) {
                            LOGGER.error("无法启动生日祝福服务，异常原因如下", e);
                        }
                    },
                    new Date(System.currentTimeMillis() + startBirthdayBlessDelay)
            );
        }
    }
}
