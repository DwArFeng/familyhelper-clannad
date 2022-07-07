package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 证件权限主键。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonPoceKey implements Key {

    private static final long serialVersionUID = -4660712245418053891L;

    public static FastJsonPoceKey of(PoceKey poceKey) {
        if (Objects.isNull(poceKey)) {
            return null;
        } else {
            return new FastJsonPoceKey(
                    poceKey.getCertificateId(), poceKey.getUserId()
            );
        }
    }

    @JSONField(name = "certificate_id", ordinal = 1)
    private Long certificateId;

    @JSONField(name = "user_id", ordinal = 2)
    private String userId;

    public FastJsonPoceKey() {
    }

    public FastJsonPoceKey(Long certificateId, String userId) {
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

        FastJsonPoceKey that = (FastJsonPoceKey) o;

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
        return "FastJsonPoceKey{" +
                "certificateId=" + certificateId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
