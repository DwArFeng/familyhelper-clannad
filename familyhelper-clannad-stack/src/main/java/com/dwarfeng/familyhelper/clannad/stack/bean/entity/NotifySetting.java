package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 通知设置。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifySetting implements Entity<LongIdKey> {

    private static final long serialVersionUID = 4240982135332434640L;

    private LongIdKey key;
    private String remark;

    public NotifySetting() {
    }

    public NotifySetting(LongIdKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(LongIdKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "NotifySetting{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
