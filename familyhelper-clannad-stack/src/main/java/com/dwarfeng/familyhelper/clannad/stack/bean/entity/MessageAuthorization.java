package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

import java.util.Date;

/**
 * 留言授权。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAuthorization implements Entity<MessageAuthorizationKey> {

    private static final long serialVersionUID = -6314920965582573637L;

    private MessageAuthorizationKey key;
    private boolean enabled;
    private String remark;
    private Date createdDate;

    public MessageAuthorization() {
    }

    public MessageAuthorization(MessageAuthorizationKey key, boolean enabled, String remark, Date createdDate) {
        this.key = key;
        this.enabled = enabled;
        this.remark = remark;
        this.createdDate = createdDate;
    }

    @Override
    public MessageAuthorizationKey getKey() {
        return key;
    }

    @Override
    public void setKey(MessageAuthorizationKey key) {
        this.key = key;
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

    @Override
    public String toString() {
        return "MessageAuthorization{" +
                "key=" + key +
                ", enabled=" + enabled +
                ", remark='" + remark + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
