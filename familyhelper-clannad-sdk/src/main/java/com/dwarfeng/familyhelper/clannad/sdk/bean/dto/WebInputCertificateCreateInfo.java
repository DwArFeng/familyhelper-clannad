package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateCreateInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 证件创建信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputCertificateCreateInfo implements Dto {

    private static final long serialVersionUID = -2129001834668815598L;

    public static CertificateCreateInfo toStackBean(WebInputCertificateCreateInfo webInputCertificateCreateInfo) {
        if (Objects.isNull(webInputCertificateCreateInfo)) {
            return null;
        } else {
            return new CertificateCreateInfo(
                    webInputCertificateCreateInfo.getName(),
                    webInputCertificateCreateInfo.getRemark()
            );
        }
    }

    @JSONField(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @JSONField(name = "remark")
    private String remark;

    public WebInputCertificateCreateInfo() {
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
        return "WebInputCertificateCreateInfo{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
