package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

import java.util.Arrays;

/**
 * 证件文件上传信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificateFileUploadInfo implements Dto {

    private static final long serialVersionUID = -8371058051732970954L;

    private LongIdKey certificateKey;
    private String originName;
    private byte[] content;

    public CertificateFileUploadInfo() {
    }

    public CertificateFileUploadInfo(LongIdKey certificateKey, String originName, byte[] content) {
        this.certificateKey = certificateKey;
        this.originName = originName;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CertificateFileUploadInfo{" +
                "certificateKey=" + certificateKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
