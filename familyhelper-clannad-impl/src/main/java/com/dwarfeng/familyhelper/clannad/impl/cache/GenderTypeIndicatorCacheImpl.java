package com.dwarfeng.familyhelper.clannad.impl.cache;

import com.dwarfeng.familyhelper.clannad.sdk.bean.entity.FastJsonGenderTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.cache.GenderTypeIndicatorCache;
import com.dwarfeng.subgrade.impl.cache.RedisBatchBaseCache;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.BehaviorAnalyse;
import com.dwarfeng.subgrade.sdk.interceptor.analyse.SkipRecord;
import com.dwarfeng.subgrade.stack.bean.key.IntegerIdKey;
import com.dwarfeng.subgrade.stack.exception.CacheException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GenderTypeIndicatorCacheImpl implements GenderTypeIndicatorCache {

    private final RedisBatchBaseCache<IntegerIdKey, GenderTypeIndicator, FastJsonGenderTypeIndicator>
            genderTypeIndicatorBatchBaseDelegate;

    public GenderTypeIndicatorCacheImpl(
            RedisBatchBaseCache<IntegerIdKey, GenderTypeIndicator, FastJsonGenderTypeIndicator>
                    genderTypeIndicatorBatchBaseDelegate
    ) {
        this.genderTypeIndicatorBatchBaseDelegate = genderTypeIndicatorBatchBaseDelegate;
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public boolean exists(IntegerIdKey key) throws CacheException {
        return genderTypeIndicatorBatchBaseDelegate.exists(key);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public GenderTypeIndicator get(IntegerIdKey key) throws CacheException {
        return genderTypeIndicatorBatchBaseDelegate.get(key);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void push(GenderTypeIndicator value, long timeout) throws CacheException {
        genderTypeIndicatorBatchBaseDelegate.push(value, timeout);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void delete(IntegerIdKey key) throws CacheException {
        genderTypeIndicatorBatchBaseDelegate.delete(key);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void clear() throws CacheException {
        genderTypeIndicatorBatchBaseDelegate.clear();
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public boolean allExists(@SkipRecord List<IntegerIdKey> keys) throws CacheException {
        return genderTypeIndicatorBatchBaseDelegate.allExists(keys);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public boolean nonExists(@SkipRecord List<IntegerIdKey> keys) throws CacheException {
        return genderTypeIndicatorBatchBaseDelegate.nonExists(keys);
    }

    @Override
    @BehaviorAnalyse
    @SkipRecord
    @Transactional(transactionManager = "hibernateTransactionManager", readOnly = true, rollbackFor = Exception.class)
    public List<GenderTypeIndicator> batchGet(@SkipRecord List<IntegerIdKey> keys) throws CacheException {
        return genderTypeIndicatorBatchBaseDelegate.batchGet(keys);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void batchPush(@SkipRecord List<GenderTypeIndicator> entities, long timeout) throws CacheException {
        genderTypeIndicatorBatchBaseDelegate.batchPush(entities, timeout);
    }

    @Override
    @BehaviorAnalyse
    @Transactional(transactionManager = "hibernateTransactionManager", rollbackFor = Exception.class)
    public void batchDelete(@SkipRecord List<IntegerIdKey> keys) throws CacheException {
        genderTypeIndicatorBatchBaseDelegate.batchDelete(keys);
    }
}
