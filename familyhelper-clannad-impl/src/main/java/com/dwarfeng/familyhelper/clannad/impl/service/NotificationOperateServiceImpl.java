package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotificationOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotificationOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class NotificationOperateServiceImpl implements NotificationOperateService {

    private final NotificationOperateHandler notificationOperateHandler;

    private final ServiceExceptionMapper sem;

    public NotificationOperateServiceImpl(
            NotificationOperateHandler notificationOperateHandler, ServiceExceptionMapper sem
    ) {
        this.notificationOperateHandler = notificationOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createNotification(NotificationCreateInfo notificationCreateInfo) throws ServiceException {
        try {
            return notificationOperateHandler.createNotification(notificationCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建通知时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void readNotification(LongIdKey notificationKey) throws ServiceException {
        try {
            notificationOperateHandler.readNotification(notificationKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("阅读通知时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void readAllNotification(StringIdKey userKey) throws ServiceException {
        try {
            notificationOperateHandler.readAllNotification(userKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("阅读用户的所有通知时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removeAllNotification(StringIdKey userKey) throws ServiceException {
        try {
            notificationOperateHandler.removeAllNotification(userKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("清除用户的所有通知时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
