package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.Avatar;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 头像操作处理器。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public interface AvatarOperateHandler extends Handler {

    /**
     * 下载头像。
     *
     * @param userKey 用户主键。
     * @return 头像下载信息。
     * @throws HandlerException 处理器异常。
     */
    Avatar downloadAvatar(StringIdKey userKey) throws HandlerException;

    /**
     * 上传头像。
     *
     * @param userKey 用户主键。
     * @throws HandlerException 处理器异常。
     */
    void uploadAvatar(StringIdKey userKey, AvatarUploadInfo avatarUploadInfo) throws HandlerException;

    /**
     * 移除头像。
     *
     * @param userKey 用户主键。
     * @throws HandlerException 处理器异常。
     */
    void removeAvatar(StringIdKey userKey) throws HandlerException;
}
