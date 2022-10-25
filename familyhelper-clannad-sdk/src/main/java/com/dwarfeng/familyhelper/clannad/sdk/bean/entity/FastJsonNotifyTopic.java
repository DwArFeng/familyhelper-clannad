package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 主题设置。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonNotifyTopic implements Bean {

    private static final long serialVersionUID = -9140255108605173561L;

    public static FastJsonNotifyTopic of(NotifyTopic notifyTopic) {
        if (Objects.isNull(notifyTopic)) {
            return null;
        } else {
            return new FastJsonNotifyTopic(
                    FastJsonStringIdKey.of(notifyTopic.getKey()),
                    notifyTopic.getRemark(), notifyTopic.isPreferred(), notifyTopic.getCoolDownDuration()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    @JSONField(name = "preferred", ordinal = 3)
    private boolean preferred;

    @JSONField(name = "cool_down_duration", ordinal = 4)
    private long coolDownDuration;

    public FastJsonNotifyTopic() {
    }

    public FastJsonNotifyTopic(FastJsonStringIdKey key, String remark, boolean preferred, long coolDownDuration) {
        this.key = key;
        this.remark = remark;
        this.preferred = preferred;
        this.coolDownDuration = coolDownDuration;
    }

    public FastJsonStringIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonStringIdKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    public String toString() {
        return "FastJsonNotifyTopic{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", preferred=" + preferred +
                ", coolDownDuration=" + coolDownDuration +
                '}';
    }
}
