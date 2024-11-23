package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 留言附件信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class JSFixedFastJsonMessageAttachmentInfo implements Bean {

    private static final long serialVersionUID = -5768025438963966846L;

    public static JSFixedFastJsonMessageAttachmentInfo of(MessageAttachmentInfo messageAttachmentInfo) {
        if (Objects.isNull(messageAttachmentInfo)) {
            return null;
        } else {
            return new JSFixedFastJsonMessageAttachmentInfo(
                    JSFixedFastJsonLongIdKey.of(messageAttachmentInfo.getKey()),
                    JSFixedFastJsonLongIdKey.of(messageAttachmentInfo.getMessageKey()),
                    messageAttachmentInfo.getOriginName(),
                    messageAttachmentInfo.getLength(),
                    messageAttachmentInfo.getUploadDate(),
                    messageAttachmentInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "message_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey messageKey;

    @JSONField(name = "origin_name", ordinal = 3)
    private String originName;

    @JSONField(name = "length", ordinal = 4)
    private long length;

    @JSONField(name = "upload_date", ordinal = 5)
    private Date uploadDate;

    @JSONField(name = "remark", ordinal = 6)
    private String remark;

    public JSFixedFastJsonMessageAttachmentInfo() {
    }

    public JSFixedFastJsonMessageAttachmentInfo(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey messageKey, String originName, long length,
            Date uploadDate, String remark
    ) {
        this.key = key;
        this.messageKey = messageKey;
        this.originName = originName;
        this.length = length;
        this.uploadDate = uploadDate;
        this.remark = remark;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
    }

    public JSFixedFastJsonLongIdKey getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(JSFixedFastJsonLongIdKey messageKey) {
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
        return "JSFixedFastJsonMessageAttachmentInfo{" +
                "key=" + key +
                ", messageKey=" + messageKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
