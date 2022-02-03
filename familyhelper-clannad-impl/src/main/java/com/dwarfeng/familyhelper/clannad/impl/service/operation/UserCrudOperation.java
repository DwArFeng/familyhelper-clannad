package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.*;
import com.dwarfeng.familyhelper.clannad.stack.dao.*;
import com.dwarfeng.familyhelper.clannad.stack.service.NicknameMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.PoprMaintainService;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserCrudOperation implements BatchCrudOperation<StringIdKey, User> {

    private final UserDao userDao;
    private final PoprDao poprDao;
    private final NicknameDao nicknameDao;
    private final ProfileDao profileDao;
    private final AvatarInfoDao avatarInfoDao;

    private final UserCache userCache;
    private final PoprCache poprCache;
    private final NicknameCache nicknameCache;
    private final ProfileCache profileCache;
    private final AvatarInfoCache avatarInfoCache;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.user}")
    private long userTimeout;

    public UserCrudOperation(
            UserDao userDao, PoprDao poprDao, NicknameDao nicknameDao, ProfileDao profileDao,
            AvatarInfoDao avatarInfoDao, UserCache userCache, PoprCache poprCache, NicknameCache nicknameCache,
            ProfileCache profileCache, AvatarInfoCache avatarInfoCache,
            FtpHandler ftpHandler
    ) {
        this.userDao = userDao;
        this.poprDao = poprDao;
        this.nicknameDao = nicknameDao;
        this.profileDao = profileDao;
        this.avatarInfoDao = avatarInfoDao;
        this.userCache = userCache;
        this.poprCache = poprCache;
        this.nicknameCache = nicknameCache;
        this.profileCache = profileCache;
        this.avatarInfoCache = avatarInfoCache;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public boolean exists(StringIdKey key) throws Exception {
        return userCache.exists(key) || userDao.exists(key);
    }

    @Override
    public User get(StringIdKey key) throws Exception {
        if (userCache.exists(key)) {
            return userCache.get(key);
        } else {
            if (!userDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            User user = userDao.get(key);
            userCache.push(user, userTimeout);
            return user;
        }
    }

    @Override
    public StringIdKey insert(User user) throws Exception {
        userCache.push(user, userTimeout);
        return userDao.insert(user);
    }

    @Override
    public void update(User user) throws Exception {
        userCache.push(user, userTimeout);
        userDao.update(user);
    }

    @Override
    public void delete(StringIdKey key) throws Exception {
        // 删除与用户相关的个人简介权限。
        List<PoprKey> poprKeys = poprDao.lookup(PoprMaintainService.CHILD_FOR_USER, new Object[]{key})
                .stream().map(Popr::getKey).collect(Collectors.toList());
        poprCache.batchDelete(poprKeys);
        poprDao.batchDelete(poprKeys);
        poprKeys = poprDao.lookup(PoprMaintainService.CHILD_FOR_PROFILE, new Object[]{key})
                .stream().map(Popr::getKey).collect(Collectors.toList());
        poprCache.batchDelete(poprKeys);
        poprDao.batchDelete(poprKeys);

        // 删除与用户相关的昵称。
        List<NicknameKey> nicknameKeys = nicknameDao.lookup(
                NicknameMaintainService.CHILD_FOR_SUBJECT_USER, new Object[]{key}
        ).stream().map(Nickname::getKey).collect(Collectors.toList());
        nicknameCache.batchDelete(nicknameKeys);
        nicknameDao.batchDelete(nicknameKeys);
        nicknameKeys = nicknameDao.lookup(NicknameMaintainService.CHILD_FOR_OBJECT_USER, new Object[]{key})
                .stream().map(Nickname::getKey).collect(Collectors.toList());
        nicknameCache.batchDelete(nicknameKeys);
        nicknameDao.batchDelete(nicknameKeys);

        // 删除与用户相关的个人简介。
        if (profileDao.exists(key)) {
            profileCache.delete(key);
            profileDao.delete(key);
        }

        // 删除用户有关的头像文件。
        if (ftpHandler.existsFile(new String[]{FtpConstants.PATH_AVATAR}, key.getStringId())) {
            ftpHandler.deleteFile(new String[]{FtpConstants.PATH_AVATAR}, key.getStringId());
        }

        // 删除与用户相关的头像信息。
        if (avatarInfoDao.exists(key)) {
            avatarInfoCache.delete(key);
            avatarInfoDao.delete(key);
        }

        // 删除账本实体自身。
        userCache.delete(key);
        userDao.delete(key);
    }

    @Override
    public boolean allExists(List<StringIdKey> keys) throws Exception {
        return userCache.allExists(keys) || userDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<StringIdKey> keys) throws Exception {
        return userCache.nonExists(keys) && userDao.nonExists(keys);
    }

    @Override
    public List<User> batchGet(List<StringIdKey> keys) throws Exception {
        if (userCache.allExists(keys)) {
            return userCache.batchGet(keys);
        } else {
            if (!userDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<User> users = userDao.batchGet(keys);
            userCache.batchPush(users, userTimeout);
            return users;
        }
    }

    @Override
    public List<StringIdKey> batchInsert(List<User> users) throws Exception {
        userCache.batchPush(users, userTimeout);
        return userDao.batchInsert(users);
    }

    @Override
    public void batchUpdate(List<User> users) throws Exception {
        userCache.batchPush(users, userTimeout);
        userDao.batchUpdate(users);
    }

    @Override
    public void batchDelete(List<StringIdKey> keys) throws Exception {
        for (StringIdKey key : keys) {
            delete(key);
        }
    }
}
