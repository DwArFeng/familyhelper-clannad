package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionRemoveInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 证件权限删除信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputCertificatePermissionRemoveInfo implements Dto {

    private static final long serialVersionUID = -6769479330330807679L;

    public static CertificatePermissionRemoveInfo toStackBean(WebInputCertificatePermissionRemoveInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new CertificatePermissionRemoveInfo(
                    WebInputLongIdKey.toStackBean(webInput.getCertificateKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey())
            );
        }
    }

    @JSONField(name = "account_book_key")
    @Valid
    private WebInputLongIdKey certificateKey;

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputCertificatePermissionRemoveInfo() {
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

    @Override
    public String toString() {
        return "WebInputCertificatePermissionRemoveInfo{" +
                "certificateKey=" + certificateKey +
                ", userKey=" + userKey +
                '}';
    }
}
