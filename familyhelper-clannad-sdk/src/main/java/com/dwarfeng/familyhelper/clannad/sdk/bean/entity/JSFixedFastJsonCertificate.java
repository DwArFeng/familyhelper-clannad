package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 证件。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class JSFixedFastJsonCertificate implements Bean {

    private static final long serialVersionUID = -6534863177230072170L;

    public static JSFixedFastJsonCertificate of(Certificate certificate) {
        if (Objects.isNull(certificate)) {
            return null;
        } else {
            return new JSFixedFastJsonCertificate(
                    JSFixedFastJsonLongIdKey.of(certificate.getKey()),
                    certificate.getName(), certificate.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "name", ordinal = 3)
    private String name;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    public JSFixedFastJsonCertificate() {
    }

    public JSFixedFastJsonCertificate(
            JSFixedFastJsonLongIdKey key, String name, String remark
    ) {
        this.key = key;
        this.name = name;
        this.remark = remark;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
        this.key = key;
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
        return "JSFixedFastJsonCertificate{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
