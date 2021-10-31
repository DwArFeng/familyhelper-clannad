package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 个人简介权限主键。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class FastJsonPoprKey implements Key {

    private static final long serialVersionUID = -1862452065198215079L;

    public static FastJsonPoprKey of(PoprKey key) {
        if (Objects.isNull(key)) {
            return null;
        } else {
            return new FastJsonPoprKey(key.getProfileId(), key.getUserId());
        }
    }

    @JSONField(name = "profile_id", ordinal = 1)
    private String profileId;

    @JSONField(name = "user_id", ordinal = 2)
    private String userId;

    public FastJsonPoprKey() {
    }

    public FastJsonPoprKey(String profileId, String userId) {
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

        FastJsonPoprKey that = (FastJsonPoprKey) o;

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
        return "FastJsonPoprKey{" +
                "profileId='" + profileId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
