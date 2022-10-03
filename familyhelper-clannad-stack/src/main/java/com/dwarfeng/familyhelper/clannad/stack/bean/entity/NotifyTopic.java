package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 通知主题。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyTopic implements Entity<StringIdKey> {

    private static final long serialVersionUID = 4541418177509831291L;

    private StringIdKey key;
    private String remark;

    public NotifyTopic() {
    }

    public NotifyTopic(StringIdKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    @Override
    public StringIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(StringIdKey key) {
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
        return "NotifyTopic{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
