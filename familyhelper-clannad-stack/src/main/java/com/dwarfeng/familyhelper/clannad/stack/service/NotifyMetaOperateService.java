package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 通知元数据操作服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyMetaOperateService extends Service {

    /**
     * 更新元数据的最后接收日期。
     *
     * @param notifyNodeKey 通知节点主键。
     * @throws ServiceException 服务异常。
     */
    void updateLastReceivedDate(NotifyNodeKey notifyNodeKey) throws ServiceException;
}
