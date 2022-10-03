package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotifyPreferenceOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyPreferenceOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class NotifyPreferenceOperateServiceImpl implements NotifyPreferenceOperateService {

    private final NotifyPreferenceOperateHandler notifyPreferenceOperateHandler;

    private final ServiceExceptionMapper sem;

    public NotifyPreferenceOperateServiceImpl(
            NotifyPreferenceOperateHandler notifyPreferenceOperateHandler, ServiceExceptionMapper sem
    ) {
        this.notifyPreferenceOperateHandler = notifyPreferenceOperateHandler;
        this.sem = sem;
    }

    @Override
    public void updateNotifyPreference(NotifyPreferenceUpdateInfo notifyPreferenceUpdateInfo) throws ServiceException {
        try {
            notifyPreferenceOperateHandler.updateNotifyPreference(notifyPreferenceUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新通知偏好时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
