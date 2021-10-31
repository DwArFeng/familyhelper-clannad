package com.dwarfeng.familyhelper.clannad.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 个人简介权限主键。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class HibernatePoprKey implements Key {

    private static final long serialVersionUID = 5130653104638694301L;

    private String profileId;
    private String userId;

    public HibernatePoprKey() {
    }

    public HibernatePoprKey(String profileId, String userId) {
        this.profileId = profileId;
        this.userId = userId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
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

        HibernatePoprKey that = (HibernatePoprKey) o;

        if (!Objects.equals(profileId, that.profileId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = profileId != null ? profileId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HibernatePoprKey{" +
                "profileId='" + profileId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
