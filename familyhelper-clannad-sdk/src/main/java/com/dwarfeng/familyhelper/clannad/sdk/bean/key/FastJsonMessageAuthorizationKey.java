package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 留言授权主键。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class FastJsonMessageAuthorizationKey implements Key {

    private static final long serialVersionUID = -6390612392930259511L;

    public static FastJsonMessageAuthorizationKey of(MessageAuthorizationKey messageAuthorizationKey) {
        if (Objects.isNull(messageAuthorizationKey)) {
            return null;
        } else {
            return new FastJsonMessageAuthorizationKey(
                    messageAuthorizationKey.getReceiveUserId(),
                    messageAuthorizationKey.getAuthorizedSendUserId()
            );
        }
    }

    @JSONField(name = "receive_user_id", ordinal = 1)
    private String receiveUserId;

    @JSONField(name = "authorized_send_user_id", ordinal = 2)
    private String authorizedSendUserId;

    public FastJsonMessageAuthorizationKey() {
    }

    public FastJsonMessageAuthorizationKey(String receiveUserId, String authorizedSendUserId) {
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

        FastJsonMessageAuthorizationKey that = (FastJsonMessageAuthorizationKey) o;
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
        return "FastJsonMessageAuthorizationKey{" +
                "receiveUserId='" + receiveUserId + '\'' +
                ", authorizedSendUserId='" + authorizedSendUserId + '\'' +
                '}';
    }
}
