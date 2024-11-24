package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 留言附件更新信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAttachmentUpdateInfo implements Dto {

    private static final long serialVersionUID = 5741727298870982684L;

    private LongIdKey messageAttachmentInfoKey;
    private String originName;
    private byte[] content;

    public MessageAttachmentUpdateInfo() {
    }

    public MessageAttachmentUpdateInfo(LongIdKey messageAttachmentInfoKey, String originName, byte[] content) {
        this.messageAttachmentInfoKey = messageAttachmentInfoKey;
        this.originName = originName;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageAttachmentUpdateInfo{" +
                "messageAttachmentInfoKey=" + messageAttachmentInfoKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
