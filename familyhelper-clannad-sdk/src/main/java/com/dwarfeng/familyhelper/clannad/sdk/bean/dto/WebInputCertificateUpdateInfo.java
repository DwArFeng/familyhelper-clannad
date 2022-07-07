package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 证件更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputCertificateUpdateInfo implements Dto {

    private static final long serialVersionUID = 4529248808968965576L;

    public static CertificateUpdateInfo toStackBean(WebInputCertificateUpdateInfo webInputCertificateUpdateInfo) {
        if (Objects.isNull(webInputCertificateUpdateInfo)) {
            return null;
        } else {
            return new CertificateUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInputCertificateUpdateInfo.getCertificateKey()),
                    webInputCertificateUpdateInfo.getName(),
                    webInputCertificateUpdateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "account_book_key")
    @Valid
    @NotNull
    private WebInputLongIdKey certificateKey;

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @JSONField(name = "remark")
    private String remark;

    public WebInputCertificateUpdateInfo() {
    }

    public WebInputLongIdKey getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(WebInputLongIdKey certificateKey) {
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
        return "WebInputCertificateUpdateInfo{" +
                "certificateKey=" + certificateKey +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
