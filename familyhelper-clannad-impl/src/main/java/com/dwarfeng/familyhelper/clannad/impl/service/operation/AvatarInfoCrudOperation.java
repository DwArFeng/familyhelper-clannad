package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo;
import com.dwarfeng.familyhelper.clannad.stack.cache.AvatarInfoCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.AvatarInfoDao;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvatarInfoCrudOperation implements BatchCrudOperation<StringIdKey, AvatarInfo> {

    private final AvatarInfoDao avatarInfoDao;

    private final AvatarInfoCache avatarInfoCache;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.avatar_info}")
    private long avatarInfoTimeout;

    public AvatarInfoCrudOperation(
            AvatarInfoDao avatarInfoDao,
            AvatarInfoCache avatarInfoCache,
            FtpHandler ftpHandler
    ) {
        this.avatarInfoDao = avatarInfoDao;
        this.avatarInfoCache = avatarInfoCache;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public boolean exists(StringIdKey key) throws Exception {
        return avatarInfoCache.exists(key) || avatarInfoDao.exists(key);
    }

    @Override
    public AvatarInfo get(StringIdKey key) throws Exception {
        if (avatarInfoCache.exists(key)) {
            return avatarInfoCache.get(key);
        } else {
            if (!avatarInfoDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            AvatarInfo avatarInfo = avatarInfoDao.get(key);
            avatarInfoCache.push(avatarInfo, avatarInfoTimeout);
            return avatarInfo;
        }
    }

    @Override
    public StringIdKey insert(AvatarInfo avatarInfo) throws Exception {
        avatarInfoCache.push(avatarInfo, avatarInfoTimeout);
        return avatarInfoDao.insert(avatarInfo);
    }

    @Override
    public void update(AvatarInfo avatarInfo) throws Exception {
        avatarInfoCache.push(avatarInfo, avatarInfoTimeout);
        avatarInfoDao.update(avatarInfo);
    }

    @Override
    public void delete(StringIdKey key) throws Exception {
        // 删除用户有关的头像文件。
        if (ftpHandler.existsFile(FtpConstants.PATH_AVATAR, key.getStringId())) {
            ftpHandler.deleteFile(FtpConstants.PATH_AVATAR, key.getStringId());
        }

        // 删除账本实体自身。
        avatarInfoCache.delete(key);
        avatarInfoDao.delete(key);
    }

    @Override
    public boolean allExists(List<StringIdKey> keys) throws Exception {
        return avatarInfoCache.allExists(keys) || avatarInfoDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<StringIdKey> keys) throws Exception {
        return avatarInfoCache.nonExists(keys) && avatarInfoDao.nonExists(keys);
    }

    @Override
    public List<AvatarInfo> batchGet(List<StringIdKey> keys) throws Exception {
        if (avatarInfoCache.allExists(keys)) {
            return avatarInfoCache.batchGet(keys);
        } else {
            if (!avatarInfoDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<AvatarInfo> avatarInfos = avatarInfoDao.batchGet(keys);
            avatarInfoCache.batchPush(avatarInfos, avatarInfoTimeout);
            return avatarInfos;
        }
    }

    @Override
    public List<StringIdKey> batchInsert(List<AvatarInfo> avatarInfos) throws Exception {
        avatarInfoCache.batchPush(avatarInfos, avatarInfoTimeout);
        return avatarInfoDao.batchInsert(avatarInfos);
    }

    @Override
    public void batchUpdate(List<AvatarInfo> avatarInfos) throws Exception {
        avatarInfoCache.batchPush(avatarInfos, avatarInfoTimeout);
        avatarInfoDao.batchUpdate(avatarInfos);
    }

    @Override
    public void batchDelete(List<StringIdKey> keys) throws Exception {
        for (StringIdKey key : keys) {
            delete(key);
        }
    }
}
