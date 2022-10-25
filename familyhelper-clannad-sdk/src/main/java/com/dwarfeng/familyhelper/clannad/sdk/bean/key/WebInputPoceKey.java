package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * FastJson 证件权限主键。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputPoceKey implements Key {

    private static final long serialVersionUID = 7047900779043777808L;

    public static PoceKey toStackBean(WebInputPoceKey webInputPoceKey) {
        if (Objects.isNull(webInputPoceKey)) {
            return null;
        } else {
            return new PoceKey(
                    webInputPoceKey.getCertificateId(), webInputPoceKey.getUserId()
            );
        }
    }

    @JSONField(name = "certificate_id")
    @NotNull
    private Long certificateId;

    @JSONField(name = "user_id")
    @NotEmpty
    @NotNull
    @Length(max = Constraints.LENGTH_ID)
    private String userId;

    public WebInputPoceKey() {
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

        WebInputPoceKey that = (WebInputPoceKey) o;

        if (!Objects.equals(certificateId, that.certificateId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = certificateId != null ? certificateId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WebInputPoceKey{" +
                "certificateId=" + certificateId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
