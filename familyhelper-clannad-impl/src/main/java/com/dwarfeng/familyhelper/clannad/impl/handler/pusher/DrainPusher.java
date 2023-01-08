package com.dwarfeng.familyhelper.clannad.impl.handler.pusher;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.BirthdayBlessInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 简单的丢弃掉所有信息的推送器。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
@Component
public class DrainPusher extends AbstractPusher {

    public static final String SUPPORT_TYPE = "drain";

    public DrainPusher() {
        super(SUPPORT_TYPE);
    }

    @Override
    public void birthdayBlessHappened(BirthdayBlessInfo birthdayBlessInfo) {
    }

    @Override
    public void birthdayBlessHappened(List<BirthdayBlessInfo> birthdayBlessInfos) {
    }

    @Override
    public String toString() {
        return "DrainPusher{" +
                "pusherType='" + pusherType + '\'' +
                '}';
    }
}
