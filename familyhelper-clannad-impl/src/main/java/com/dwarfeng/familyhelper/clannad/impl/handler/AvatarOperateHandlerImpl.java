package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.impl.exception.FileException;
import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarDownloadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo;
import com.dwarfeng.familyhelper.clannad.stack.exception.AvatarNotExistsException;
import com.dwarfeng.familyhelper.clannad.stack.exception.AvatarTransportException;
import com.dwarfeng.familyhelper.clannad.stack.exception.UserNotExistsException;
import com.dwarfeng.familyhelper.clannad.stack.handler.AvatarOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.AvatarInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AvatarOperateHandlerImpl implements AvatarOperateHandler {

    private final UserMaintainService userMaintainService;
    private final AvatarInfoMaintainService avatarInfoMaintainService;
    private final FtpHandler ftpHandler;

    public AvatarOperateHandlerImpl(
            UserMaintainService userMaintainService,
            AvatarInfoMaintainService avatarInfoMaintainService,
            FtpHandler ftpHandler
    ) {
        this.userMaintainService = userMaintainService;
        this.avatarInfoMaintainService = avatarInfoMaintainService;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public AvatarDownloadInfo downloadAvatar(StringIdKey userKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            makeSureUserExists(userKey);

            // 2. 确认头像存在。
            makeSureAvatarExists(userKey);

            // 3. 获取头像信息。
            AvatarInfo avatarInfo = avatarInfoMaintainService.get(userKey);

            // 4. 下载头像。
            byte[] content = ftpHandler.getFileContent(new String[]{FtpConstants.PATH_AVATAR}, userKey.getStringId());

            // 5. 拼接 AvatarDownloadInfo 并返回。
            return new AvatarDownloadInfo(avatarInfo.getOriginName(), content);
        } catch (FileException e) {
            throw new AvatarTransportException(e, userKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void uploadAvatar(StringIdKey userKey, AvatarUploadInfo avatarUploadInfo) throws HandlerException {
        try {
            // 1. 确认用户存在。
            makeSureUserExists(userKey);

            // 2. 获取头像内容并存储（覆盖）。
            byte[] content = avatarUploadInfo.getContent();
            ftpHandler.storeFile(new String[]{FtpConstants.PATH_AVATAR}, userKey.getStringId(), content);

            // 3. 构造 AvatarInfo 实体，插入或更新。
            AvatarInfo avatarInfo = new AvatarInfo(
                    userKey, avatarUploadInfo.getOriginName(), content.length, new Date(),
                    "由 familyhelper-clannad 微服务进行上传"
            );
            avatarInfoMaintainService.insertOrUpdate(avatarInfo);
        } catch (FileException e) {
            throw new AvatarTransportException(e, userKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeAvatar(StringIdKey userKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            makeSureUserExists(userKey);

            // 2. 如果存在 Avatar 文件，则删除。
            if (ftpHandler.existsFile(new String[]{FtpConstants.PATH_AVATAR}, userKey.getStringId())) {
                ftpHandler.deleteFile(new String[]{FtpConstants.PATH_AVATAR}, userKey.getStringId());
            }

            // 3. 如果存在 AvatarInfo 实体，则删除。
            avatarInfoMaintainService.deleteIfExists(userKey);
        } catch (FileException e) {
            throw new AvatarTransportException(e, userKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    private void makeSureUserExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!userMaintainService.exists(userKey)) {
                throw new UserNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    private void makeSureAvatarExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!avatarInfoMaintainService.exists(userKey)) {
                throw new AvatarNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
