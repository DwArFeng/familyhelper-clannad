package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Arrays;

/**
 * 留言附件。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAttachment implements Dto {

    private static final long serialVersionUID = 6063357185291177117L;

    private String originName;
    private byte[] content;

    public MessageAttachment() {
    }

    public MessageAttachment(String originName, byte[] content) {
        this.originName = originName;
        this.content = content;
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
        return "MessageAttachment{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
