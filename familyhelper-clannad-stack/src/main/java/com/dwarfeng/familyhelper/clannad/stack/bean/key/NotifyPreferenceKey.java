package com.dwarfeng.familyhelper.clannad.stack.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * 通知偏好主键。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyPreferenceKey implements Key {

    private static final long serialVersionUID = -7776557150605680425L;

    private Long notifySettingId;
    private String notifyTopicId;
    private String userId;

    public NotifyPreferenceKey() {
    }

    public NotifyPreferenceKey(Long notifySettingId, String notifyTopicId, String userId) {
        this.notifySettingId = notifySettingId;
        this.notifyTopicId = notifyTopicId;
        this.userId = userId;
    }

    public Long getNotifySettingId() {
        return notifySettingId;
    }

    public void setNotifySettingId(Long notifySettingId) {
        this.notifySettingId = notifySettingId;
    }

    public String getNotifyTopicId() {
        return notifyTopicId;
    }

    public void setNotifyTopicId(String notifyTopicId) {
        this.notifyTopicId = notifyTopicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotifyPreferenceKey that = (NotifyPreferenceKey) o;

        if (!Objects.equals(notifySettingId, that.notifySettingId))
            return false;
        if (!Objects.equals(notifyTopicId, that.notifyTopicId))
            return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = notifySettingId != null ? notifySettingId.hashCode() : 0;
        result = 31 * result + (notifyTopicId != null ? notifyTopicId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NotifyPreferenceKey{" +
                "notifySettingId=" + notifySettingId +
                ", notifyTopicId='" + notifyTopicId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
