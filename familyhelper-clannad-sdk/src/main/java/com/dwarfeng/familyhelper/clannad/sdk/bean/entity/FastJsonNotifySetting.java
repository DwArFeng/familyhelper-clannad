package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 通知设置。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonNotifySetting implements Bean {

    private static final long serialVersionUID = 2844876846786455914L;

    public static FastJsonNotifySetting of(NotifySetting notifySetting) {
        if (Objects.isNull(notifySetting)) {
            return null;
        } else {
            return new FastJsonNotifySetting(
                    FastJsonLongIdKey.of(notifySetting.getKey()),
                    notifySetting.getRemark(), notifySetting.getRequiredPermission()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    @JSONField(name = "required_permission", ordinal = 3)
    private String requiredPermission;

    public FastJsonNotifySetting() {
    }

    public FastJsonNotifySetting(FastJsonLongIdKey key, String remark, String requiredPermission) {
        this.key = key;
        this.remark = remark;
        this.requiredPermission = requiredPermission;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(String requiredPermission) {
        this.requiredPermission = requiredPermission;
    }

    @Override
    public String toString() {
        return "FastJsonNotifySetting{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", requiredPermission='" + requiredPermission + '\'' +
                '}';
    }
}
