package com.dwarfeng.familyhelper.clannad.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 证件权限主键。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class HibernatePoceKey implements Key {

    private static final long serialVersionUID = 1651196703543656862L;

    private Long certificateId;
    private String userId;

    public HibernatePoceKey() {
    }

    public HibernatePoceKey(Long certificateId, String userId) {
        this.certificateId = certificateId;
        this.userId = userId;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
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

        HibernatePoceKey poceKey = (HibernatePoceKey) o;

        if (!Objects.equals(certificateId, poceKey.certificateId)) return false;
        return Objects.equals(userId, poceKey.userId);
    }

    @Override
    public int hashCode() {
        int result = certificateId != null ? certificateId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HibernatePoceKey{" +
                "certificateId=" + certificateId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
