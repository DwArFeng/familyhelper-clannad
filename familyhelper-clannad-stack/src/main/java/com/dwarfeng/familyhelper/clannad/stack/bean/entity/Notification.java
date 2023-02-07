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

    private static final long serialVersionUID = -333833693720802907L;

    private LongIdKey key;
    private StringIdKey userKey;
    private String remark;
    private Date notifiedDate;
    private Date readDate;
    private boolean readFlag;

    /**
     * @since 1.3.0
     */
    public String subject;

    /**
     * @since 1.3.0
     */
    public String body;

    public Notification() {
    }

    public Notification(
            LongIdKey key, StringIdKey userKey, String remark, Date notifiedDate, Date readDate, boolean readFlag,
            String subject, String body
    ) {
        this.key = key;
        this.userKey = userKey;
        this.remark = remark;
        this.notifiedDate = notifiedDate;
        this.readDate = readDate;
        this.readFlag = readFlag;
        this.subject = subject;
        this.body = body;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "key=" + key +
                ", userKey=" + userKey +
                ", remark='" + remark + '\'' +
                ", notifiedDate=" + notifiedDate +
                ", readDate=" + readDate +
                ", readFlag=" + readFlag +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
