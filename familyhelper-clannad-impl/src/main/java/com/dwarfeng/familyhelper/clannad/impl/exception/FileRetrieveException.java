package com.dwarfeng.familyhelper.clannad.impl.exception;

/**
 * 文件取回异常。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class FileRetrieveException extends FileException {

    private static final long serialVersionUID = -6806345151264859007L;

    public FileRetrieveException(String filePath) {
        super(filePath);
    }

    public FileRetrieveException(Throwable cause, String filePath) {
        super(cause, filePath);
    }

    @Override
    public String getMessage() {
        return "File retrieve failed: " + filePath;
    }
}
