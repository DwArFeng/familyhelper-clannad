package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotificationOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotificationMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotificationOperateHandlerImpl implements NotificationOperateHandler {

    private final NotificationMaintainService notificationMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public NotificationOperateHandlerImpl(
            NotificationMaintainService notificationMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.notificationMaintainService = notificationMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public LongIdKey createNotification(NotificationCreateInfo notificationCreateInfo) throws HandlerException {
        try {
            StringIdKey userKey = notificationCreateInfo.getUserKey();

            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

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
    public void readNotification(LongIdKey notificationKey) throws HandlerException {
        try {
            // 1. 确认通知存在。
            operateHandlerValidator.makeSureNotificationExists(notificationKey);

            // 2. 设置通知属性，使其变为完成状态。
            Date currentDate = new Date();
            Notification notification = notificationMaintainService.get(notificationKey);
            notification.setReadDate(currentDate);
            notification.setReadFlag(true);

            // 3. 更新通知实体。
            notificationMaintainService.update(notification);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void readAllNotification(StringIdKey userKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 查询用户所有的未读消息。
            List<Notification> notifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER_UNREAD, new Object[]{userKey}
            ).getData();

            // 3. 设置通知属性，使其变为完成状态。
            Date currentDate = new Date();
            for (Notification notification : notifications) {
                notification.setReadDate(currentDate);
                notification.setReadFlag(true);
            }

            // 4. 更新通知实体。
            notificationMaintainService.batchUpdate(notifications);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeAllNotification(StringIdKey userKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 查询用户所有的未读消息。
            List<LongIdKey> notificationKeys = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER, new Object[]{userKey}
            ).getData().stream().map(Notification::getKey).collect(Collectors.toList());

            // 3. 删除通知实体。
            notificationMaintainService.batchDelete(notificationKeys);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
