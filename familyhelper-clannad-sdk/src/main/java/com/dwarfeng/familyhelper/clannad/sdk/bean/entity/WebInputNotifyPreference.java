package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputNotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

/**
 * FastJson 通知偏好。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputNotifyPreference implements Bean {

    private static final long serialVersionUID = -285556433908669969L;

    public static NotifyPreference toStackBean(WebInputNotifyPreference webInputNotifyPreference) {
        if (Objects.isNull(webInputNotifyPreference)) {
            return null;
        } else {
            return new NotifyPreference(
                    WebInputNotifyNodeKey.toStackBean(webInputNotifyPreference.getKey()),
                    webInputNotifyPreference.isPreferred(), webInputNotifyPreference.getCoolDownDuration(),
                    webInputNotifyPreference.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    @NotNull
    private WebInputNotifyNodeKey key;

    @JSONField(name = "preferred")
    private boolean preferred;

    @JSONField(name = "cool_down_duration")
    @PositiveOrZero
    private long coolDownDuration;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputNotifyPreference() {
    }

    public WebInputNotifyNodeKey getKey() {
        return key;
    }

    public void setKey(WebInputNotifyNodeKey key) {
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
        return "WebInputNotifyPreference{" +
                "key=" + key +
                ", preferred=" + preferred +
                ", coolDownDuration=" + coolDownDuration +
                ", remark='" + remark + '\'' +
                '}';
    }
}
