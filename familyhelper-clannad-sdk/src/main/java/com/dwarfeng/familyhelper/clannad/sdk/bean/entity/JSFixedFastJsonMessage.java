package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 留言。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class JSFixedFastJsonMessage implements Bean {

    private static final long serialVersionUID = 6356350287700622803L;

    public static JSFixedFastJsonMessage of(Message message) {
        if (Objects.isNull(message)) {
            return null;
        } else {
            return new JSFixedFastJsonMessage(
                    JSFixedFastJsonLongIdKey.of(message.getKey()),
                    FastJsonStringIdKey.of(message.getSendUserKey()),
                    FastJsonStringIdKey.of(message.getReceiveUserKey()),
                    message.getSubject(),
                    message.getRemark(),
                    message.getStatus(),
                    message.getSentDate(),
                    message.getReceivedDate(),
                    message.getAttachmentCount(),
                    message.getCreatedDate(),
                    message.isReceiveUserHide()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "send_user_key", ordinal = 2)
    private FastJsonStringIdKey sendUserKey;

    @JSONField(name = "receive_user_key", ordinal = 3)
    private FastJsonStringIdKey receiveUserKey;

    @JSONField(name = "subject", ordinal = 4)
    private String subject;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    @JSONField(name = "status", ordinal = 6)
    private int status;

    @JSONField(name = "sent_date", ordinal = 7)
    private Date sentDate;

    @JSONField(name = "received_date", ordinal = 8)
    private Date receivedDate;

    @JSONField(name = "attachment_count", ordinal = 9)
    private int attachmentCount;

    @JSONField(name = "created_date", ordinal = 10)
    private Date createdDate;

    @JSONField(name = "receive_user_hide", ordinal = 11)
    private boolean receiveUserHide;

    public JSFixedFastJsonMessage() {
    }

    public JSFixedFastJsonMessage(
            JSFixedFastJsonLongIdKey key, FastJsonStringIdKey sendUserKey, FastJsonStringIdKey receiveUserKey,
            String subject, String remark, int status, Date sentDate, Date receivedDate, int attachmentCount,
            Date createdDate, boolean receiveUserHide
    ) {
        this.key = key;
        this.sendUserKey = sendUserKey;
        this.receiveUserKey = receiveUserKey;
        this.subject = subject;
        this.remark = remark;
        this.status = status;
        this.sentDate = sentDate;
        this.receivedDate = receivedDate;
        this.attachmentCount = attachmentCount;
        this.createdDate = createdDate;
        this.receiveUserHide = receiveUserHide;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public FastJsonStringIdKey getSendUserKey() {
        return sendUserKey;
    }

    public void setSendUserKey(FastJsonStringIdKey sendUserKey) {
        this.sendUserKey = sendUserKey;
    }

    public FastJsonStringIdKey getReceiveUserKey() {
        return receiveUserKey;
    }

    public void setReceiveUserKey(FastJsonStringIdKey receiveUserKey) {
        this.receiveUserKey = receiveUserKey;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public int getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isReceiveUserHide() {
        return receiveUserHide;
    }

    public void setReceiveUserHide(boolean receiveUserHide) {
        this.receiveUserHide = receiveUserHide;
    }

    @Override
    public String toString() {
        return "JSFixedFastJsonMessage{" +
                "key=" + key +
                ", sendUserKey=" + sendUserKey +
                ", receiveUserKey=" + receiveUserKey +
                ", subject='" + subject + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", sentDate=" + sentDate +
                ", receivedDate=" + receivedDate +
                ", attachmentCount=" + attachmentCount +
                ", createdDate=" + createdDate +
                ", receiveUserHide=" + receiveUserHide +
                '}';
    }
}
