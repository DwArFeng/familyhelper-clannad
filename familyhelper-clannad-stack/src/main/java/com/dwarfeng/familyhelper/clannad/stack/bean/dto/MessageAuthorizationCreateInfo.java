package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 留言授权创建信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAuthorizationCreateInfo implements Dto {

    private static final long serialVersionUID = -5296343160644152698L;

    private MessageAuthorizationKey key;
    private boolean enabled;
    private String remark;

    public MessageAuthorizationCreateInfo() {
    }

    public MessageAuthorizationCreateInfo(MessageAuthorizationKey key, boolean enabled, String remark) {
        this.key = key;
        this.enabled = enabled;
        this.remark = remark;
    }

    public MessageAuthorizationKey getKey() {
        return key;
    }

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

    @Override
    public String toString() {
        return "MessageAuthorizationCreateInfo{" +
                "key=" + key +
                ", enabled=" + enabled +
                ", remark='" + remark + '\'' +
                '}';
    }
}
