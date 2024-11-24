package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 留言标记已接收信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageMarkReceivedInfo implements Dto {

    private static final long serialVersionUID = 7681637713639656975L;

    private LongIdKey messageKey;

    public MessageMarkReceivedInfo() {
    }

    public MessageMarkReceivedInfo(LongIdKey messageKey) {
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
        return "MessageMarkReceivedInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
