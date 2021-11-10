package com.dwarfeng.familyhelper.clannad.impl.exception;

import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 文件异常。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class FileException extends HandlerException {

    private static final long serialVersionUID = -2661245604547646303L;

    protected final String filePath;

    public FileException(String filePath) {
        this.filePath = filePath;
    }

    public FileException(Throwable cause, String filePath) {
        super(cause);
        this.filePath = filePath;
    }

    @Override
    public String getMessage() {
        return "File transfer failed: " + filePath;
    }
}
