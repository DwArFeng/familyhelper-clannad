package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 头像信息。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class FastJsonAvatarInfo implements Bean {

    private static final long serialVersionUID = -5024227854213012519L;

    public static FastJsonAvatarInfo of(AvatarInfo avatarInfo) {
        if (Objects.isNull(avatarInfo)) {
            return null;
        } else {
            return new FastJsonAvatarInfo(
                    FastJsonStringIdKey.of(avatarInfo.getKey()), avatarInfo.getOriginName(), avatarInfo.getLength(),
                    avatarInfo.getUploadDate(), avatarInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "origin_name", ordinal = 2)
    private String originName;

    @JSONField(name = "length", ordinal = 3)
    private long length;

    @JSONField(name = "upload_date", ordinal = 4)
    private Date uploadDate;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    public FastJsonAvatarInfo() {
    }

    public FastJsonAvatarInfo(FastJsonStringIdKey key, String originName, long length, Date uploadDate, String remark) {
        this.key = key;
        this.originName = originName;
        this.length = length;
        this.uploadDate = uploadDate;
        this.remark = remark;
    }

    public FastJsonStringIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonStringIdKey key) {
        this.key = key;
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
        return "FastJsonAvatarInfo{" +
                "key=" + key +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
