package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

import java.util.Collection;

/**
 * 个人简介操作服务。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ProfileOperateService extends Service {

    /**
     * 更新个人设置。
     *
     * @param userKey           个人简介所有者的主键。
     * @param profileUpdateInfo 个人简介的更新信息。
     * @throws ServiceException 服务异常。
     */
    void updateAccountBook(StringIdKey userKey, ProfileUpdateInfo profileUpdateInfo) throws ServiceException;

    /**
     * 添加个人设置的访客权限。
     *
     * @param ownerUserKey 个人设置的所有者的主键。
     * @param guestUserKey 访客的主键。
     * @throws ServiceException 服务异常。
     */
    void addGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws ServiceException;

    /**
     * 移除个人设置的访客权限。
     *
     * @param ownerUserKey 个人设置的所有者的主键。
     * @param guestUserKey 访客的主键。
     * @throws ServiceException 服务异常。
     */
    void removeGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws ServiceException;

    /**
     * 重置个人设置的访客权限。
     *
     * @param ownerUserKey  个人设置的所有者的主键。
     * @param guestUserKeys 访客的主键组成的集合。
     * @throws ServiceException 服务异常。
     */
    void resetGuestPermission(StringIdKey ownerUserKey, Collection<StringIdKey> guestUserKeys) throws ServiceException;
}
