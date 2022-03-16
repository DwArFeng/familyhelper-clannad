package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

import java.util.List;

/**
 * 通知操作服务。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public interface NotificationOperateHandler extends Handler {

    /**
     * 创建通知。
     *
     * @param notificationCreateInfo 通知的创建信息。
     * @return 生成的通知的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey createNotification(NotificationCreateInfo notificationCreateInfo) throws HandlerException;

    /**
     * 阅读通知。
     *
     * @param notificationKeys 通知的主键组成的列表。
     * @throws HandlerException 处理器异常。
     */
    void readNotification(List<LongIdKey> notificationKeys) throws HandlerException;
}
