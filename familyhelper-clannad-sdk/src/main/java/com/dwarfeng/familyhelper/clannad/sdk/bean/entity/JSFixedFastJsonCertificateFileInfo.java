package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 证书文件信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class JSFixedFastJsonCertificateFileInfo implements Bean {

    private static final long serialVersionUID = -6153701656867299522L;

    public static JSFixedFastJsonCertificateFileInfo of(CertificateFileInfo certificateFileInfo) {
        if (Objects.isNull(certificateFileInfo)) {
            return null;
        } else {
            return new JSFixedFastJsonCertificateFileInfo(
                    JSFixedFastJsonLongIdKey.of(certificateFileInfo.getKey()),
                    JSFixedFastJsonLongIdKey.of(certificateFileInfo.getCertificateKey()),
                    certificateFileInfo.getOriginName(), certificateFileInfo.getLength(),
                    certificateFileInfo.getUploadDate(), certificateFileInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "certificate_key", ordinal = 2)
    private JSFixedFastJsonLongIdKey certificateKey;

    @JSONField(name = "origin_name", ordinal = 3)
    private String originName;

    @JSONField(name = "length", ordinal = 4)
    private long length;

    @JSONField(name = "upload_date", ordinal = 5)
    private Date uploadDate;

    @JSONField(name = "remark", ordinal = 6)
    private String remark;

    public JSFixedFastJsonCertificateFileInfo() {
    }

    public JSFixedFastJsonCertificateFileInfo(
            JSFixedFastJsonLongIdKey key, JSFixedFastJsonLongIdKey certificateKey, String originName, long length,
            Date uploadDate, String remark
    ) {
        this.key = key;
        this.certificateKey = certificateKey;
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

    public JSFixedFastJsonLongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(JSFixedFastJsonLongIdKey certificateKey) {
        this.certificateKey = certificateKey;
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
        return "JSFixedFastJsonCertificateFileInfo{" +
                "key=" + key +
                ", certificateKey=" + certificateKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
