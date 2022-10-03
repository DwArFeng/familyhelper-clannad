package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 通知偏好操作服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyPreferenceOperateService extends Service {

    /**
     * 更新通知偏好。
     *
     * @param notifyPreferenceUpdateInfo 通知偏好更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateNotifyPreference(NotifyPreferenceUpdateInfo notifyPreferenceUpdateInfo) throws ServiceException;
}
