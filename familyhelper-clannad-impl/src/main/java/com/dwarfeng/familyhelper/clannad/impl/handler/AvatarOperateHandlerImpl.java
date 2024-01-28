package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.Avatar;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.AvatarOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.AvatarInfoMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AvatarOperateHandlerImpl implements AvatarOperateHandler {

    private final AvatarInfoMaintainService avatarInfoMaintainService;
    private final FtpHandler ftpHandler;

    private final OperateHandlerValidator operateHandlerValidator;

    public AvatarOperateHandlerImpl(
            AvatarInfoMaintainService avatarInfoMaintainService,
            FtpHandler ftpHandler,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.avatarInfoMaintainService = avatarInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public Avatar downloadAvatar(StringIdKey userKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认头像存在。
            operateHandlerValidator.makeSureAvatarExists(userKey);

            // 3. 获取头像信息。
            AvatarInfo avatarInfo = avatarInfoMaintainService.get(userKey);

            // 4. 下载头像。
            byte[] content = ftpHandler.retrieveFile(FtpConstants.PATH_AVATAR, userKey.getStringId());

            // 5. 拼接 Avatar 并返回。
            return new Avatar(avatarInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void uploadAvatar(StringIdKey userKey, AvatarUploadInfo avatarUploadInfo) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 获取头像内容并存储（覆盖）。
            byte[] content = avatarUploadInfo.getContent();
            ftpHandler.storeFile(FtpConstants.PATH_AVATAR, userKey.getStringId(), content);

            // 3. 构造 AvatarInfo 实体，插入或更新。
            AvatarInfo avatarInfo = new AvatarInfo(
                    userKey, avatarUploadInfo.getOriginName(), content.length, new Date(),
                    "由 familyhelper-clannad 微服务进行上传"
            );
            avatarInfoMaintainService.insertOrUpdate(avatarInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void removeAvatar(StringIdKey userKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 如果存在 Avatar 文件，则删除。
            if (ftpHandler.existsFile(FtpConstants.PATH_AVATAR, userKey.getStringId())) {
                ftpHandler.deleteFile(FtpConstants.PATH_AVATAR, userKey.getStringId());
            }

            // 3. 如果存在 AvatarInfo 实体，则删除。
            avatarInfoMaintainService.deleteIfExists(userKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
