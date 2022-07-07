package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 证书文件信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonCertificateFileInfo implements Bean {

    private static final long serialVersionUID = 2308207864058635138L;

    public static FastJsonCertificateFileInfo of(CertificateFileInfo certificateFileInfo) {
        if (Objects.isNull(certificateFileInfo)) {
            return null;
        } else {
            return new FastJsonCertificateFileInfo(
                    FastJsonLongIdKey.of(certificateFileInfo.getKey()),
                    FastJsonLongIdKey.of(certificateFileInfo.getCertificateKey()),
                    certificateFileInfo.getOriginName(), certificateFileInfo.getLength(),
                    certificateFileInfo.getUploadDate(), certificateFileInfo.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "certificate_key", ordinal = 2)
    private FastJsonLongIdKey certificateKey;

    @JSONField(name = "origin_name", ordinal = 3)
    private String originName;

    @JSONField(name = "length", ordinal = 4)
    private long length;

    @JSONField(name = "upload_date", ordinal = 5)
    private Date uploadDate;

    @JSONField(name = "remark", ordinal = 6)
    private String remark;

    public FastJsonCertificateFileInfo() {
    }

    public FastJsonCertificateFileInfo(
            FastJsonLongIdKey key, FastJsonLongIdKey certificateKey, String originName, long length,
            Date uploadDate, String remark
    ) {
        this.key = key;
        this.certificateKey = certificateKey;
        this.originName = originName;
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

    public FastJsonLongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(FastJsonLongIdKey certificateKey) {
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
        return "FastJsonCertificateFileInfo{" +
                "key=" + key +
                ", certificateKey=" + certificateKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
