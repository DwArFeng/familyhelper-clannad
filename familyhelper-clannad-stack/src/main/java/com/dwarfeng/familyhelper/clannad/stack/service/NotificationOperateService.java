package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 通知操作服务。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public interface NotificationOperateService extends Service {

    /**
     * 创建通知。
     *
     * @param notificationCreateInfo 通知的创建信息。
     * @return 生成的通知的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey createNotification(NotificationCreateInfo notificationCreateInfo) throws ServiceException;

    /**
     * 阅读通知。
     *
     * @param notificationKey 通知的主键组。
     * @throws ServiceException 服务异常。
     */
    void readNotification(LongIdKey notificationKey) throws ServiceException;

    /**
     * 阅读用户的所有通知。
     *
     * @param userKey 用户的主键。
     * @throws ServiceException 服务异常。
     */
    void readAllNotification(StringIdKey userKey) throws ServiceException;
}
