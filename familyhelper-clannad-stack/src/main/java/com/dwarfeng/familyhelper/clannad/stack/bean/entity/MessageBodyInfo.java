package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 留言正文信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageBodyInfo implements Entity<LongIdKey> {

    private static final long serialVersionUID = 6880343691523392942L;

    private LongIdKey key;
    private long length;
    private Date uploadDate;
    private String remark;

    public MessageBodyInfo() {
    }

    public MessageBodyInfo(LongIdKey key, long length, Date uploadDate, String remark) {
        this.key = key;
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
        return "MessageBodyInfo{" +
                "key=" + key +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
