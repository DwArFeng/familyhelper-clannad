package com.dwarfeng.familyhelper.clannad.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 通知节点主键。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class HibernateNotifyNodeKey implements Key {

    private static final long serialVersionUID = 9099497954063774605L;

    private Long notifySettingId;
    private String notifyTopicId;
    private String userId;

    public HibernateNotifyNodeKey() {
    }

    public HibernateNotifyNodeKey(Long notifySettingId, String notifyTopicId, String userId) {
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

        HibernateNotifyNodeKey that = (HibernateNotifyNodeKey) o;

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
        return "NotifyNodeKey{" +
                "notifySettingId=" + notifySettingId +
                ", notifyTopicId='" + notifyTopicId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
