package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人简介权限主键。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class WebInputPoprKey implements Key {

    private static final long serialVersionUID = 5687177869441490474L;

    public static PoprKey toStackBean(WebInputPoprKey key) {
        if (Objects.isNull(key)) {
            return null;
        } else {
            return new PoprKey(key.getProfileId(), key.getUserId());
        }
    }

    @JSONField(name = "profile_id")
    @NotEmpty
    @NotNull
    @Length(max = Constraints.LENGTH_ID)
    private String profileId;

    @JSONField(name = "user_id")
    @NotEmpty
    @NotNull
    @Length(max = Constraints.LENGTH_ID)
    private String userId;

    public WebInputPoprKey() {
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

        WebInputPoprKey that = (WebInputPoprKey) o;

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
        return "WebInputPoprKey{" +
                "profileId='" + profileId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
