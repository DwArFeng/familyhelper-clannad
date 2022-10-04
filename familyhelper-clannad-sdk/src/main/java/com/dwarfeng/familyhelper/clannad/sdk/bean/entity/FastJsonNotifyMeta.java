package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonNotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 通知元数据。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonNotifyMeta implements Bean {

    private static final long serialVersionUID = -2956895456180004313L;

    public static FastJsonNotifyMeta of(NotifyMeta notifyMeta) {
        if (Objects.isNull(notifyMeta)) {
            return null;
        } else {
            return new FastJsonNotifyMeta(
                    FastJsonNotifyNodeKey.of(notifyMeta.getKey()),
                    notifyMeta.getLastReceivedDate(), notifyMeta.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonNotifyNodeKey key;

    @JSONField(name = "last_received_date", ordinal = 2)
    private Date lastReceivedDate;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonNotifyMeta() {
    }

    public FastJsonNotifyMeta(FastJsonNotifyNodeKey key, Date lastReceivedDate, String remark) {
        this.key = key;
        this.lastReceivedDate = lastReceivedDate;
        this.remark = remark;
    }

    public FastJsonNotifyNodeKey getKey() {
        return key;
    }

    public void setKey(FastJsonNotifyNodeKey key) {
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
        return "FastJsonNotifyMeta{" +
                "key=" + key +
                ", lastReceivedDate=" + lastReceivedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
