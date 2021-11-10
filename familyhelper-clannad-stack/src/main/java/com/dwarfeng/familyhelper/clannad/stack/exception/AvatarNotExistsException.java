package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 头像不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class AvatarNotExistsException extends HandlerException {

    private static final long serialVersionUID = -6732690710733612552L;

    private final StringIdKey userKey;

    public AvatarNotExistsException(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public AvatarNotExistsException(Throwable cause, StringIdKey userKey) {
        super(cause);
        this.userKey = userKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 头像不存在";
    }
}
