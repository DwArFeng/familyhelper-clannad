package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonMessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 留言授权。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class FastJsonMessageAuthorization implements Bean {

    private static final long serialVersionUID = 6654031230780602188L;

    public static FastJsonMessageAuthorization of(MessageAuthorization messageAuthorization) {
        if (Objects.isNull(messageAuthorization)) {
            return null;
        } else {
            return new FastJsonMessageAuthorization(
                    FastJsonMessageAuthorizationKey.of(messageAuthorization.getKey()),
                    messageAuthorization.isEnabled(),
                    messageAuthorization.getRemark(),
                    messageAuthorization.getCreatedDate()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonMessageAuthorizationKey key;

    @JSONField(name = "enabled", ordinal = 2)
    private boolean enabled;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    @JSONField(name = "created_date", ordinal = 4)
    private Date createdDate;

    public FastJsonMessageAuthorization() {
    }

    public FastJsonMessageAuthorization(
            FastJsonMessageAuthorizationKey key, boolean enabled, String remark, Date createdDate
    ) {
        this.key = key;
        this.enabled = enabled;
        this.remark = remark;
        this.createdDate = createdDate;
    }

    public FastJsonMessageAuthorizationKey getKey() {
        return key;
    }

    public void setKey(FastJsonMessageAuthorizationKey key) {
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
        return "FastJsonMessageAuthorization{" +
                "key=" + key +
                ", enabled=" + enabled +
                ", remark='" + remark + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
