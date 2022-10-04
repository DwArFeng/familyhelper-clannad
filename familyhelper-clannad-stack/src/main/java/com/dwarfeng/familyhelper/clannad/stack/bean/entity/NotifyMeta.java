package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

import java.util.Date;

/**
 * 通知元数据。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyMeta implements Entity<NotifyNodeKey> {

    private static final long serialVersionUID = 3393102518047980477L;
    
    private NotifyNodeKey key;
    private Date lastReceivedDate;
    private String remark;

    public NotifyMeta() {
    }

    public NotifyMeta(NotifyNodeKey key, Date lastReceivedDate, String remark) {
        this.key = key;
        this.lastReceivedDate = lastReceivedDate;
        this.remark = remark;
    }

    @Override
    public NotifyNodeKey getKey() {
        return key;
    }

    @Override
    public void setKey(NotifyNodeKey key) {
        this.key = key;
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

    @Override
    public String toString() {
        return "NotifyMeta{" +
                "key=" + key +
                ", lastReceivedDate=" + lastReceivedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
