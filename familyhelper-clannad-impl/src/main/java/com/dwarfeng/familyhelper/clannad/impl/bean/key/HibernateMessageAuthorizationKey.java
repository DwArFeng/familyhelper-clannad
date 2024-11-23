package com.dwarfeng.familyhelper.clannad.impl.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * Hibernate 留言授权键。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class HibernateMessageAuthorizationKey implements Key {

    private static final long serialVersionUID = 840395227005739501L;

    private String receiveUserId;
    private String authorizedSendUserId;

    public HibernateMessageAuthorizationKey() {
    }

    public HibernateMessageAuthorizationKey(String receiveUserId, String authorizedSendUserId) {
        this.receiveUserId = receiveUserId;
        this.authorizedSendUserId = authorizedSendUserId;
    }

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getAuthorizedSendUserId() {
        return authorizedSendUserId;
    }

    public void setAuthorizedSendUserId(String authorizedSendUserId) {
        this.authorizedSendUserId = authorizedSendUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        HibernateMessageAuthorizationKey that = (HibernateMessageAuthorizationKey) o;
        return Objects.equals(receiveUserId, that.receiveUserId) && Objects.equals(authorizedSendUserId, that.authorizedSendUserId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(receiveUserId);
        result = 31 * result + Objects.hashCode(authorizedSendUserId);
        return result;
    }

    @Override
    public String toString() {
        return "HibernateMessageAuthorizationKey{" +
                "receiveUserId='" + receiveUserId + '\'' +
                ", authorizedSendUserId='" + authorizedSendUserId + '\'' +
                '}';
    }
}
