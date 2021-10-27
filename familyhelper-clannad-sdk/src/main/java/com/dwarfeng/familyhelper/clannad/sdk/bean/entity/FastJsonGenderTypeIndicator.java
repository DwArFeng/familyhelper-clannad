package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonIntegerIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 性别类型指示器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class FastJsonGenderTypeIndicator implements Bean {

    private static final long serialVersionUID = 7715487949116853172L;

    public static FastJsonGenderTypeIndicator of(GenderTypeIndicator genderTypeIndicator) {
        if (Objects.isNull(genderTypeIndicator)) {
            return null;
        } else {
            return new FastJsonGenderTypeIndicator(
                    FastJsonIntegerIdKey.of(genderTypeIndicator.getKey()),
                    genderTypeIndicator.getLabel(),
                    genderTypeIndicator.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonIntegerIdKey key;

    @JSONField(name = "label", ordinal = 2)
    private String label;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonGenderTypeIndicator() {
    }

    public FastJsonGenderTypeIndicator(FastJsonIntegerIdKey key, String label, String remark) {
        this.key = key;
        this.label = label;
        this.remark = remark;
    }

    public FastJsonIntegerIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonIntegerIdKey key) {
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
        return "FastJsonGenderTypeIndicator{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
