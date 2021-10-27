package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateIntegerIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Optional;

@Entity
@IdClass(HibernateIntegerIdKey.class)
@Table(name = "tbl_gender_type_indicator")
public class HibernateGenderTypeIndicator implements Bean {

    private static final long serialVersionUID = -4964419940736469084L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer integerId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "label", length = Constraints.LENGTH_LABEL)
    private String label;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    public HibernateGenderTypeIndicator() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateIntegerIdKey getKey() {
        return Optional.ofNullable(integerId).map(HibernateIntegerIdKey::new).orElse(null);
    }

    public void setKey(HibernateIntegerIdKey idKey) {
        this.integerId = Optional.ofNullable(idKey).map(HibernateIntegerIdKey::getIntegerId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Integer getIntegerId() {
        return integerId;
    }

    public void setIntegerId(Integer integerId) {
        this.integerId = integerId;
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
                "integerId = " + integerId + ", " +
                "label = " + label + ", " +
                "remark = " + remark + ")";
    }
}
