package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_certificate")
public class HibernateCertificate implements Bean {

    private static final long serialVersionUID = 1917059442804914578L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "name", length = Constraints.LENGTH_NAME, nullable = false)
    private String name;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateCertificateFileInfo.class, mappedBy = "certificate")
    private Set<HibernateCertificateFileInfo> certificateFileInfos = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoce.class, mappedBy = "certificate")
    private Set<HibernatePoce> poces = new HashSet<>();

    public HibernateCertificate() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<HibernateCertificateFileInfo> getCertificateFileInfos() {
        return certificateFileInfos;
    }

    public void setCertificateFileInfos(Set<HibernateCertificateFileInfo> certificateFileInfos) {
        this.certificateFileInfos = certificateFileInfos;
    }

    public Set<HibernatePoce> getPoces() {
        return poces;
    }

    public void setPoces(Set<HibernatePoce> poces) {
        this.poces = poces;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "name = " + name + ", " +
                "remark = " + remark + ")";
    }
}
