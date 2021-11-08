package com.dwarfeng.familyhelper.clannad.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 昵称主键。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class HibernateNicknameKey implements Key {

    private static final long serialVersionUID = -5954951784849555889L;

    private String subjectUserId;
    private String objectUserId;

    public HibernateNicknameKey() {
    }

    public HibernateNicknameKey(String subjectUserId, String objectUserId) {
        this.subjectUserId = subjectUserId;
        this.objectUserId = objectUserId;
    }

    public String getSubjectUserId() {
        return subjectUserId;
    }

    public void setSubjectUserId(String subjectUserId) {
        this.subjectUserId = subjectUserId;
    }

    public String getObjectUserId() {
        return objectUserId;
    }

    public void setObjectUserId(String objectUserId) {
        this.objectUserId = objectUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HibernateNicknameKey that = (HibernateNicknameKey) o;

        if (!Objects.equals(subjectUserId, that.subjectUserId)) return false;
        return Objects.equals(objectUserId, that.objectUserId);
    }

    @Override
    public int hashCode() {
        int result = subjectUserId != null ? subjectUserId.hashCode() : 0;
        result = 31 * result + (objectUserId != null ? objectUserId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HibernateNicknameKey{" +
                "subjectUserId='" + subjectUserId + '\'' +
                ", objectUserId='" + objectUserId + '\'' +
                '}';
    }
}
