package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

/**
 * WebInput 通知偏好更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputNotifyPreferenceUpdateInfo implements Dto {

    private static final long serialVersionUID = -5881393465079483527L;

    public static NotifyPreferenceUpdateInfo toStackBean(WebInputNotifyPreferenceUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new NotifyPreferenceUpdateInfo(
                    WebInputLongIdKey.toStackBean(webInput.getNotifySettingKey()),
                    WebInputStringIdKey.toStackBean(webInput.getNotifyTopicKey()),
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.isPreferred(), webInput.getCoolDownDuration()
            );
        }
    }

    @JSONField(name = "notify_setting_key")
    @NotNull
    @Valid
    private WebInputLongIdKey notifySettingKey;

    @JSONField(name = "notify_topic_key")
    @NotNull
    @Valid
    private WebInputStringIdKey notifyTopicKey;

    @JSONField(name = "user_key")
    @NotNull
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "preferred")
    private boolean preferred;

    @JSONField(name = "cool_down_duration")
    @PositiveOrZero
    private long coolDownDuration;

    public WebInputNotifyPreferenceUpdateInfo() {
    }

    public WebInputLongIdKey getNotifySettingKey() {
        return notifySettingKey;
    }

    public void setNotifySettingKey(WebInputLongIdKey notifySettingKey) {
        this.notifySettingKey = notifySettingKey;
    }

    public WebInputStringIdKey getNotifyTopicKey() {
        return notifyTopicKey;
    }

    public void setNotifyTopicKey(WebInputStringIdKey notifyTopicKey) {
        this.notifyTopicKey = notifyTopicKey;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
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
        return "WebInputNotifyPreferenceUpdateInfo{" +
                "notifySettingKey=" + notifySettingKey +
                ", notifyTopicKey=" + notifyTopicKey +
                ", userKey=" + userKey +
                ", preferred=" + preferred +
                ", coolDownDuration=" + coolDownDuration +
                '}';
    }
}
