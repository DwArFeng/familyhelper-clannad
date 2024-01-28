package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.ProfileOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.ProfileOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfileOperateServiceImpl implements ProfileOperateService {

    private final ProfileOperateHandler profileOperateHandler;

    private final ServiceExceptionMapper sem;

    public ProfileOperateServiceImpl(ProfileOperateHandler profileOperateHandler, ServiceExceptionMapper sem) {
        this.profileOperateHandler = profileOperateHandler;
        this.sem = sem;
    }

    @Override
    public void updateProfile(StringIdKey userKey, ProfileUpdateInfo profileUpdateInfo) throws ServiceException {
        try {
            profileOperateHandler.updateProfile(userKey, profileUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新个人设置时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void addGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws ServiceException {
        try {
            profileOperateHandler.addGuestPermission(ownerUserKey, guestUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("添加个人设置的访客权限时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removeGuestPermission(StringIdKey ownerUserKey, StringIdKey guestUserKey) throws ServiceException {
        try {
            profileOperateHandler.removeGuestPermission(ownerUserKey, guestUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("移除个人设置的访客权限时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void resetGuestPermission(StringIdKey ownerUserKey, Collection<StringIdKey> guestUserKeys)
            throws ServiceException {
        try {
            profileOperateHandler.resetGuestPermission(ownerUserKey, guestUserKeys);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("重置个人设置的访客权限时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
