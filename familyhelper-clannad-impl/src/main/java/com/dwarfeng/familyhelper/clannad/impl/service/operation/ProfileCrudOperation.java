package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.PoprCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.ProfileCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.PoprDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.ProfileDao;
import com.dwarfeng.familyhelper.clannad.stack.service.PoprMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfileCrudOperation implements BatchCrudOperation<StringIdKey, Profile> {

    private final ProfileDao profileDao;
    private final PoprDao poprDao;

    private final ProfileCache profileCache;
    private final PoprCache poprCache;

    @Value("${cache.timeout.entity.profile}")
    private long profileTimeout;

    public ProfileCrudOperation(
            ProfileDao profileDao, PoprDao poprDao, ProfileCache profileCache, PoprCache poprCache
    ) {
        this.profileDao = profileDao;
        this.poprDao = poprDao;
        this.profileCache = profileCache;
        this.poprCache = poprCache;
    }

    @Override
    public boolean exists(StringIdKey key) throws Exception {
        return profileCache.exists(key) || profileDao.exists(key);
    }

    @Override
    public Profile get(StringIdKey key) throws Exception {
        if (profileCache.exists(key)) {
            return profileCache.get(key);
        } else {
            if (!profileDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            Profile profile = profileDao.get(key);
            profileCache.push(profile, profileTimeout);
            return profile;
        }
    }

    @Override
    public StringIdKey insert(Profile profile) throws Exception {
        profileCache.push(profile, profileTimeout);
        return profileDao.insert(profile);
    }

    @Override
    public void update(Profile profile) throws Exception {
        profileCache.push(profile, profileTimeout);
        profileDao.update(profile);
    }

    @Override
    public void delete(StringIdKey key) throws Exception {
        // 删除与账本相关的账本权限。
        List<PoprKey> poprKeys = poprDao.lookup(PoprMaintainService.CHILD_FOR_PROFILE, new Object[]{key})
                .stream().map(Popr::getKey).collect(Collectors.toList());
        poprCache.batchDelete(poprKeys);
        poprDao.batchDelete(poprKeys);

        // 删除账本实体自身。
        profileCache.delete(key);
        profileDao.delete(key);
    }

    @Override
    public boolean allExists(List<StringIdKey> keys) throws Exception {
        return profileCache.allExists(keys) || profileDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<StringIdKey> keys) throws Exception {
        return profileCache.nonExists(keys) && profileDao.nonExists(keys);
    }

    @Override
    public List<Profile> batchGet(List<StringIdKey> keys) throws Exception {
        if (profileCache.allExists(keys)) {
            return profileCache.batchGet(keys);
        } else {
            if (!profileDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<Profile> profiles = profileDao.batchGet(keys);
            profileCache.batchPush(profiles, profileTimeout);
            return profiles;
        }
    }

    @Override
    public List<StringIdKey> batchInsert(List<Profile> profiles) throws Exception {
        profileCache.batchPush(profiles, profileTimeout);
        return profileDao.batchInsert(profiles);
    }

    @Override
    public void batchUpdate(List<Profile> profiles) throws Exception {
        profileCache.batchPush(profiles, profileTimeout);
        profileDao.batchUpdate(profiles);
    }

    @Override
    public void batchDelete(List<StringIdKey> keys) throws Exception {
        for (StringIdKey key : keys) {
            delete(key);
        }
    }
}
