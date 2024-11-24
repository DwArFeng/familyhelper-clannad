package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 消息授权已存在异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAuthorizationExistsException extends HandlerException {

    private static final long serialVersionUID = 5746812670274774485L;

    private final MessageAuthorizationKey key;

    public MessageAuthorizationExistsException(MessageAuthorizationKey key) {
        this.key = key;
    }

    public MessageAuthorizationExistsException(Throwable cause, MessageAuthorizationKey key) {
        super(cause);
        this.key = key;
    }

    @Override
    public String getMessage() {
        return "消息授权 " + key + " 已存在";
    }
}
