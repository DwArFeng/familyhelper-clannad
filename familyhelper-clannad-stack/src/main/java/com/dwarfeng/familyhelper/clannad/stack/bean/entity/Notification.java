package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

import java.util.Date;

/**
 * 通知。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public class Notification implements Entity<LongIdKey> {

    private static final long serialVersionUID = 8915233654160727L;

    private LongIdKey key;
    private StringIdKey userKey;
    private String message;
    private String remark;
    private Date notifiedDate;
    private Date readDate;
    private boolean readFlag;

    public Notification() {
    }

    public Notification(
            LongIdKey key, StringIdKey userKey, String message, String remark, Date notifiedDate, Date readDate,
            boolean readFlag
    ) {
        this.key = key;
        this.userKey = userKey;
        this.message = message;
        this.remark = remark;
        this.notifiedDate = notifiedDate;
        this.readDate = readDate;
        this.readFlag = readFlag;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getNotifiedDate() {
        return notifiedDate;
    }

    public void setNotifiedDate(Date notifiedDate) {
        this.notifiedDate = notifiedDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public boolean isReadFlag() {
        return readFlag;
    }

    public void setReadFlag(boolean readFlag) {
        this.readFlag = readFlag;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "key=" + key +
                ", userKey=" + userKey +
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                ", notifiedDate=" + notifiedDate +
                ", readDate=" + readDate +
                ", readFlag=" + readFlag +
                '}';
    }
}
