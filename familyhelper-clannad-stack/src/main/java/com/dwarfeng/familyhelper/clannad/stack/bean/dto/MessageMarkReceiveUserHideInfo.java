package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 消息标记接收用户隐藏信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageMarkReceiveUserHideInfo implements Dto {

    private static final long serialVersionUID = -5921623804191666140L;

    private LongIdKey messageKey;

    public MessageMarkReceiveUserHideInfo() {
    }

    public MessageMarkReceiveUserHideInfo(LongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    public LongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(LongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return "MessageMarkReceiveUserHideInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
