package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 通知偏好操作处理器。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyPreferenceOperateHandler extends Handler {

    /**
     * 更新通知偏好。
     *
     * @param notifyPreferenceUpdateInfo 通知偏好更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateNotifyPreference(NotifyPreferenceUpdateInfo notifyPreferenceUpdateInfo) throws HandlerException;
}
