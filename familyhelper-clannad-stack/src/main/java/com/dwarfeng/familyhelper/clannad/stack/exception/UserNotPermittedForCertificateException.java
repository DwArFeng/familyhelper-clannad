package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 用户对证件没有权限异常。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public class UserNotPermittedForCertificateException extends HandlerException {

    private static final long serialVersionUID = 8126380265757939621L;

    private final StringIdKey userKey;
    private final LongIdKey certificateKey;

    public UserNotPermittedForCertificateException(StringIdKey userKey, LongIdKey certificateKey) {
        this.userKey = userKey;
        this.certificateKey = certificateKey;
    }

    public UserNotPermittedForCertificateException(Throwable cause, StringIdKey userKey, LongIdKey certificateKey) {
        super(cause);
        this.userKey = userKey;
        this.certificateKey = certificateKey;
    }

    @Override
    public String getMessage() {
        return "用户 " + userKey + " 没有操作证件 " + certificateKey + " 的权限";
    }
}
