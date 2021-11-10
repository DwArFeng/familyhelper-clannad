package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Arrays;

/**
 * 头像下载信息。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class AvatarDownloadInfo implements Dto {

    private static final long serialVersionUID = 3589529388093777468L;

    private String originName;
    private byte[] content;

    public AvatarDownloadInfo() {
    }

    public AvatarDownloadInfo(String originName, byte[] content) {
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
        return "AvatarDownloadInfo{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
