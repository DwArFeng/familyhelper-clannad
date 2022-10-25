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

    private static final long serialVersionUID = 5641349921931960508L;

    public static FastJsonNotifySetting of(NotifySetting notifySetting) {
        if (Objects.isNull(notifySetting)) {
            return null;
        } else {
            return new FastJsonNotifySetting(
                    FastJsonLongIdKey.of(notifySetting.getKey()),
                    notifySetting.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    public FastJsonNotifySetting() {
    }

    public FastJsonNotifySetting(FastJsonLongIdKey key, String remark) {
        this.key = key;
        this.remark = remark;
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

    @Override
    public String toString() {
        return "FastJsonNotifySetting{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
