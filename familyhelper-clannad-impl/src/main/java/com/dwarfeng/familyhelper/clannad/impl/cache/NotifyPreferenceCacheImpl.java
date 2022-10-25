package com.dwarfeng.familyhelper.clannad.impl.cache;

import com.dwarfeng.familyhelper.clannad.sdk.bean.entity.FastJsonNotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.NotifyPreferenceCache;
import com.dwarfeng.subgrade.impl.cache.RedisBatchBaseCache;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.BehaviorAnalyse;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.SkipRecord;
import com.dwarfeng.subgrade.stack.exception.CacheException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NotifyPreferenceCacheImpl implements NotifyPreferenceCache {

    private final RedisBatchBaseCache<NotifyPreferenceKey, NotifyPreference, FastJsonNotifyPreference>
            notifyPreferenceBatchBaseDelegate;

    public NotifyPreferenceCacheImpl(
            RedisBatchBaseCache<NotifyPreferenceKey, NotifyPreference, FastJsonNotifyPreference>
                    notifyPreferenceBatchBaseDelegate
    ) {
        this.notifyPreferenceBatchBaseDelegate = notifyPreferenceBatchBaseDelegate;
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public boolean exists(NotifyPreferenceKey key) throws CacheException {
        return notifyPreferenceBatchBaseDelegate.exists(key);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public NotifyPreference get(NotifyPreferenceKey key) throws CacheException {
        return notifyPreferenceBatchBaseDelegate.get(key);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void push(NotifyPreference value, long timeout) throws CacheException {
        notifyPreferenceBatchBaseDelegate.push(value, timeout);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void delete(NotifyPreferenceKey key) throws CacheException {
        notifyPreferenceBatchBaseDelegate.delete(key);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void clear() throws CacheException {
        notifyPreferenceBatchBaseDelegate.clear();
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public boolean allExists(@SkipRecord List<NotifyPreferenceKey> keys) throws CacheException {
        return notifyPreferenceBatchBaseDelegate.allExists(keys);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public boolean nonExists(@SkipRecord List<NotifyPreferenceKey> keys) throws CacheException {
        return notifyPreferenceBatchBaseDelegate.nonExists(keys);
    }

    @Override
    @BehaviorAnalyse
    @SkipRecord
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public List<NotifyPreference> batchGet(@SkipRecord List<NotifyPreferenceKey> keys) throws CacheException {
        return notifyPreferenceBatchBaseDelegate.batchGet(keys);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void batchPush(@SkipRecord List<NotifyPreference> entities, long timeout) throws CacheException {
        notifyPreferenceBatchBaseDelegate.batchPush(entities, timeout);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void batchDelete(@SkipRecord List<NotifyPreferenceKey> keys) throws CacheException {
        notifyPreferenceBatchBaseDelegate.batchDelete(keys);
    }
}
