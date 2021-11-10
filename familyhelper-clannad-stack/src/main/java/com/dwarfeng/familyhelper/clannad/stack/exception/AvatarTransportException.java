package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 头像传输异常。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class AvatarTransportException extends HandlerException {

    private static final long serialVersionUID = -6690469457953053518L;

    private final StringIdKey userKey;

    public AvatarTransportException(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public AvatarTransportException(Throwable cause, StringIdKey userKey) {
        super(cause);
        this.userKey = userKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 的头像传输异常";
    }
}
