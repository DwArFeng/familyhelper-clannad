package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 消息未授权发送异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageUnauthorizedToSendException extends HandlerException {

    private static final long serialVersionUID = 4890064559459209083L;

    private final StringIdKey sendUserKey;
    private final StringIdKey receiveUserKey;

    public MessageUnauthorizedToSendException(StringIdKey sendUserKey, StringIdKey receiveUserKey) {
        this.sendUserKey = sendUserKey;
        this.receiveUserKey = receiveUserKey;
    }

    public MessageUnauthorizedToSendException(Throwable cause, StringIdKey sendUserKey, StringIdKey receiveUserKey) {
        super(cause);
        this.sendUserKey = sendUserKey;
        this.receiveUserKey = receiveUserKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + sendUserKey + " 没有向用户 " + receiveUserKey + " 发送消息的权限";
    }
}
