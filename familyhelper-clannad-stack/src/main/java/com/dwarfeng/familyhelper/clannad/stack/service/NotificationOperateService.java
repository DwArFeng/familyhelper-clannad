package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

import java.util.List;

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
     * @param notificationKeys 通知的主键组成的列表。
     * @throws ServiceException 服务异常。
     */
    void readNotification(List<LongIdKey> notificationKeys) throws ServiceException;
}
