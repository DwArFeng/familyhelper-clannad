package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

import java.util.Collection;

/**
 * 个人简介操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ProfileOperateHandler extends Handler {

    /**
     * 更新个人设置。
     *
     * @param userKey           个人简介所有者的主键。
     * @param profileUpdateInfo 个人简介的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateProfile(StringIdKey userKey, ProfileUpdateInfo profileUpdateInfo) throws HandlerException;

    /**
     * 添加账本的访客权限。
     *
     * @param ownerUserKey 账本的所有者的主键。
     * @param guestUserKey 访客的主键。
     * @throws HandlerException 处理器异常。
     */
    void addGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws HandlerException;

    /**
     * 移除账本的访客权限。
     *
     * @param ownerUserKey 账本的所有者的主键。
     * @param guestUserKey 访客的主键。
     * @throws HandlerException 处理器异常。
     */
    void removeGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws HandlerException;

    /**
     * 重置个人设置的访客权限。
     *
     * @param ownerUserKey  个人设置的所有者的主键。
     * @param guestUserKeys 访客的主键组成的集合。
     * @throws HandlerException 处理器异常。
     */
    void resetGuestPermission(StringIdKey ownerUserKey, Collection<StringIdKey> guestUserKeys) throws HandlerException;
}
