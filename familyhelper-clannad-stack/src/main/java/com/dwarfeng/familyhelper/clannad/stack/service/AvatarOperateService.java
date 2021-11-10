package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarDownloadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 头像操作服务。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public interface AvatarOperateService extends Service {

    /**
     * 下载头像。
     *
     * @param userKey 用户主键。
     * @return 头像下载信息。
     * @throws ServiceException 服务异常。
     */
    AvatarDownloadInfo downloadAvatar(StringIdKey userKey) throws ServiceException;

    /**
     * 上传头像。
     *
     * @param userKey 用户主键。
     * @throws ServiceException 服务异常。
     */
    void uploadAvatar(StringIdKey userKey, AvatarUploadInfo avatarUploadInfo) throws ServiceException;

    /**
     * 移除头像。
     *
     * @param userKey 用户主键。
     * @throws ServiceException 服务异常。
     */
    void removeAvatar(StringIdKey userKey) throws ServiceException;
}
