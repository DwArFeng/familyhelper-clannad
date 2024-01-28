package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Arrays;

/**
 * 证件缩略图。
 *
 * @author DwArFeng
 * @since 1.4.0
 */
public class CertificateThumbnail implements Dto {

    private static final long serialVersionUID = -45478141774655971L;

    private String originName;
    private byte[] content;

    public CertificateThumbnail() {
    }

    public CertificateThumbnail(String originName, byte[] content) {
        this.originName = originName;
        this.content = content;
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
        return "CertificateThumbnail{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
