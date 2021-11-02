package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人简介不存在异常。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ProfileNotExistsException extends HandlerException {

    private static final long serialVersionUID = 1390188594914154194L;

    private final StringIdKey profileKey;

    public ProfileNotExistsException(StringIdKey profileKey) {
        this.profileKey = profileKey;
    }

    public ProfileNotExistsException(Throwable cause, StringIdKey profileKey) {
        super(cause);
        this.profileKey = profileKey;
    }

    @Override
    public String getMessage() {
        return "个人简介 " + profileKey + " 不存在";
    }
}
