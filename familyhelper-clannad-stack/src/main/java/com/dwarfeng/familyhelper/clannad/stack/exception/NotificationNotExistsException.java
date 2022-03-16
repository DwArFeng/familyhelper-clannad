package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 通知不存在异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class NotificationNotExistsException extends HandlerException {

    private static final long serialVersionUID = -2865615235495873429L;

    private final LongIdKey notificationKey;

    public NotificationNotExistsException(LongIdKey notificationKey) {
        this.notificationKey = notificationKey;
    }

    public NotificationNotExistsException(Throwable cause, LongIdKey notificationKey) {
        super(cause);
        this.notificationKey = notificationKey;
    }

    @Override
    public String getMessage() {
        return "通知 " + notificationKey + " 不存在";
    }
}
