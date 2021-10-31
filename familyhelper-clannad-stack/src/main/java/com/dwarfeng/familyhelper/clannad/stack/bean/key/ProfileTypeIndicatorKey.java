package com.dwarfeng.familyhelper.clannad.stack.bean.key;

import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * 个人简介类型指示器主键。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ProfileTypeIndicatorKey implements Key {

    private static final long serialVersionUID = 2295544761707299510L;

    private String categoryId;
    private String stringId;

    public ProfileTypeIndicatorKey() {
    }

    public ProfileTypeIndicatorKey(String categoryId, String stringId) {
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

        ProfileTypeIndicatorKey that = (ProfileTypeIndicatorKey) o;

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
        return "ProfileTypeIndicatorKey{" +
                "categoryId='" + categoryId + '\'' +
                ", stringId='" + stringId + '\'' +
                '}';
    }
}
