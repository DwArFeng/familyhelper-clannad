package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 通知偏好更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyPreferenceUpdateInfo implements Dto {

    private static final long serialVersionUID = -7094629160004424642L;

    private LongIdKey notifySettingKey;
    private StringIdKey notifyTopicKey;
    private StringIdKey userKey;
    private boolean preferred;
    private long coolDown;

    public NotifyPreferenceUpdateInfo() {
    }

    public NotifyPreferenceUpdateInfo(
            LongIdKey notifySettingKey, StringIdKey notifyTopicKey, StringIdKey userKey, boolean preferred,
            long coolDown
    ) {
        this.notifySettingKey = notifySettingKey;
        this.notifyTopicKey = notifyTopicKey;
        this.userKey = userKey;
        this.preferred = preferred;
        this.coolDown = coolDown;
    }

    public LongIdKey getNotifySettingKey() {
        return notifySettingKey;
    }

    public void setNotifySettingKey(LongIdKey notifySettingKey) {
        this.notifySettingKey = notifySettingKey;
    }

    public StringIdKey getNotifyTopicKey() {
        return notifyTopicKey;
    }

    public void setNotifyTopicKey(StringIdKey notifyTopicKey) {
        this.notifyTopicKey = notifyTopicKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
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

    @Override
    public String toString() {
        return "NotifyPreferenceUpdateInfo{" +
                "notifySettingKey=" + notifySettingKey +
                ", notifyTopicKey=" + notifyTopicKey +
                ", userKey=" + userKey +
                ", preferred=" + preferred +
                ", coolDown=" + coolDown +
                '}';
    }
}
