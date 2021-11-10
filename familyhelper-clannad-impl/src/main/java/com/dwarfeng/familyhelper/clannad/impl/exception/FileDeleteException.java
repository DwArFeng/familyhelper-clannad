package com.dwarfeng.familyhelper.clannad.impl.exception;

/**
 * 文件删除异常。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class FileDeleteException extends FileException {

    private static final long serialVersionUID = 257744426322850981L;

    public FileDeleteException(String filePath) {
        super(filePath);
    }

    public FileDeleteException(Throwable cause, String filePath) {
        super(cause, filePath);
    }

    @Override
    public String getMessage() {
        return "File delete failed: " + filePath;
    }
}
