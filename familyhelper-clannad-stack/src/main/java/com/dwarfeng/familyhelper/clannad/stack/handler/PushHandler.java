package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.BirthdayBlessInfo;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

import java.util.List;

/**
 * 推送处理器。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
public interface PushHandler extends Handler {

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
}
