package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputNotifyPreferenceKey;
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

    private static final long serialVersionUID = 6392403795349369110L;

    public static NotifyPreference toStackBean(WebInputNotifyPreference webInputNotifyPreference) {
        if (Objects.isNull(webInputNotifyPreference)) {
            return null;
        } else {
            return new NotifyPreference(
                    WebInputNotifyPreferenceKey.toStackBean(webInputNotifyPreference.getKey()),
                    webInputNotifyPreference.isPreferred(), webInputNotifyPreference.getCoolDown(),
                    webInputNotifyPreference.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    @NotNull
    private WebInputNotifyPreferenceKey key;

    @JSONField(name = "preferred")
    private boolean preferred;

    @JSONField(name = "cool_down")
    @PositiveOrZero
    private long coolDown;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputNotifyPreference() {
    }

    public WebInputNotifyPreferenceKey getKey() {
        return key;
    }

    public void setKey(WebInputNotifyPreferenceKey key) {
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
        return "WebInputNotifyPreference{" +
                "key=" + key +
                ", preferred=" + preferred +
                ", coolDown=" + coolDown +
                ", remark='" + remark + '\'' +
                '}';
    }
}
