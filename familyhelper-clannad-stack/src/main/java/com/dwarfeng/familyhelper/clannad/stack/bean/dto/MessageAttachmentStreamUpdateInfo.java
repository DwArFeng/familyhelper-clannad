package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.io.InputStream;

/**
 * 留言附件流更新信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAttachmentStreamUpdateInfo implements Dto {

    private static final long serialVersionUID = 8808967536934393535L;

    private LongIdKey messageAttachmentInfoKey;
    private String originName;
    private long length;
    private InputStream content;

    public MessageAttachmentStreamUpdateInfo() {
    }

    public MessageAttachmentStreamUpdateInfo(
            LongIdKey messageAttachmentInfoKey, String originName, long length, InputStream content
    ) {
        this.messageAttachmentInfoKey = messageAttachmentInfoKey;
        this.originName = originName;
        this.length = length;
        this.content = content;
    }

    public LongIdKey getMessageAttachmentInfoKey() {
        return messageAttachmentInfoKey;
    }

    public void setMessageAttachmentInfoKey(LongIdKey messageAttachmentInfoKey) {
        this.messageAttachmentInfoKey = messageAttachmentInfoKey;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageAttachmentStreamUpdateInfo{" +
                "messageAttachmentInfoKey=" + messageAttachmentInfoKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", content=" + content +
                '}';
    }
}
