package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.JSFixedFastJsonNotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 通知偏好。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class JSFixedFastJsonNotifyPreference implements Bean {

    private static final long serialVersionUID = -1160213313347746267L;

    public static JSFixedFastJsonNotifyPreference of(NotifyPreference notifyPreference) {
        if (Objects.isNull(notifyPreference)) {
            return null;
        } else {
            return new JSFixedFastJsonNotifyPreference(
                    JSFixedFastJsonNotifyNodeKey.of(notifyPreference.getKey()),
                    notifyPreference.isPreferred(), notifyPreference.getCoolDown(), notifyPreference.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonNotifyNodeKey key;

    @JSONField(name = "preferred", ordinal = 2)
    private boolean preferred;

    @JSONField(name = "cool_down", ordinal = 3)
    private long coolDown;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    public JSFixedFastJsonNotifyPreference() {
    }

    public JSFixedFastJsonNotifyPreference(
            JSFixedFastJsonNotifyNodeKey key, boolean preferred, long coolDown, String remark
    ) {
        this.key = key;
        this.preferred = preferred;
        this.coolDown = coolDown;
        this.remark = remark;
    }

    public JSFixedFastJsonNotifyNodeKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonNotifyNodeKey key) {
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
        return "JSFixedFastJsonNotifyPreference{" +
                "key=" + key +
                ", preferred=" + preferred +
                ", coolDown=" + coolDown +
                ", remark='" + remark + '\'' +
                '}';
    }
}