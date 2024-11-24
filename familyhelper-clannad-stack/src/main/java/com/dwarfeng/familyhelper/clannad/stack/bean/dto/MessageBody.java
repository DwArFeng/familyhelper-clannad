package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 留言正文。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageBody implements Dto {

    private static final long serialVersionUID = 2715381293192099091L;

    private LongIdKey messageKey;
    private byte[] content;

    public MessageBody() {
    }

    public MessageBody(LongIdKey messageKey, byte[] content) {
        this.messageKey = messageKey;
        this.content = content;
    }

    public LongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(LongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageBody{" +
                "messageKey=" + messageKey +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
