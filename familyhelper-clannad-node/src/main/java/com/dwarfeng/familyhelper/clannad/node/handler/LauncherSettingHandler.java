package com.dwarfeng.familyhelper.clannad.node.handler;

import com.dwarfeng.subgrade.stack.handler.Handler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LauncherSettingHandler implements Handler {

    @Value("${launcher.online_birthday_bless_delay}")
    private long onlineBirthdayBlessDelay;
    @Value("${launcher.start_birthday_bless_delay}")
    private long startBirthdayBlessDelay;

    public long getOnlineBirthdayBlessDelay() {
        return onlineBirthdayBlessDelay;
    }

    public long getStartBirthdayBlessDelay() {
        return startBirthdayBlessDelay;
    }
}
