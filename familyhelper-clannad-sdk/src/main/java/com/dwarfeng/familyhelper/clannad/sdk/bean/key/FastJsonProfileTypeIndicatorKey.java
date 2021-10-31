package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * FastJson 个人简介类型指示器主键。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class FastJsonProfileTypeIndicatorKey implements Key {

    private static final long serialVersionUID = 4385645823088593159L;

    public static FastJsonProfileTypeIndicatorKey of(ProfileTypeIndicatorKey key) {
        if (Objects.isNull(key)) {
            return null;
        } else {
            return new FastJsonProfileTypeIndicatorKey(key.getCategoryId(), key.getStringId());
        }
    }

    @JSONField(name = "category_id", ordinal = 1)
    private String categoryId;

    @JSONField(name = "string_id", ordinal = 2)
    private String stringId;

    public FastJsonProfileTypeIndicatorKey() {
    }

    public FastJsonProfileTypeIndicatorKey(String categoryId, String stringId) {
        this.categoryId = categoryId;
        this.stringId = stringId;
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

        FastJsonProfileTypeIndicatorKey that = (FastJsonProfileTypeIndicatorKey) o;

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
        return "FastJsonProfileTypeIndicatorKey{" +
                "categoryId='" + categoryId + '\'' +
                ", stringId='" + stringId + '\'' +
                '}';
    }
}
