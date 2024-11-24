package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.io.InputStream;

/**
 * 留言附件流上传信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAttachmentStreamUploadInfo implements Dto {

    private static final long serialVersionUID = 3550555503103375270L;

    private LongIdKey messageKey;
    private String originName;
    private long length;
    private InputStream content;

    public MessageAttachmentStreamUploadInfo() {
    }

    public MessageAttachmentStreamUploadInfo(
            LongIdKey messageKey, String originName, long length, InputStream content
    ) {
        this.messageKey = messageKey;
        this.originName = originName;
        this.length = length;
        this.content = content;
    }

    public LongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(LongIdKey messageKey) {
        this.messageKey = messageKey;
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
        return "MessageAttachmentStreamUploadInfo{" +
                "messageKey=" + messageKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", content=" + content +
                '}';
    }
}
