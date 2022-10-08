package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 通知设置。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class JSFixedFastJsonNotifySetting implements Bean {

    private static final long serialVersionUID = 7536492591559922569L;

    public static JSFixedFastJsonNotifySetting of(NotifySetting notifySetting) {
        if (Objects.isNull(notifySetting)) {
            return null;
        } else {
            return new JSFixedFastJsonNotifySetting(
                    JSFixedFastJsonLongIdKey.of(notifySetting.getKey()),
                    notifySetting.getRemark(), notifySetting.getRequiredPermission()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    @JSONField(name = "required_permission", ordinal = 3)
    private String requiredPermission;

    public JSFixedFastJsonNotifySetting() {
    }

    public JSFixedFastJsonNotifySetting(JSFixedFastJsonLongIdKey key, String remark, String requiredPermission) {
        this.key = key;
        this.remark = remark;
        this.requiredPermission = requiredPermission;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
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
        return "JSFixedFastJsonNotifySetting{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", requiredPermission='" + requiredPermission + '\'' +
                '}';
    }
}
