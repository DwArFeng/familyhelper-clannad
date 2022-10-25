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

    private static final long serialVersionUID = 7566463658655275192L;

    public static FastJsonNotifyPreference of(NotifyPreference notifyPreference) {
        if (Objects.isNull(notifyPreference)) {
            return null;
        } else {
            return new FastJsonNotifyPreference(
                    FastJsonNotifyNodeKey.of(notifyPreference.getKey()),
                    notifyPreference.isPreferred(), notifyPreference.getCoolDown(), notifyPreference.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonNotifyNodeKey key;

    @JSONField(name = "preferred", ordinal = 2)
    private boolean preferred;

    @JSONField(name = "cool_down", ordinal = 3)
    private long coolDown;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    public FastJsonNotifyPreference() {
    }

    public FastJsonNotifyPreference(
            FastJsonNotifyNodeKey key, Boolean preferred, Long coolDown, String remark
    ) {
        this.key = key;
        this.preferred = preferred;
        this.coolDown = coolDown;
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
        return "FastJsonNotifyPreference{" +
                "key=" + key +
                ", preferred=" + preferred +
                ", coolDown=" + coolDown +
                ", remark='" + remark + '\'' +
                '}';
    }
}
