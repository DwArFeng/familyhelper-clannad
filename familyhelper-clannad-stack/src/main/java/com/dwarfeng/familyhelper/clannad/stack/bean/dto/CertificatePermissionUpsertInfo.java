package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 证件权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificatePermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = -3532142205785259146L;

    private LongIdKey certificateKey;
    private StringIdKey userKey;
    private int permissionLevel;

    public CertificatePermissionUpsertInfo() {
    }

    public CertificatePermissionUpsertInfo(LongIdKey CertificateKey, StringIdKey userKey, int permissionLevel) {
        this.certificateKey = CertificateKey;
        this.userKey = userKey;
        this.permissionLevel = permissionLevel;
    }

    public LongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(LongIdKey CertificateKey) {
        this.certificateKey = CertificateKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "CertificatePermissionUpsertInfo{" +
                "certificateKey=" + certificateKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
