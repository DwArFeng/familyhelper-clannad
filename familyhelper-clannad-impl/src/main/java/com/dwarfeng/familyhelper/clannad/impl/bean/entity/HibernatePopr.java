package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernatePoprKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernatePoprKey.class)
@Table(name = "tbl_popr")
public class HibernatePopr implements Bean {

    private static final long serialVersionUID = -5681398222565247906L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "profile_id", nullable = false, length = Constraints.LENGTH_ID)
    private String profileId;

    @Id
    @Column(name = "user_id", nullable = false, length = Constraints.LENGTH_ID)
    private String userId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateProfile.class)
    @JoinColumns({ //
            @JoinColumn(name = "profile_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateProfile profile;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernatePopr() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernatePoprKey getKey() {
        return new HibernatePoprKey(profileId, userId);
    }

    public void setKey(HibernatePoprKey key) {
        if (Objects.isNull(key)) {
            this.profileId = null;
            this.userId = null;
        } else {
            this.profileId = key.getProfileId();
            this.userId = key.getUserId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public HibernateUser getUser() {
        return user;
    }

    public void setUser(HibernateUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "profileId = " + profileId + ", " +
                "userId = " + userId + ", " +
                "remark = " + remark + ", " +
                "profile = " + profile + ", " +
                "user = " + user + ")";
    }
}
