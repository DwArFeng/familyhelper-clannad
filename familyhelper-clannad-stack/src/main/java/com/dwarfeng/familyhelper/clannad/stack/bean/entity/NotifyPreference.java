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

    private static final long serialVersionUID = 4859027145609947413L;

    private NotifyPreferenceKey key;
    private boolean preferred;
    private long coolDown;
    private String remark;

    public NotifyPreference() {
    }

    public NotifyPreference(NotifyPreferenceKey key, boolean preferred, long coolDown, String remark) {
        this.key = key;
        this.preferred = preferred;
        this.coolDown = coolDown;
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

    public long getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(long coolDown) {
        this.coolDown = coolDown;
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
                ", coolDown=" + coolDown +
                ", remark='" + remark + '\'' +
                '}';
    }
}
