package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 证件创建信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificateCreateInfo implements Dto {

    private static final long serialVersionUID = 3583285269086870559L;

    private String name;
    private String remark;

    public CertificateCreateInfo() {
    }

    public CertificateCreateInfo(String name, String remark) {
        this.name = name;
        this.remark = remark;
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
        return "CertificateCreateInfo{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
