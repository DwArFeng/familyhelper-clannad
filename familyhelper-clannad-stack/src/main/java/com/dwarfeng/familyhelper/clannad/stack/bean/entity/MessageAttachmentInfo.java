package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 留言附件信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAttachmentInfo implements Entity<LongIdKey> {

    private static final long serialVersionUID = -8613788542381994369L;

    private LongIdKey key;
    private LongIdKey messageKey;
    private String originName;
    private long length;
    private Date uploadDate;
    private String remark;

    public MessageAttachmentInfo() {
    }

    public MessageAttachmentInfo(
            LongIdKey key, LongIdKey messageKey, String originName, long length, Date uploadDate, String remark
    ) {
        this.key = key;
        this.messageKey = messageKey;
        this.originName = originName;
        this.length = length;
        this.uploadDate = uploadDate;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MessageAttachmentInfo{" +
                "key=" + key +
                ", messageKey=" + messageKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
