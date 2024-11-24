package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 留言正文不存在异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageBodyNotExistsException extends HandlerException {

    private static final long serialVersionUID = -7838898610961666899L;

    private final LongIdKey messageBodyKey;

    public MessageBodyNotExistsException(LongIdKey messageBodyKey) {
        this.messageBodyKey = messageBodyKey;
    }

    public MessageBodyNotExistsException(Throwable cause, LongIdKey messageBodyKey) {
        super(cause);
        this.messageBodyKey = messageBodyKey;
    }

    @Override
    public String getMessage() {
        return "留言正文 " + messageBodyKey + " 不存在";
    }
}
