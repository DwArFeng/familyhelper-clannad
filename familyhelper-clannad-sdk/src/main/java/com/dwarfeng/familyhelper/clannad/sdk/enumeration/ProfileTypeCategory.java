package com.dwarfeng.familyhelper.clannad.sdk.enumeration;

/**
 * 个人简介类型的分类枚举。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public enum ProfileTypeCategory {

    ID_TYPE("id_type"),
    GENDER("gender"),
    BLOOD_TYPE("blood_type"),
    NATIONALITY("nationality"),
    EDUCATIONAL_LEVEL("educational_level"),
    EDUCATIONAL_BACKGROUND("educational_background"),
    POLITICAL_STATUS("political_status"),
    MARITAL_STATUS("marital_status"),
    ;

    private final String category;

    ProfileTypeCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ProfileTypeCategory{" +
                "category='" + category + '\'' +
                '}';
    }
}
