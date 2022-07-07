package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 证件。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonCertificate implements Bean {

    private static final long serialVersionUID = 4717030571155210114L;

    public static FastJsonCertificate of(Certificate certificate) {
        if (Objects.isNull(certificate)) {
            return null;
        } else {
            return new FastJsonCertificate(
                    FastJsonLongIdKey.of(certificate.getKey()),
                    certificate.getName(), certificate.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "name", ordinal = 2)
    private String name;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonCertificate() {
    }

    public FastJsonCertificate(FastJsonLongIdKey key, String name, String remark) {
        this.key = key;
        this.name = name;
        this.remark = remark;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
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
        return "FastJsonCertificate{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
