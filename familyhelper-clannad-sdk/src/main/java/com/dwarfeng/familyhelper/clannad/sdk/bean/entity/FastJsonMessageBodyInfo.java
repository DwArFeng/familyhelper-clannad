package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 留言正文信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class FastJsonMessageBodyInfo implements Bean {

    private static final long serialVersionUID = -2676325351926562268L;

    public static FastJsonMessageBodyInfo of(MessageBodyInfo messageBodyInfo) {
        if (Objects.isNull(messageBodyInfo)) {
            return null;
        } else {
            return new FastJsonMessageBodyInfo(
                    FastJsonLongIdKey.of(messageBodyInfo.getKey()),
                    messageBodyInfo.getLength(),
                    messageBodyInfo.getUploadDate(),
                    messageBodyInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "length", ordinal = 2)
    private long length;

    @JSONField(name = "upload_date", ordinal = 3)
    private Date uploadDate;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    public FastJsonMessageBodyInfo() {
    }

    public FastJsonMessageBodyInfo(FastJsonLongIdKey key, long length, Date uploadDate, String remark) {
        this.key = key;
        this.length = length;
        this.uploadDate = uploadDate;
        this.remark = remark;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
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
        return "FastJsonMessageBodyInfo{" +
                "key=" + key +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
