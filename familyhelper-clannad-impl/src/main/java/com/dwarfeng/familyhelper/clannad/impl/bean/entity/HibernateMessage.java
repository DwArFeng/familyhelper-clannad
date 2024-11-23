package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_message")
public class HibernateMessage implements Bean {

    private static final long serialVersionUID = -24868905112901647L;
    
    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "send_user_id", length = Constraints.LENGTH_ID)
    private String sendUserStringId;

    @Column(name = "receive_user_id", length = Constraints.LENGTH_ID)
    private String receiveUserStringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "subject", length = Constraints.LENGTH_SUBJECT)
    private String subject;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "sent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    @Column(name = "received_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDate;

    @Column(name = "attachment_count", nullable = false)
    private int attachmentCount;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "receive_user_hide", nullable = false)
    private boolean receiveUserHide;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "send_user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser sendUser;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "receive_user_id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser receiveUser;

    // -----------------------------------------------------------一对一-----------------------------------------------------------
    @OneToOne(cascade = CascadeType.MERGE, targetEntity = HibernateMessageBodyInfo.class, mappedBy = "message")
    private HibernateMessageBodyInfo messageBodyInfo;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateMessageAttachmentInfo.class, mappedBy = "message")
    private Set<HibernateMessageAttachmentInfo> messageAttachmentInfos = new HashSet<>();

    public HibernateMessage() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateStringIdKey getSendUserKey() {
        return Optional.ofNullable(sendUserStringId).map(HibernateStringIdKey::new).orElse(null);
    }

    public void setSendUserKey(HibernateStringIdKey sendUserKey) {
        this.sendUserStringId = Optional.ofNullable(sendUserKey).map(HibernateStringIdKey::getStringId).orElse(null);
    }

    public HibernateStringIdKey getReceiveUserKey() {
        return Optional.ofNullable(receiveUserStringId).map(HibernateStringIdKey::new).orElse(null);
    }

    public void setReceiveUserKey(HibernateStringIdKey receiveUserKey) {
        this.receiveUserStringId = Optional.ofNullable(receiveUserKey).map(HibernateStringIdKey::getStringId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }

    public String getSendUserStringId() {
        return sendUserStringId;
    }

    public void setSendUserStringId(String sendUserStringId) {
        this.sendUserStringId = sendUserStringId;
    }

    public String getReceiveUserStringId() {
        return receiveUserStringId;
    }

    public void setReceiveUserStringId(String receiveUserStringId) {
        this.receiveUserStringId = receiveUserStringId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public int getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isReceiveUserHide() {
        return receiveUserHide;
    }

    public void setReceiveUserHide(boolean receiveUserHide) {
        this.receiveUserHide = receiveUserHide;
    }

    public HibernateUser getSendUser() {
        return sendUser;
    }

    public void setSendUser(HibernateUser sendUser) {
        this.sendUser = sendUser;
    }

    public HibernateUser getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(HibernateUser receiveUser) {
        this.receiveUser = receiveUser;
    }

    public HibernateMessageBodyInfo getMessageBodyInfo() {
        return messageBodyInfo;
    }

    public void setMessageBodyInfo(HibernateMessageBodyInfo messageBodyInfo) {
        this.messageBodyInfo = messageBodyInfo;
    }

    public Set<HibernateMessageAttachmentInfo> getMessageAttachmentInfos() {
        return messageAttachmentInfos;
    }

    public void setMessageAttachmentInfos(Set<HibernateMessageAttachmentInfo> messageAttachmentInfos) {
        this.messageAttachmentInfos = messageAttachmentInfos;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "sendUserStringId = " + sendUserStringId + ", " +
                "receiveUserStringId = " + receiveUserStringId + ", " +
                "subject = " + subject + ", " +
                "remark = " + remark + ", " +
                "status = " + status + ", " +
                "sentDate = " + sentDate + ", " +
                "receivedDate = " + receivedDate + ", " +
                "attachmentCount = " + attachmentCount + ", " +
                "createdDate = " + createdDate + ", " +
                "receiveUserHide = " + receiveUserHide + ", " +
                "sendUser = " + sendUser + ", " +
                "receiveUser = " + receiveUser + ", " +
                "messageBodyInfo = " + messageBodyInfo + ")";
    }
}
