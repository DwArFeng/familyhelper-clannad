package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernateProfileTypeIndicatorKey.class)
@Table(name = "profile_type_indicator")
public class HibernateProfileTypeIndicator implements Dto {

    private static final long serialVersionUID = -5272680746935811767L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "category_id", nullable = false, length = Constraints.LENGTH_ID)
    private String categoryId;

    @Id
    @Column(name = "string_id", nullable = false, length = Constraints.LENGTH_ID)
    private String stringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "label", length = Constraints.LENGTH_LABEL)
    private String label;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    public HibernateProfileTypeIndicator() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateProfileTypeIndicatorKey getKey() {
        return new HibernateProfileTypeIndicatorKey(categoryId, stringId);
    }

    public void setKey(HibernateProfileTypeIndicatorKey key) {
        if (Objects.isNull(key)) {
            this.categoryId = null;
            this.stringId = null;
        } else {
            this.categoryId = key.getCategoryId();
            this.stringId = key.getStringId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "categoryId = " + categoryId + ", " +
                "stringId = " + stringId + ", " +
                "label = " + label + ", " +
                "remark = " + remark + ")";
    }
}
