package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 留言不存在异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageNotExistsException extends HandlerException {

    private static final long serialVersionUID = 7916724620219093291L;

    private final LongIdKey messageKey;

    public MessageNotExistsException(LongIdKey messageKey) {
        this.messageKey = messageKey;
    }

    public MessageNotExistsException(Throwable cause, LongIdKey messageKey) {
        super(cause);
        this.messageKey = messageKey;
    }

    @Override
    public String getMessage() {
        return "留言 " + messageKey + " 不存在";
    }
}
