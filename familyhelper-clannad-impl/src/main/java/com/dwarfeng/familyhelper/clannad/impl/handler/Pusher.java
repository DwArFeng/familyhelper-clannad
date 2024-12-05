package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.BirthdayBlessInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

import java.util.List;

/**
 * 事件推送器。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
public interface Pusher {

    /**
     * 返回事件推送器是否支持指定的类型。
     *
     * @param type 指定的类型。
     * @return 事件推送器是否支持指定的类型。
     */
    boolean supportType(String type);

    /**
     * 生日祝福发生时执行的调度。
     *
     * @param birthdayBlessInfo 生日祝福信息。
     * @throws HandlerException 处理器异常。
     */
    void birthdayBlessHappened(BirthdayBlessInfo birthdayBlessInfo) throws HandlerException;

    /**
     * 生日祝福发生时执行的调度。
     *
     * @param birthdayBlessInfos 生日祝福信息组成的列表。
     * @throws HandlerException 处理器异常。
     */
    void birthdayBlessHappened(List<BirthdayBlessInfo> birthdayBlessInfos) throws HandlerException;

    /**
     * 留言发送时执行的调度。
     *
     * @param message 留言。
     * @throws HandlerException 处理器异常。
     * @since 1.5.0
     */
    void messageSent(Message message) throws HandlerException;
}
