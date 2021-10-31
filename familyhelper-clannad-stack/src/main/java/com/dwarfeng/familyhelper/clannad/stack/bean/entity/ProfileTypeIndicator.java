package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 个人简介类型指示器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ProfileTypeIndicator implements Entity<ProfileTypeIndicatorKey> {

    private static final long serialVersionUID = -3736121959726696475L;

    private ProfileTypeIndicatorKey key;
    private String label;
    private String remark;

    public ProfileTypeIndicator() {
    }

    public ProfileTypeIndicator(ProfileTypeIndicatorKey key, String label, String remark) {
        this.key = key;
        this.label = label;
        this.remark = remark;
    }

    @Override
    public ProfileTypeIndicatorKey getKey() {
        return key;
    }

    @Override
    public void setKey(ProfileTypeIndicatorKey key) {
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
        return "ProfileTypeIndicator{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
