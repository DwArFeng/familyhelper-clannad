package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Date;

/**
 * 证书文件信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificateFileInfo implements Entity<LongIdKey> {

    private static final long serialVersionUID = 7092184960649846925L;

    private LongIdKey key;
    private LongIdKey certificateKey;
    private String originName;
    private long length;
    private Date uploadDate;
    private String remark;

    public CertificateFileInfo() {
    }

    public CertificateFileInfo(
            LongIdKey key, LongIdKey certificateKey, String originName, long length, Date uploadDate, String remark
    ) {
        this.key = key;
        this.certificateKey = certificateKey;
        this.originName = originName;
        this.length = length;
        this.uploadDate = uploadDate;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public LongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(LongIdKey certificateKey) {
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
        return "CertificateFileInfo{" +
                "key=" + key +
                ", certificateKey=" + certificateKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", uploadDate=" + uploadDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
