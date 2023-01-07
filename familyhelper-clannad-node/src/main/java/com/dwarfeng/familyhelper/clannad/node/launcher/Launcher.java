package com.dwarfeng.familyhelper.clannad.node.launcher;

import com.dwarfeng.familyhelper.clannad.node.handler.LauncherSettingHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.BirthdayBlessQosService;
import com.dwarfeng.springterminator.sdk.util.ApplicationUtil;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
                "classpath:spring/application-context*.xml"
        }, ctx -> {
            LauncherSettingHandler launcherSettingHandler = ctx.getBean(LauncherSettingHandler.class);

            // 拿出程序中的 ThreadPoolTaskScheduler，用于处理计划任务。
            ThreadPoolTaskScheduler scheduler = ctx.getBean(ThreadPoolTaskScheduler.class);

            // 处理生日祝福处理器的启动选项。
            BirthdayBlessQosService birthdayBlessQosService = ctx.getBean(BirthdayBlessQosService.class);
            // 生日祝福处理器是否上线生日祝福服务。
            long onlineDriveDelay = launcherSettingHandler.getOnlineBirthdayBlessDelay();
            if (onlineDriveDelay == 0) {
                LOGGER.info("立即上线生日祝福服务...");
                try {
                    birthdayBlessQosService.online();
                } catch (ServiceException e) {
                    LOGGER.error("无法上线生日祝福服务，异常原因如下", e);
                }
            } else if (onlineDriveDelay > 0) {
                LOGGER.info(onlineDriveDelay + " 毫秒后上线生日祝福服务...");
                scheduler.schedule(
                        () -> {
                            LOGGER.info("上线生日祝福服务...");
                            try {
                                birthdayBlessQosService.online();
                            } catch (ServiceException e) {
                                LOGGER.error("无法上线生日祝福服务，异常原因如下", e);
                            }
                        },
                        new Date(System.currentTimeMillis() + onlineDriveDelay)
                );
            }
            // 生日祝福处理器是否启动生日祝福服务。
            long startBirthdayBlessDelay = launcherSettingHandler.getStartBirthdayBlessDelay();
            if (startBirthdayBlessDelay == 0) {
                LOGGER.info("立即启动生日祝福服务...");
                try {
                    birthdayBlessQosService.online();
                } catch (ServiceException e) {
                    LOGGER.error("无法启动生日祝福服务，异常原因如下", e);
                }
            } else if (startBirthdayBlessDelay > 0) {
                LOGGER.info(startBirthdayBlessDelay + " 毫秒后启动生日祝福服务...");
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
        });
    }
}
