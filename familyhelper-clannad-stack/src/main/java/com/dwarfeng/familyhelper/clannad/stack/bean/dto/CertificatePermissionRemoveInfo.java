package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 证件权限删除信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificatePermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = 7218597641423742979L;

    private LongIdKey certificateKey;
    private StringIdKey userKey;

    public CertificatePermissionRemoveInfo() {
    }

    public CertificatePermissionRemoveInfo(LongIdKey certificateKey, StringIdKey userKey) {
        this.certificateKey = certificateKey;
        this.userKey = userKey;
    }

    public LongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(LongIdKey certificateKey) {
        this.certificateKey = certificateKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "CertificatePermissionRemoveInfo{" +
                "certificateKey=" + certificateKey +
                ", userKey=" + userKey +
                '}';
    }
}
