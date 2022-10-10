package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 通知偏好。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyPreference implements Entity<NotifyNodeKey> {

    private static final long serialVersionUID = 8530539319392878791L;
    
    private NotifyNodeKey key;
    private boolean preferred;
    private long coolDownDuration;
    private String remark;

    public NotifyPreference() {
    }

    public NotifyPreference(NotifyNodeKey key, boolean preferred, long coolDownDuration, String remark) {
        this.key = key;
        this.preferred = preferred;
        this.coolDownDuration = coolDownDuration;
        this.remark = remark;
    }

    @Override
    public NotifyNodeKey getKey() {
        return key;
    }

    @Override
    public void setKey(NotifyNodeKey key) {
        this.key = key;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public long getCoolDownDuration() {
        return coolDownDuration;
    }

    public void setCoolDownDuration(long coolDownDuration) {
        this.coolDownDuration = coolDownDuration;
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
                ", coolDownDuration=" + coolDownDuration +
                ", remark='" + remark + '\'' +
                '}';
    }
}
