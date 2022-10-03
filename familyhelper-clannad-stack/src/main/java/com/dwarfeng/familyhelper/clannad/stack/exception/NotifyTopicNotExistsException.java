package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 通知主题不存在异常。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyTopicNotExistsException extends HandlerException {

    private static final long serialVersionUID = 5700575963258545074L;

    private final StringIdKey notifyTopicKey;

    public NotifyTopicNotExistsException(StringIdKey notifyTopicKey) {
        this.notifyTopicKey = notifyTopicKey;
    }

    public NotifyTopicNotExistsException(Throwable cause, StringIdKey notifyTopicKey) {
        super(cause);
        this.notifyTopicKey = notifyTopicKey;
    }

    @Override
    public String getMessage() {
        return "通知主题 " + notifyTopicKey + " 不存在";
    }
}
