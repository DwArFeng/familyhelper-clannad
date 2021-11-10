package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Arrays;

/**
 * 头像上传信息。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class AvatarUploadInfo implements Dto {

    private static final long serialVersionUID = 6728824016721487656L;

    private String originName;
    private byte[] content;

    public AvatarUploadInfo() {
    }

    public AvatarUploadInfo(String originName, byte[] content) {
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
        return "AvatarUploadInfo{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
