package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 留言正文更新信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageBodyUpdateInfo implements Dto {

    private static final long serialVersionUID = -4735526323830412928L;

    private LongIdKey messageBodyKey;
    private byte[] content;

    public MessageBodyUpdateInfo() {
    }

    public MessageBodyUpdateInfo(LongIdKey messageBodyKey, byte[] content) {
        this.messageBodyKey = messageBodyKey;
        this.content = content;
    }

    public LongIdKey getMessageBodyKey() {
        return messageBodyKey;
    }

    public void setMessageBodyKey(LongIdKey messageBodyKey) {
        this.messageBodyKey = messageBodyKey;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageBodyUpdateInfo{" +
                "messageBodyKey=" + messageBodyKey +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
