package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonNotifyPreferenceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 通知偏好。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonNotifyPreference implements Bean {

    private static final long serialVersionUID = -2891224214438287683L;

    public static FastJsonNotifyPreference of(NotifyPreference notifyPreference) {
        if (Objects.isNull(notifyPreference)) {
            return null;
        } else {
            return new FastJsonNotifyPreference(
                    FastJsonNotifyPreferenceKey.of(notifyPreference.getKey()),
                    notifyPreference.isPreferred(), notifyPreference.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonNotifyPreferenceKey key;

    @JSONField(name = "preferred", ordinal = 2)
    private boolean preferred;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonNotifyPreference() {
    }

    public FastJsonNotifyPreference(FastJsonNotifyPreferenceKey key, boolean preferred, String remark) {
        this.key = key;
        this.preferred = preferred;
        this.remark = remark;
    }

    public FastJsonNotifyPreferenceKey getKey() {
        return key;
    }

    public void setKey(FastJsonNotifyPreferenceKey key) {
        this.key = key;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonNotifyPreference{" +
                "key=" + key +
                ", preferred=" + preferred +
                ", remark='" + remark + '\'' +
                '}';
    }
}
