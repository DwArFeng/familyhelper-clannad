package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 留言授权主键。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class WebInputMessageAuthorizationKey implements Key {

    private static final long serialVersionUID = 7426903675538662020L;

    public static MessageAuthorizationKey toStackBean(WebInputMessageAuthorizationKey webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new MessageAuthorizationKey(
                    webInput.getReceiveUserId(),
                    webInput.getAuthorizedSendUserId()
            );
        }
    }

    @JSONField(name = "receive_user_id")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_ID)
    private String receiveUserId;

    @JSONField(name = "authorized_send_user_id")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_ID)
    private String authorizedSendUserId;

    public WebInputMessageAuthorizationKey() {
    }

    public WebInputMessageAuthorizationKey(String receiveUserId, String authorizedSendUserId) {
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

        WebInputMessageAuthorizationKey that = (WebInputMessageAuthorizationKey) o;
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
        return "WebInputMessageAuthorizationKey{" +
                "receiveUserId='" + receiveUserId + '\'' +
                ", authorizedSendUserId='" + authorizedSendUserId + '\'' +
                '}';
    }
}
