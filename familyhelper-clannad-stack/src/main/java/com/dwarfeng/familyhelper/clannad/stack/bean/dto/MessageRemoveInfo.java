package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 留言删除信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageRemoveInfo implements Dto {

    private static final long serialVersionUID = -5025529870259606118L;

    private LongIdKey messageKey;

    public MessageRemoveInfo() {
    }

    public MessageRemoveInfo(LongIdKey messageKey) {
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
        return "MessageRemoveInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
