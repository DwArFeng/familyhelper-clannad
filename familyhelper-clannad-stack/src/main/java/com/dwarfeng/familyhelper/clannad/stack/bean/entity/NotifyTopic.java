package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 通知主题。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyTopic implements Entity<StringIdKey> {

    private static final long serialVersionUID = 7851669075373085280L;
    
    private StringIdKey key;
    private String remark;
    private boolean preferred;
    private long coolDownDuration;
    private String executorType;
    private String executorParam;

    public NotifyTopic() {
    }

    public NotifyTopic(
            StringIdKey key, String remark, boolean preferred, long coolDownDuration, String executorType,
            String executorParam
    ) {
        this.key = key;
        this.remark = remark;
        this.preferred = preferred;
        this.coolDownDuration = coolDownDuration;
        this.executorType = executorType;
        this.executorParam = executorParam;
    }

    @Override
    public StringIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(StringIdKey key) {
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

    public String getExecutorType() {
        return executorType;
    }

    public void setExecutorType(String executorType) {
        this.executorType = executorType;
    }

    public String getExecutorParam() {
        return executorParam;
    }

    public void setExecutorParam(String executorParam) {
        this.executorParam = executorParam;
    }

    @Override
    public String toString() {
        return "NotifyTopic{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", preferred=" + preferred +
                ", coolDownDuration=" + coolDownDuration +
                ", executorType='" + executorType + '\'' +
                ", executorParam='" + executorParam + '\'' +
                '}';
    }
}
