package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 个人简介类型指示器主键。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class WebInputProfileTypeIndicatorKey implements Key {

    private static final long serialVersionUID = -5259236580620283888L;

    public static ProfileTypeIndicatorKey toStackBean(WebInputProfileTypeIndicatorKey key) {
        if (Objects.isNull(key)) {
            return null;
        } else {
            return new ProfileTypeIndicatorKey(key.getCategoryId(), key.getStringId());
        }
    }

    @JSONField(name = "category_id")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_ID)
    private String categoryId;

    @JSONField(name = "string_id")
    @NotNull
    @NotEmpty
    @Length(max = Constraints.LENGTH_ID)
    private String stringId;

    public WebInputProfileTypeIndicatorKey() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebInputProfileTypeIndicatorKey that = (WebInputProfileTypeIndicatorKey) o;

        if (!Objects.equals(categoryId, that.categoryId)) return false;
        return Objects.equals(stringId, that.stringId);
    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (stringId != null ? stringId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WebInputProfileTypeIndicatorKey{" +
                "categoryId='" + categoryId + '\'' +
                ", stringId='" + stringId + '\'' +
                '}';
    }
}
