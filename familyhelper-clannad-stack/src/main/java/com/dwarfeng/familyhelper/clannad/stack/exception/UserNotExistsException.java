package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 用户不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class UserNotExistsException extends HandlerException {

    private static final long serialVersionUID = -1376656704852950231L;

    private final StringIdKey userKey;

    public UserNotExistsException(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public UserNotExistsException(Throwable cause, StringIdKey userKey) {
        super(cause);
        this.userKey = userKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 不存在";
    }
}
