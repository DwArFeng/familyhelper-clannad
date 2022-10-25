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

    private static final long serialVersionUID = 3693318437329687039L;

    public static FastJsonNotifyTopic of(NotifyTopic notifyTopic) {
        if (Objects.isNull(notifyTopic)) {
            return null;
        } else {
            return new FastJsonNotifyTopic(
                    FastJsonStringIdKey.of(notifyTopic.getKey()),
                    notifyTopic.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    public FastJsonNotifyTopic() {
    }

    public FastJsonNotifyTopic(FastJsonStringIdKey key, String remark) {
        this.key = key;
        this.remark = remark;
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

    @Override
    public String toString() {
        return "FastJsonNotifyTopic{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
