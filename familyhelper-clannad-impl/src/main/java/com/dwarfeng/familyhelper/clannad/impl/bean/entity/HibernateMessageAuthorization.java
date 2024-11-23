package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateMessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(HibernateMessageAuthorizationKey.class)
@Table(name = "tbl_message_authorization")
public class HibernateMessageAuthorization implements Bean {

    private static final long serialVersionUID = -4005780679437710281L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "receive_user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String receiveUserId;

    @Id
    @Column(name = "authorized_send_user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String authorizedSendUserId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "receive_user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser receiveUser;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "authorized_send_user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser authorizedSendUser;

    public HibernateMessageAuthorization() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateMessageAuthorizationKey getKey() {
        return new HibernateMessageAuthorizationKey(receiveUserId, authorizedSendUserId);
    }

    public void setKey(HibernateMessageAuthorizationKey key) {
        if (Objects.isNull(key)) {
            this.receiveUserId = null;
            this.authorizedSendUserId = null;
        } else {
            this.receiveUserId = key.getReceiveUserId();
            this.authorizedSendUserId = key.getAuthorizedSendUserId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getAuthorizedSendUserId() {
        return authorizedSendUserId;
    }

    public void setAuthorizedSendUserId(String authorizedSendUserId) {
        this.authorizedSendUserId = authorizedSendUserId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public HibernateUser getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(HibernateUser receiveUser) {
        this.receiveUser = receiveUser;
    }

    public HibernateUser getAuthorizedSendUser() {
        return authorizedSendUser;
    }

    public void setAuthorizedSendUser(HibernateUser authorizedSendUser) {
        this.authorizedSendUser = authorizedSendUser;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "receiveUserId = " + receiveUserId + ", " +
                "authorizedSendUserId = " + authorizedSendUserId + ", " +
                "enabled = " + enabled + ", " +
                "remark = " + remark + ", " +
                "createdDate = " + createdDate + ", " +
                "receiveUser = " + receiveUser + ", " +
                "authorizedSendUser = " + authorizedSendUser + ")";
    }
}
