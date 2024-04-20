package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.io.InputStream;

/**
 * 证件文件流。
 *
 * @author DwArFeng
 * @since 1.4.1
 */
public class CertificateFileStream implements Dto {

    private static final long serialVersionUID = -6713703275066340339L;

    private String originName;
    private long length;
    private InputStream content;

    public CertificateFileStream() {
    }

    public CertificateFileStream(String originName, long length, InputStream content) {
        this.originName = originName;
        this.length = length;
        this.content = content;
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
        return "CertificateFileStream{" +
                "originName='" + originName + '\'' +
                ", length=" + length +
                ", content=" + content +
                '}';
    }
}
