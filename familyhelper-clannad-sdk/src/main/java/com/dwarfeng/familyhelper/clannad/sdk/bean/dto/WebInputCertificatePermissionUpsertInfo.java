package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionUpsertInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 证件权限插入或更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputCertificatePermissionUpsertInfo implements Dto {

    private static final long serialVersionUID = 7450643404732886734L;

    public static CertificatePermissionUpsertInfo toStackBean(WebInputCertificatePermissionUpsertInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new CertificatePermissionUpsertInfo(
                    WebInputLongIdKey.toStackBean(webInput.getCertificateKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getPermissionLevel()
            );
        }
    }

    @JSONField(name = "certificate_key")
    @Valid
    private WebInputLongIdKey certificateKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "permission_level")
    private int permissionLevel;

    public WebInputCertificatePermissionUpsertInfo() {
    }

    public WebInputLongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(WebInputLongIdKey certificateKey) {
        this.certificateKey = certificateKey;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
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
        return "WebInputCertificatePermissionUpsertInfo{" +
                "certificateKey=" + certificateKey +
                ", userKey=" + userKey +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
