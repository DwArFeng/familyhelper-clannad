package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

import java.util.Date;

/**
 * 留言。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class Message implements Entity<LongIdKey> {

    private static final long serialVersionUID = 1035232078891929751L;

    private LongIdKey key;
    private StringIdKey sendUserKey;
    private StringIdKey receiveUserKey;
    private String subject;
    private String remark;

    /**
     * 留言状态。
     *
     * <p>
     * int 枚举，可能的状态为：
     * <ul>
     *     <li>编辑中</li>
     *     <li>已发送</li>
     *     <li>已阅读</li>
     * </ul>
     * 详细值参考 sdk 模块的常量工具类。
     */
    private int status;
    private Date sentDate;
    private Date receivedDate;
    private int attachmentCount;
    private Date createdDate;

    /**
     * 发送用户隐藏标记。
     *
     * <p>
     * 接收者只能选择隐藏发送者的留言，不能删除发送者的留言；只有留言的发送者才能删除留言。<br>
     * 该标记用于标记接收者是否隐藏了发送者的留言，前端不需要展示此字段值为 <code>true</code> 的留言。
     */
    private boolean receiveUserHide;

    public Message() {
    }

    public Message(
            LongIdKey key, StringIdKey sendUserKey, StringIdKey receiveUserKey, String subject, String remark,
            int status, Date sentDate, Date receivedDate, int attachmentCount, Date createdDate, boolean receiveUserHide
    ) {
        this.key = key;
        this.sendUserKey = sendUserKey;
        this.receiveUserKey = receiveUserKey;
        this.subject = subject;
        this.remark = remark;
        this.status = status;
        this.sentDate = sentDate;
        this.receivedDate = receivedDate;
        this.attachmentCount = attachmentCount;
        this.createdDate = createdDate;
        this.receiveUserHide = receiveUserHide;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public StringIdKey getSendUserKey() {
        return sendUserKey;
    }

    public void setSendUserKey(StringIdKey sendUserKey) {
        this.sendUserKey = sendUserKey;
    }

    public StringIdKey getReceiveUserKey() {
        return receiveUserKey;
    }

    public void setReceiveUserKey(StringIdKey receiveUserKey) {
        this.receiveUserKey = receiveUserKey;
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

    @Override
    public String toString() {
        return "Message{" +
                "key=" + key +
                ", sendUserKey=" + sendUserKey +
                ", receiveUserKey=" + receiveUserKey +
                ", subject='" + subject + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", sentDate=" + sentDate +
                ", receivedDate=" + receivedDate +
                ", attachmentCount=" + attachmentCount +
                ", createdDate=" + createdDate +
                ", receiveUserHide=" + receiveUserHide +
                '}';
    }
}
