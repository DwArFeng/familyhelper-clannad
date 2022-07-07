package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 证件更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificateUpdateInfo implements Dto {

    private static final long serialVersionUID = -9082084727375556913L;

    private LongIdKey certificateKey;
    private String name;
    private String remark;

    public CertificateUpdateInfo() {
    }

    public CertificateUpdateInfo(LongIdKey certificateKey, String name, String remark) {
        this.certificateKey = certificateKey;
        this.name = name;
        this.remark = remark;
    }

    public LongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(LongIdKey certificateKey) {
        this.certificateKey = certificateKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CertificateUpdateInfo{" +
                "certificateKey=" + certificateKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
