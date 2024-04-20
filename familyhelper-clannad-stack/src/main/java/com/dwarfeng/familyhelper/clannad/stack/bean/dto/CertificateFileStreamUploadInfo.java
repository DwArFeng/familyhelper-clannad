package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.io.InputStream;

/**
 * 证件文件流上传信息。
 *
 * @author DwArFeng
 * @since 1.4.1
 */
public class CertificateFileStreamUploadInfo implements Dto {

    private static final long serialVersionUID = -3302381973606128566L;

    private LongIdKey certificateKey;
    private String originName;
    private long length;
    private InputStream content;

    public CertificateFileStreamUploadInfo() {
    }

    public CertificateFileStreamUploadInfo(
            LongIdKey certificateKey, String originName, long length, InputStream content
    ) {
        this.certificateKey = certificateKey;
        this.originName = originName;
        this.length = length;
        this.content = content;
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

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CertificateFileStreamUploadInfo{" +
                "certificateKey=" + certificateKey +
                ", originName='" + originName + '\'' +
                ", length=" + length +
                ", content=" + content +
                '}';
    }
}
