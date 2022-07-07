package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 证件。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class Certificate implements Entity<LongIdKey> {

    private static final long serialVersionUID = 3588949149200258095L;

    private LongIdKey key;
    private String name;
    private String remark;

    public Certificate() {
    }

    public Certificate(LongIdKey key, String name, String remark) {
        this.key = key;
        this.name = name;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
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
        return "Certificate{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
