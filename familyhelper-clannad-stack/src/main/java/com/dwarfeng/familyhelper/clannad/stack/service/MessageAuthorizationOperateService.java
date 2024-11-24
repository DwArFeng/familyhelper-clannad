package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationRemoveInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 留言授权操作服务。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAuthorizationOperateService extends Service {

    /**
     * 创建留言授权。
     *
     * @param info 留言授权创建信息。
     * @return 创建的留言授权的主键。
     * @throws ServiceException 服务异常。
     */
    MessageAuthorizationKey create(MessageAuthorizationCreateInfo info) throws ServiceException;

    /**
     * 更新留言授权。
     *
     * @param info 留言授权更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(MessageAuthorizationUpdateInfo info) throws ServiceException;

    /**
     * 删除留言授权。
     *
     * @param info 留言授权删除信息。
     * @throws ServiceException 服务异常。
     */
    void remove(MessageAuthorizationRemoveInfo info) throws ServiceException;
}
