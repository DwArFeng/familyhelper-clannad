package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@IdClass(HibernateLongIdKey.class)
@Table(name = "tbl_message_attachment_info")
public class HibernateMessageAttachmentInfo implements Bean {

    private static final long serialVersionUID = -142740611922001645L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long longId;

    // -----------------------------------------------------------外键-----------------------------------------------------------
    @Column(name = "message_id")
    private Long messageLongId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "origin_name")
    private String originName;

    @Column(name = "column_length")
    private long length;

    @Column(name = "upload_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    // -----------------------------------------------------------多对一-----------------------------------------------------------
    @ManyToOne(targetEntity = HibernateMessage.class)
    @JoinColumns({ //
            @JoinColumn(name = "message_id", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private HibernateMessage message;

    public HibernateMessageAttachmentInfo() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateLongIdKey getKey() {
        return Optional.ofNullable(longId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setKey(HibernateLongIdKey idKey) {
        this.longId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    public HibernateLongIdKey getMessageKey() {
        return Optional.ofNullable(messageLongId).map(HibernateLongIdKey::new).orElse(null);
    }

    public void setMessageKey(HibernateLongIdKey idKey) {
        this.messageLongId = Optional.ofNullable(idKey).map(HibernateLongIdKey::getLongId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public Long getLongId() {
        return longId;
    }

    public void setLongId(Long longId) {
        this.longId = longId;
    }

    public Long getMessageLongId() {
        return messageLongId;
    }

    public void setMessageLongId(Long messageLongId) {
        this.messageLongId = messageLongId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public HibernateMessage getMessage() {
        return message;
    }

    public void setMessage(HibernateMessage message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "longId = " + longId + ", " +
                "messageLongId = " + messageLongId + ", " +
                "originName = " + originName + ", " +
                "length = " + length + ", " +
                "uploadDate = " + uploadDate + ", " +
                "remark = " + remark + ", " +
                "message = " + message + ")";
    }
}
