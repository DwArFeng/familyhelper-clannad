package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * WebInput 通知。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public class WebInputNotification implements Bean {

    private static final long serialVersionUID = 7479750983633944168L;

    public static Notification toStackBean(WebInputNotification webInputNotification) {
        if (Objects.isNull(webInputNotification)) {
            return null;
        } else {
            return new Notification(
                    WebInputLongIdKey.toStackBean(webInputNotification.getKey()),
                    WebInputStringIdKey.toStackBean(webInputNotification.getUserKey()),
                    webInputNotification.getMessage(), webInputNotification.getRemark(),
                    webInputNotification.getNotifiedDate(), webInputNotification.getReadDate(),
                    webInputNotification.isReadFlag()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputLongIdKey key;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "message")
    @Length(max = Constraints.LENGTH_MESSAGE)
    private String message;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    @JSONField(name = "notified_date")
    private Date notifiedDate;

    @JSONField(name = "read_date")
    private Date readDate;

    @JSONField(name = "read_flag")
    private boolean readFlag;

    public WebInputNotification() {
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
        this.key = key;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
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
        return "WebInputNotification{" +
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
