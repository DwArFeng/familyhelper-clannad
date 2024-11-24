package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 留言附件不存在异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAttachmentNotExistsException extends HandlerException {

    private static final long serialVersionUID = -4864849409607774232L;

    private final LongIdKey messageAttachmentKey;

    public MessageAttachmentNotExistsException(LongIdKey messageAttachmentKey) {
        this.messageAttachmentKey = messageAttachmentKey;
    }

    public MessageAttachmentNotExistsException(Throwable cause, LongIdKey messageAttachmentKey) {
        super(cause);
        this.messageAttachmentKey = messageAttachmentKey;
    }

    @Override
    public String getMessage() {
        return "留言附件 " + messageAttachmentKey + " 不存在";
    }
}
