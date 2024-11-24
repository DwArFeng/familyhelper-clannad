package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 留言附件上传信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAttachmentUploadInfo implements Dto {

    private static final long serialVersionUID = 1437889189407071611L;

    private LongIdKey messageKey;
    private String originName;
    private byte[] content;

    public MessageAttachmentUploadInfo() {
    }

    public MessageAttachmentUploadInfo(LongIdKey messageKey, String originName, byte[] content) {
        this.messageKey = messageKey;
        this.originName = originName;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageAttachmentUploadInfo{" +
                "messageKey=" + messageKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
