package com.dwarfeng.familyhelper.clannad.stack.exception;

import com.dwarfeng.subgrade.stack.exception.HandlerException;

import java.util.Set;

/**
 * 留言状态不匹配异常。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageStatusMismatchException extends HandlerException {

    private static final long serialVersionUID = -5127437345310263600L;

    private final Set<Integer> exceptedStatus;
    private final int actualStatus;

    public MessageStatusMismatchException(Set<Integer> exceptedStatus, int actualStatus) {
        this.exceptedStatus = exceptedStatus;
        this.actualStatus = actualStatus;
    }

    public MessageStatusMismatchException(Throwable cause, Set<Integer> exceptedStatus, int actualStatus) {
        super(cause);
        this.exceptedStatus = exceptedStatus;
        this.actualStatus = actualStatus;
    }

    @Override
    public String getMessage() {
        return "留言状态不匹配, 期望的状态为 " + exceptedStatus + ", 实际的状态为 " + actualStatus;
    }
}
