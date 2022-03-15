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

    private static final long serialVersionUID = 30611166552055199L;

    public static JSFixedFastJsonNotification of(Notification notification) {
        if (Objects.isNull(notification)) {
            return null;
        } else {
            return new JSFixedFastJsonNotification(
                    JSFixedFastJsonLongIdKey.of(notification.getKey()),
                    FastJsonStringIdKey.of(notification.getUserKey()),
                    notification.getMessage(), notification.getRemark(), notification.getNotifiedDate(),
                    notification.getReadDate(), notification.isReadFlag()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "user_key", ordinal = 2)
    private FastJsonStringIdKey userKey;

    @JSONField(name = "message", ordinal = 3)
    private String message;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    @JSONField(name = "notified_date", ordinal = 5)
    private Date notifiedDate;

    @JSONField(name = "read_date", ordinal = 6)
    private Date readDate;

    @JSONField(name = "read_flag", ordinal = 7)
    private boolean readFlag;

    public JSFixedFastJsonNotification() {
    }

    public JSFixedFastJsonNotification(
            JSFixedFastJsonLongIdKey key, FastJsonStringIdKey userKey, String message, String remark, Date notifiedDate,
            Date readDate, boolean readFlag
    ) {
        this.key = key;
        this.userKey = userKey;
        this.message = message;
        this.remark = remark;
        this.notifiedDate = notifiedDate;
        this.readDate = readDate;
        this.readFlag = readFlag;
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
        return "JSFixedFastJsonNotification{" +
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
