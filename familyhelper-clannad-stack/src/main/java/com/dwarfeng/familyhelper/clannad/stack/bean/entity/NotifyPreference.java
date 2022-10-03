package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 通知偏好。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyPreference implements Entity<NotifyPreferenceKey> {

    private static final long serialVersionUID = 7619300314999245270L;

    private NotifyPreferenceKey key;
    private boolean preferred;
    private String remark;

    public NotifyPreference() {
    }

    public NotifyPreference(NotifyPreferenceKey key, boolean preferred, String remark) {
        this.key = key;
        this.preferred = preferred;
        this.remark = remark;
    }

    @Override
    public NotifyPreferenceKey getKey() {
        return key;
    }

    @Override
    public void setKey(NotifyPreferenceKey key) {
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
        return "NotifyPreference{" +
                "key=" + key +
                ", preferred=" + preferred +
                ", remark='" + remark + '\'' +
                '}';
    }
}
