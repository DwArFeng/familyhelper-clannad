package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 通知主题。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputNotifyTopic implements Bean {

    private static final long serialVersionUID = 1375191548557551866L;

    public static NotifyTopic toStackBean(WebInputNotifyTopic webInputNotifyTopic) {
        if (Objects.isNull(webInputNotifyTopic)) {
            return null;
        } else {
            return new NotifyTopic(
                    WebInputStringIdKey.toStackBean(webInputNotifyTopic.getKey()),
                    webInputNotifyTopic.getRemark(), webInputNotifyTopic.isPreferred(),
                    webInputNotifyTopic.getCoolDownDuration()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    @NotNull
    private WebInputStringIdKey key;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    @JSONField(name = "preferred", ordinal = 3)
    private boolean preferred;

    @JSONField(name = "cool_down_duration", ordinal = 4)
    private long coolDownDuration;

    public WebInputNotifyTopic() {
    }

    public WebInputStringIdKey getKey() {
        return key;
    }

    public void setKey(WebInputStringIdKey key) {
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
        return "WebInputNotifyTopic{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", preferred=" + preferred +
                ", coolDownDuration=" + coolDownDuration +
                '}';
    }
}
