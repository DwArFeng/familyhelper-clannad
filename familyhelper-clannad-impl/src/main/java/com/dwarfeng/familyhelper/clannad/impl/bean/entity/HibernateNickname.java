package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateNicknameKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(HibernateNicknameKey.class)
@Table(name = "tbl_nickname")
public class HibernateNickname implements Bean {

    private static final long serialVersionUID = 5459636844099574370L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "subject_user_id", nullable = false, length = Constraints.LENGTH_ID)
    private String subjectUserId;

    @Id
    @Column(name = "object_user_id", nullable = false, length = Constraints.LENGTH_ID)
    private String objectUserId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "column_call", length = Constraints.LENGTH_NAME)
    private String call;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "subject_user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser subjectUser;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "object_user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser objectUser;

    public HibernateNickname() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateNicknameKey getKey() {
        return new HibernateNicknameKey(subjectUserId, objectUserId);
    }

    public void setKey(HibernateNicknameKey key) {
        if (Objects.isNull(key)) {
            this.subjectUserId = null;
            this.objectUserId = null;
        } else {
            this.subjectUserId = key.getSubjectUserId();
            this.objectUserId = key.getObjectUserId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public String getSubjectUserId() {
        return subjectUserId;
    }

    public void setSubjectUserId(String subjectUserId) {
        this.subjectUserId = subjectUserId;
    }

    public String getObjectUserId() {
        return objectUserId;
    }

    public void setObjectUserId(String objectUserId) {
        this.objectUserId = objectUserId;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernateUser getSubjectUser() {
        return subjectUser;
    }

    public void setSubjectUser(HibernateUser subjectUser) {
        this.subjectUser = subjectUser;
    }

    public HibernateUser getObjectUser() {
        return objectUser;
    }

    public void setObjectUser(HibernateUser objectUser) {
        this.objectUser = objectUser;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "subjectUserId = " + subjectUserId + ", " +
                "objectUserId = " + objectUserId + ", " +
                "call = " + call + ", " +
                "remark = " + remark + ", " +
                "subjectUser = " + subjectUser + ", " +
                "objectUser = " + objectUser + ")";
    }
}
