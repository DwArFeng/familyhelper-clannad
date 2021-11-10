package com.dwarfeng.familyhelper.clannad.impl.exception;

/**
 * 文件存储异常。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class FileStoreException extends FileException {

    private static final long serialVersionUID = 1122669244377839255L;

    public FileStoreException(String filePath) {
        super(filePath);
    }

    public FileStoreException(Throwable cause, String filePath) {
        super(cause, filePath);
    }

    @Override
    public String getMessage() {
        return "File store failed: " + filePath;
    }
}
