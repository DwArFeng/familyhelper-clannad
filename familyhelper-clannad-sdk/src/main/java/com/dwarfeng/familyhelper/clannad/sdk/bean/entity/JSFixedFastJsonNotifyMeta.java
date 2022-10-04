package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.JSFixedFastJsonNotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 通知元数据。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class JSFixedFastJsonNotifyMeta implements Bean {

    private static final long serialVersionUID = -4148080759178505254L;

    public static JSFixedFastJsonNotifyMeta of(NotifyMeta notifyMeta) {
        if (Objects.isNull(notifyMeta)) {
            return null;
        } else {
            return new JSFixedFastJsonNotifyMeta(
                    JSFixedFastJsonNotifyNodeKey.of(notifyMeta.getKey()),
                    notifyMeta.getLastReceivedDate(), notifyMeta.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonNotifyNodeKey key;

    @JSONField(name = "last_received_date", ordinal = 2)
    private Date lastReceivedDate;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public JSFixedFastJsonNotifyMeta() {
    }

    public JSFixedFastJsonNotifyMeta(JSFixedFastJsonNotifyNodeKey key, Date lastReceivedDate, String remark) {
        this.key = key;
        this.lastReceivedDate = lastReceivedDate;
        this.remark = remark;
    }

    public JSFixedFastJsonNotifyNodeKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonNotifyNodeKey key) {
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
        return "JSFixedFastJsonNotifyMeta{" +
                "key=" + key +
                ", lastReceivedDate=" + lastReceivedDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
