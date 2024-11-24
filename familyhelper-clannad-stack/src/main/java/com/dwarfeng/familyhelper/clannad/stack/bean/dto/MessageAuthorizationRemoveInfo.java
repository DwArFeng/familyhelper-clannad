package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

/**
 * 留言授权移除信息。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAuthorizationRemoveInfo implements Dto {

    private static final long serialVersionUID = -7484778552469699675L;

    private MessageAuthorizationKey key;

    public MessageAuthorizationRemoveInfo() {
    }

    public MessageAuthorizationRemoveInfo(MessageAuthorizationKey key) {
        this.key = key;
    }

    public MessageAuthorizationKey getKey() {
        return key;
    }

    public void setKey(MessageAuthorizationKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "MessageAuthorizationRemoveInfo{" +
                "key=" + key +
                '}';
    }
}
