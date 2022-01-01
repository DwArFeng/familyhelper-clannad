package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.Avatar;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.AvatarOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.AvatarOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class AvatarOperateServiceImpl implements AvatarOperateService {

    private final AvatarOperateHandler avatarOperateHandler;

    private final ServiceExceptionMapper sem;

    public AvatarOperateServiceImpl(AvatarOperateHandler avatarOperateHandler, ServiceExceptionMapper sem) {
        this.avatarOperateHandler = avatarOperateHandler;
        this.sem = sem;
    }

    @Override
    public Avatar downloadAvatar(StringIdKey userKey) throws ServiceException {
        try {
            return avatarOperateHandler.downloadAvatar(userKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("下载头像时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void uploadAvatar(StringIdKey userKey, AvatarUploadInfo avatarUploadInfo) throws ServiceException {
        try {
            avatarOperateHandler.uploadAvatar(userKey, avatarUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("上传头像时发生异常", LogLevel.WARN, sem, e);
        }
    }

    @Override
    public void removeAvatar(StringIdKey userKey) throws ServiceException {
        try {
            avatarOperateHandler.removeAvatar(userKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("移除头像时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
