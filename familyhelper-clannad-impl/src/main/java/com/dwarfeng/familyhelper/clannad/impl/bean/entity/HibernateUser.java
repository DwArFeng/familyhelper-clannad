package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateStringIdKey.class)
@Table(name = "tbl_user")
public class HibernateUser implements Bean {

    private static final long serialVersionUID = -825337727274424381L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true, length = Constraints.LENGTH_USER)
    private String stringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------一对一-----------------------------------------------------------
    @OneToOne(cascade = CascadeType.MERGE, targetEntity = HibernateProfile.class, mappedBy = "user")
    private HibernateProfile profile;

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = HibernateAvatarInfo.class, mappedBy = "user")
    private HibernateAvatarInfo avatarInfo;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePopr.class, mappedBy = "user")
    private Set<HibernatePopr> poprs = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateNickname.class, mappedBy = "subjectUser")
    private Set<HibernateNickname> subjectNicknames = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateNickname.class, mappedBy = "objectUser")
    private Set<HibernateNickname> objectNicknames = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateNotification.class, mappedBy = "user")
    private Set<HibernateNotification> notifications = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePoce.class, mappedBy = "user")
    private Set<HibernatePoce> poces = new HashSet<>();

    public HibernateUser() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateStringIdKey getKey() {
        return Optional.ofNullable(stringId).map(HibernateStringIdKey::new).orElse(null);
    }

    public void setKey(HibernateStringIdKey idKey) {
        this.stringId = Optional.ofNullable(idKey).map(HibernateStringIdKey::getStringId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernateProfile getProfile() {
        return profile;
    }

    public void setProfile(HibernateProfile profile) {
        this.profile = profile;
    }

    public HibernateAvatarInfo getAvatarInfo() {
        return avatarInfo;
    }

    public void setAvatarInfo(HibernateAvatarInfo avatarInfo) {
        this.avatarInfo = avatarInfo;
    }

    public Set<HibernatePopr> getPoprs() {
        return poprs;
    }

    public void setPoprs(Set<HibernatePopr> poprs) {
        this.poprs = poprs;
    }

    public Set<HibernateNickname> getSubjectNicknames() {
        return subjectNicknames;
    }

    public void setSubjectNicknames(Set<HibernateNickname> subjectNicknames) {
        this.subjectNicknames = subjectNicknames;
    }

    public Set<HibernateNickname> getObjectNicknames() {
        return objectNicknames;
    }

    public void setObjectNicknames(Set<HibernateNickname> objectNicknames) {
        this.objectNicknames = objectNicknames;
    }

    public Set<HibernateNotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<HibernateNotification> notifications) {
        this.notifications = notifications;
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
                "stringId = " + stringId + ", " +
                "remark = " + remark + ", " +
                "profile = " + profile + ", " +
                "avatarInfo = " + avatarInfo + ")";
    }
}
