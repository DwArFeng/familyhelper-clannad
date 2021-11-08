package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 昵称主键。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class FastJsonNicknameKey implements Key {

    private static final long serialVersionUID = 4847541984665539884L;

    public static FastJsonNicknameKey of(NicknameKey nicknameKey) {
        if (Objects.isNull(nicknameKey)) {
            return null;
        } else {
            return new FastJsonNicknameKey(nicknameKey.getSubjectUserId(), nicknameKey.getObjectUserId());
        }
    }

    @JSONField(name = "subject_user_id", ordinal = 1)
    private String subjectUserId;

    @JSONField(name = "object_user_id", ordinal = 2)
    private String objectUserId;

    public FastJsonNicknameKey() {
    }

    public FastJsonNicknameKey(String subjectUserId, String objectUserId) {
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

        FastJsonNicknameKey that = (FastJsonNicknameKey) o;

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
        return "FastJsonNicknameKey{" +
                "subjectUserId='" + subjectUserId + '\'' +
                ", objectUserId='" + objectUserId + '\'' +
                '}';
    }
}
