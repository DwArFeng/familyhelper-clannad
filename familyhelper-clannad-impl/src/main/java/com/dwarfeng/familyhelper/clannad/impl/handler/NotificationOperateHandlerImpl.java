package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification;
import com.dwarfeng.familyhelper.clannad.stack.exception.NotificationNotExistsException;
import com.dwarfeng.familyhelper.clannad.stack.exception.UserNotExistsException;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotificationOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotificationMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class NotificationOperateHandlerImpl implements NotificationOperateHandler {

    private final UserMaintainService userMaintainService;
    private final NotificationMaintainService notificationMaintainService;

    public NotificationOperateHandlerImpl(
            UserMaintainService userMaintainService, NotificationMaintainService notificationMaintainService
    ) {
        this.userMaintainService = userMaintainService;
        this.notificationMaintainService = notificationMaintainService;
    }


    @Override
    public LongIdKey createNotification(NotificationCreateInfo notificationCreateInfo) throws HandlerException {
        try {
            StringIdKey userKey = notificationCreateInfo.getUserKey();

            // 1. 确认用户存在。
            makeSureUserExists(userKey);

            // 2. 根据 notificationCreateInfo 以及创建的规则组合通知实体。
            Date currentDate = new Date();
            Notification notification = new Notification(
                    null, userKey, notificationCreateInfo.getMessage(), notificationCreateInfo.getRemark(),
                    currentDate, null, false
            );

            // 3. 插入通知实体，并返回生成的主键。
            return notificationMaintainService.insert(notification);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void readNotification(List<LongIdKey> notificationKeys) throws HandlerException {
        try {
            // 1. 确认通知存在。
            for (LongIdKey notificationKey : notificationKeys) {
                makeSureNotificationExists(notificationKey);
            }

            // 2. 设置通知属性，使其变为完成状态。
            Date currentDate = new Date();
            List<Notification> notifications = notificationMaintainService.batchGet(notificationKeys);
            for (Notification notification : notifications) {
                notification.setReadDate(currentDate);
                notification.setReadFlag(true);
            }

            // 3. 更新通知实体。
            notificationMaintainService.batchUpdate(notifications);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    private void makeSureUserExists(StringIdKey userKey) throws HandlerException {
        try {
            if (Objects.isNull(userKey) || !userMaintainService.exists(userKey)) {
                throw new UserNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    private void makeSureNotificationExists(LongIdKey notificationKey) throws HandlerException {
        try {
            if (Objects.isNull(notificationKey) || !notificationMaintainService.exists(notificationKey)) {
                throw new NotificationNotExistsException(notificationKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
