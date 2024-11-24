package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 消息授权不存在异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAuthorizationNotExistsException extends HandlerException {

    private static final long serialVersionUID = 1976274677907752691L;

    private final MessageAuthorizationKey key;

    public MessageAuthorizationNotExistsException(MessageAuthorizationKey key) {
        this.key = key;
    }

    public MessageAuthorizationNotExistsException(Throwable cause, MessageAuthorizationKey key) {
        super(cause);
        this.key = key;
    }

    @Override
    public String getMessage() {
        return "消息授权 " + key + " 不存在";
    }
}
