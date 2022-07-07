package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernatePoceKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernatePoceKey.class)
@Table(name = "tbl_poce")
public class HibernatePoce implements Bean {

    private static final long serialVersionUID = -8557452110711405986L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "certificate_id", nullable = false)
    private Long certificateId;

    @Id
    @Column(name = "user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String userId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "permission_level")
    private int permissionLevel;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateCertificate.class)
    @JoinColumns({ //
            @JoinColumn(name = "certificate_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateCertificate certificate;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernatePoce() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernatePoceKey getKey() {
        return new HibernatePoceKey(certificateId, userId);
    }

    public void setKey(HibernatePoceKey key) {
        if (Objects.isNull(key)) {
            this.certificateId = null;
            this.userId = null;
        } else {
            this.certificateId = key.getCertificateId();
            this.userId = key.getUserId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long longId) {
        this.certificateId = longId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String stringId) {
        this.userId = stringId;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernateCertificate getCertificate() {
        return certificate;
    }

    public void setCertificate(HibernateCertificate certificate) {
        this.certificate = certificate;
    }

    public HibernateUser getUser() {
        return user;
    }

    public void setUser(HibernateUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "certificateId = " + certificateId + ", " +
                "userId = " + userId + ", " +
                "permissionLevel = " + permissionLevel + ", " +
                "remark = " + remark + ", " +
                "certificate = " + certificate + ", " +
                "user = " + user + ")";
    }
}
