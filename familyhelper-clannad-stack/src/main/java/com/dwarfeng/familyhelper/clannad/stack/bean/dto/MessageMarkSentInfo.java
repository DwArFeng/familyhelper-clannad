package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 留言标记已发送信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageMarkSentInfo implements Dto {

    private static final long serialVersionUID = 6415973671450036496L;

    private LongIdKey messageKey;

    public MessageMarkSentInfo() {
    }

    public MessageMarkSentInfo(LongIdKey messageKey) {
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
        return "MessageMarkSentInfo{" +
                "messageKey=" + messageKey +
                '}';
    }
}
