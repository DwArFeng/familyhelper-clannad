package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 证件不存在异常。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificateNotExistsException extends HandlerException {

    private static final long serialVersionUID = -8986710916636274375L;

    private final LongIdKey certificateKey;

    public CertificateNotExistsException(LongIdKey certificateKey) {
        this.certificateKey = certificateKey;
    }

    public CertificateNotExistsException(Throwable cause, LongIdKey certificateKey) {
        super(cause);
        this.certificateKey = certificateKey;
    }

    @Override
    public String getMessage() {
        return "证件 " + certificateKey + " 不存在";
    }
}
