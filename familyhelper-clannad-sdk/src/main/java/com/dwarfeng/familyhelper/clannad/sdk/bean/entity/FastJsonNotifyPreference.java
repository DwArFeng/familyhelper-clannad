package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonNotifyNodeKey;
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

    private static final long serialVersionUID = -7722345955325529257L;

    public static FastJsonNotifyPreference of(NotifyPreference notifyPreference) {
        if (Objects.isNull(notifyPreference)) {
            return null;
        } else {
            return new FastJsonNotifyPreference(
                    FastJsonNotifyNodeKey.of(notifyPreference.getKey()),
                    notifyPreference.isPreferred(), notifyPreference.getCoolDownDuration(), notifyPreference.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonNotifyNodeKey key;

    @JSONField(name = "preferred", ordinal = 2)
    private boolean preferred;

    @JSONField(name = "cool_down_duration", ordinal = 3)
    private long coolDownDuration;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    public FastJsonNotifyPreference() {
    }

    public FastJsonNotifyPreference(
            FastJsonNotifyNodeKey key, Boolean preferred, Long coolDownDuration, String remark
    ) {
        this.key = key;
        this.preferred = preferred;
        this.coolDownDuration = coolDownDuration;
        this.remark = remark;
    }

    public FastJsonNotifyNodeKey getKey() {
        return key;
    }

    public void setKey(FastJsonNotifyNodeKey key) {
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
        return "FastJsonNotifyPreference{" +
                "key=" + key +
                ", preferred=" + preferred +
                ", coolDownDuration=" + coolDownDuration +
                ", remark='" + remark + '\'' +
                '}';
    }
}
