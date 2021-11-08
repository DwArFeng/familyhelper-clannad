package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 昵称主键。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class WebInputNicknameKey implements Key {

    private static final long serialVersionUID = -4815675784112172463L;

    public static NicknameKey toStackBean(WebInputNicknameKey webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new NicknameKey(webInput.getSubjectUserId(), webInput.getObjectUserId());
        }
    }

    @JSONField(name = "subject_user_id")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_ID)
    private String subjectUserId;

    @JSONField(name = "object_user_id")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_ID)
    private String objectUserId;

    public WebInputNicknameKey() {
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

        WebInputNicknameKey that = (WebInputNicknameKey) o;

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
        return "WebInputNicknameKey{" +
                "subjectUserId='" + subjectUserId + '\'' +
                ", objectUserId='" + objectUserId + '\'' +
                '}';
    }
}
