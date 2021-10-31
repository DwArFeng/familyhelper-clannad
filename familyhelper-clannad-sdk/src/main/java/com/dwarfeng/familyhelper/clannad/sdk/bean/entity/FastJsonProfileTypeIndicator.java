package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Objects;

/**
 * FastJson 个人简介类型指示器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class FastJsonProfileTypeIndicator implements Dto {

    private static final long serialVersionUID = -7747501531082883275L;

    public static FastJsonProfileTypeIndicator of(ProfileTypeIndicator profileTypeIndicator) {
        if (Objects.isNull(profileTypeIndicator)) {
            return null;
        } else {
            return new FastJsonProfileTypeIndicator(
                    FastJsonProfileTypeIndicatorKey.of(profileTypeIndicator.getKey()), profileTypeIndicator.getLabel(),
                    profileTypeIndicator.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonProfileTypeIndicatorKey key;

    @JSONField(name = "label", ordinal = 2)
    private String label;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonProfileTypeIndicator() {
    }

    public FastJsonProfileTypeIndicator(FastJsonProfileTypeIndicatorKey key, String label, String remark) {
        this.key = key;
        this.label = label;
        this.remark = remark;
    }

    public FastJsonProfileTypeIndicatorKey getKey() {
        return key;
    }

    public void setKey(FastJsonProfileTypeIndicatorKey key) {
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
        return "FastJsonProfileTypeIndicator{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
