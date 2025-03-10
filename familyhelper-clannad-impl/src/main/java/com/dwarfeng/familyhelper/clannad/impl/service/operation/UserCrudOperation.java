package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.*;
import com.dwarfeng.familyhelper.clannad.stack.dao.*;
import com.dwarfeng.familyhelper.clannad.stack.service.*;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserCrudOperation implements BatchCrudOperation<StringIdKey, User> {

    private final UserDao userDao;
    private final UserCache userCache;

    private final PoprDao poprDao;
    private final PoprCache poprCache;

    private final NicknameDao nicknameDao;
    private final NicknameCache nicknameCache;

    private final ProfileDao profileDao;
    private final ProfileCache profileCache;

    private final AvatarInfoDao avatarInfoDao;
    private final AvatarInfoCache avatarInfoCache;

    private final NotificationDao notificationDao;
    private final NotificationCache notificationCache;

    private final PoceDao poceDao;
    private final PoceCache poceCache;

    private final MessageCrudOperation messageCrudOperation;
    private final MessageDao messageDao;

    private final MessageAuthorizationDao messageAuthorizationDao;
    private final MessageAuthorizationCache messageAuthorizationCache;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.user}")
    private long userTimeout;

    public UserCrudOperation(
            UserDao userDao,
            UserCache userCache,
            PoprDao poprDao,
            PoprCache poprCache,
            NicknameDao nicknameDao,
            NicknameCache nicknameCache,
            ProfileDao profileDao,
            ProfileCache profileCache,
            AvatarInfoDao avatarInfoDao,
            AvatarInfoCache avatarInfoCache,
            NotificationDao notificationDao,
            NotificationCache notificationCache,
            PoceDao poceDao,
            PoceCache poceCache,
            MessageCrudOperation messageCrudOperation,
            MessageDao messageDao,
            MessageAuthorizationDao messageAuthorizationDao,
            MessageAuthorizationCache messageAuthorizationCache,
            FtpHandler ftpHandler
    ) {
        this.userDao = userDao;
        this.userCache = userCache;
        this.poprDao = poprDao;
        this.poprCache = poprCache;
        this.nicknameDao = nicknameDao;
        this.nicknameCache = nicknameCache;
        this.profileDao = profileDao;
        this.profileCache = profileCache;
        this.avatarInfoDao = avatarInfoDao;
        this.avatarInfoCache = avatarInfoCache;
        this.notificationDao = notificationDao;
        this.notificationCache = notificationCache;
        this.poceDao = poceDao;
        this.poceCache = poceCache;
        this.messageCrudOperation = messageCrudOperation;
        this.messageDao = messageDao;
        this.messageAuthorizationDao = messageAuthorizationDao;
        this.messageAuthorizationCache = messageAuthorizationCache;
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
        if (ftpHandler.existsFile(FtpConstants.PATH_AVATAR, key.getStringId())) {
            ftpHandler.deleteFile(FtpConstants.PATH_AVATAR, key.getStringId());
        }

        // 删除与用户相关的头像信息。
        if (avatarInfoDao.exists(key)) {
            avatarInfoCache.delete(key);
            avatarInfoDao.delete(key);
        }

        // 删除与用户相关的通知。
        List<LongIdKey> notificationKeys = notificationDao.lookup(
                NotificationMaintainService.CHILD_FOR_USER, new Object[]{key}
        ).stream().map(Notification::getKey).collect(Collectors.toList());
        notificationCache.batchDelete(notificationKeys);
        notificationDao.batchDelete(notificationKeys);

        // 删除与用户相关的证书权限。
        List<PoceKey> poceKeys = poceDao.lookup(PoceMaintainService.CHILD_FOR_USER, new Object[]{key})
                .stream().map(Poce::getKey).collect(Collectors.toList());
        poceCache.batchDelete(poceKeys);
        poceDao.batchDelete(poceKeys);

        // 删除与用户相关的留言。
        List<LongIdKey> sendMessageKeys = messageDao.lookup(
                MessageMaintainService.CHILD_FOR_SEND_USER, new Object[]{key}
        ).stream().map(Message::getKey).collect(Collectors.toList());
        messageCrudOperation.batchDelete(sendMessageKeys);
        List<LongIdKey> receiveMessageKeys = messageDao.lookup(
                MessageMaintainService.CHILD_FOR_RECEIVE_USER, new Object[]{key}
        ).stream().map(Message::getKey).collect(Collectors.toList());
        messageCrudOperation.batchDelete(receiveMessageKeys);

        // 删除与用户相关的留言授权。
        List<MessageAuthorizationKey> receiveMessageAuthorizationKeys = messageAuthorizationDao.lookup(
                MessageAuthorizationMaintainService.CHILD_FOR_RECEIVE_USER, new Object[]{key}
        ).stream().map(MessageAuthorization::getKey).collect(Collectors.toList());
        messageAuthorizationCache.batchDelete(receiveMessageAuthorizationKeys);
        messageAuthorizationDao.batchDelete(receiveMessageAuthorizationKeys);
        List<MessageAuthorizationKey> authorizedSendMessageAuthorizationKeys = messageAuthorizationDao.lookup(
                MessageAuthorizationMaintainService.CHILD_FOR_AUTHORIZED_SEND_USER, new Object[]{key}
        ).stream().map(MessageAuthorization::getKey).collect(Collectors.toList());
        messageAuthorizationCache.batchDelete(authorizedSendMessageAuthorizationKeys);
        messageAuthorizationDao.batchDelete(authorizedSendMessageAuthorizationKeys);

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
