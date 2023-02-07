package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 通知。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public class JSFixedFastJsonNotification implements Bean {

    private static final long serialVersionUID = -5435116320179663794L;

    public static JSFixedFastJsonNotification of(Notification notification) {
        if (Objects.isNull(notification)) {
            return null;
        } else {
            return new JSFixedFastJsonNotification(
                    JSFixedFastJsonLongIdKey.of(notification.getKey()),
                    FastJsonStringIdKey.of(notification.getUserKey()),
                    notification.getRemark(), notification.getNotifiedDate(), notification.getReadDate(),
                    notification.isReadFlag(), notification.getSubject(), notification.getBody()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "user_key", ordinal = 2)
    private FastJsonStringIdKey userKey;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    @JSONField(name = "notified_date", ordinal = 4)
    private Date notifiedDate;

    @JSONField(name = "read_date", ordinal = 5)
    private Date readDate;

    @JSONField(name = "read_flag", ordinal = 6)
    private boolean readFlag;

    @JSONField(name = "subject", ordinal = 7)
    private String subject;

    @JSONField(name = "body", ordinal = 8)
    private String body;

    public JSFixedFastJsonNotification() {
    }

    public JSFixedFastJsonNotification(
            JSFixedFastJsonLongIdKey key, FastJsonStringIdKey userKey, String remark, Date notifiedDate,
            Date readDate, boolean readFlag, String subject, String body
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

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(FastJsonStringIdKey userKey) {
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
        return "JSFixedFastJsonNotification{" +
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
