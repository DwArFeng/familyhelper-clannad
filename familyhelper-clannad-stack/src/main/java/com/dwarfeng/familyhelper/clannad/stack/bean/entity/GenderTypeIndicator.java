package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.IntegerIdKey;

/**
 * 性别类型指示器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class GenderTypeIndicator implements Entity<IntegerIdKey> {

    private static final long serialVersionUID = -2717320542685933430L;

    private IntegerIdKey key;
    private String label;
    private String remark;

    public GenderTypeIndicator() {
    }

    public GenderTypeIndicator(IntegerIdKey key, String label, String remark) {
        this.key = key;
        this.label = label;
        this.remark = remark;
    }

    @Override
    public IntegerIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(IntegerIdKey key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "GenderTypeIndicator{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}