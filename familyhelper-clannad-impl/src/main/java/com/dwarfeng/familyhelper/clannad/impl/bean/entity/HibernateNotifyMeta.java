package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateNotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(HibernateNotifyNodeKey.class)
@Table(name = "tbl_notify_meta")
public class HibernateNotifyMeta implements Bean {

    private static final long serialVersionUID = 4701551331979478401L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "notify_setting_id", nullable = false)
    private Long notifySettingId;

    @Id
    @Column(name = "notify_topic_id", nullable = false)
    private String notifyTopicId;

    @Id
    @Column(name = "user_id", length = Constraints.LENGTH_USER, nullable = false)
    private String userId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "last_received_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastReceivedDate;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateNotifySetting.class)
    @JoinColumns({ //
            @JoinColumn(name = "notify_setting_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateNotifySetting notifySetting;

    @ManyToOne(targetEntity = HibernateNotifyTopic.class)
    @JoinColumns({ //
            @JoinColumn(name = "notify_topic_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateNotifyTopic notifyTopic;

    @ManyToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    public HibernateNotifyMeta() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateNotifyNodeKey getKey() {
        return new HibernateNotifyNodeKey(notifySettingId, notifyTopicId, userId);
    }

    public void setKey(HibernateNotifyNodeKey key) {
        if (Objects.isNull(key)) {
            this.notifySettingId = null;
            this.notifyTopicId = null;
            this.userId = null;
        } else {
            this.notifySettingId = key.getNotifySettingId();
            this.notifyTopicId = key.getNotifyTopicId();
            this.userId = key.getUserId();
        }
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getNotifySettingId() {
        return notifySettingId;
    }

    public void setNotifySettingId(Long notifySettingId) {
        this.notifySettingId = notifySettingId;
    }

    public String getNotifyTopicId() {
        return notifyTopicId;
    }

    public void setNotifyTopicId(String notifyTopicId) {
        this.notifyTopicId = notifyTopicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastReceivedDate() {
        return lastReceivedDate;
    }

    public void setLastReceivedDate(Date lastReceivedDate) {
        this.lastReceivedDate = lastReceivedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernateNotifySetting getNotifySetting() {
        return notifySetting;
    }

    public void setNotifySetting(HibernateNotifySetting notifySetting) {
        this.notifySetting = notifySetting;
    }

    public HibernateNotifyTopic getNotifyTopic() {
        return notifyTopic;
    }

    public void setNotifyTopic(HibernateNotifyTopic notifyTopic) {
        this.notifyTopic = notifyTopic;
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
                "notifySettingId = " + notifySettingId + ", " +
                "notifyTopicId = " + notifyTopicId + ", " +
                "userId = " + userId + ", " +
                "lastReceivedDate = " + lastReceivedDate + ", " +
                "remark = " + remark + ", " +
                "notifySetting = " + notifySetting + ", " +
                "notifyTopic = " + notifyTopic + ", " +
                "user = " + user + ")";
    }
}
