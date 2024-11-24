package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

import java.util.Set;

/**
 * 用户不匹配异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class UserMismatchException extends HandlerException {

    private static final long serialVersionUID = 1957189643931882156L;

    private final Set<StringIdKey> exceptedUserKeys;
    private final StringIdKey actualUserKey;

    public UserMismatchException(Set<StringIdKey> exceptedUserKeys, StringIdKey actualUserKey) {
        this.exceptedUserKeys = exceptedUserKeys;
        this.actualUserKey = actualUserKey;
    }

    public UserMismatchException(Throwable cause, Set<StringIdKey> exceptedUserKeys, StringIdKey actualUserKey) {
        super(cause);
        this.exceptedUserKeys = exceptedUserKeys;
        this.actualUserKey = actualUserKey;
    }

    @Override
    public String getMessage() {
        return "用户不匹配异常: 期望的用户键为 " + exceptedUserKeys + ", 实际的用户键为 " + actualUserKey;
    }
}
