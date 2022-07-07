package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 证件文件不存在异常。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class CertificateFileNotExistsException extends HandlerException {

    private static final long serialVersionUID = 1144259841677956771L;

    private final LongIdKey certificateFileKey;

    public CertificateFileNotExistsException(LongIdKey certificateFileKey) {
        this.certificateFileKey = certificateFileKey;
    }

    public CertificateFileNotExistsException(Throwable cause, LongIdKey certificateFileKey) {
        super(cause);
        this.certificateFileKey = certificateFileKey;
    }

    @Override
    public String getMessage() {
        return "证件文件 " + certificateFileKey + " 不存在";
    }
}
