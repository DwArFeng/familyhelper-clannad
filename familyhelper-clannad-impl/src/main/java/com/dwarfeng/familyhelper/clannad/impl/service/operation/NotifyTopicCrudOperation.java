package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.NotifyMetaCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.NotifyPreferenceCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.NotifyTopicCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.NotifyMetaDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.NotifyPreferenceDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.NotifyTopicDao;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyMetaMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyPreferenceMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotifyTopicCrudOperation implements BatchCrudOperation<StringIdKey, NotifyTopic> {

    private final NotifyTopicDao notifyTopicDao;
    private final NotifyTopicCache notifyTopicCache;

    private final NotifyPreferenceDao notifyPreferenceDao;
    private final NotifyPreferenceCache notifyPreferenceCache;

    private final NotifyMetaDao notifyMetaDao;
    private final NotifyMetaCache notifyMetaCache;

    @Value("${cache.timeout.entity.notify_topic}")
    private long notifyTopicTimeout;

    public NotifyTopicCrudOperation(
            NotifyTopicDao notifyTopicDao, NotifyTopicCache notifyTopicCache,
            NotifyPreferenceDao notifyPreferenceDao, NotifyPreferenceCache notifyPreferenceCache,
            NotifyMetaDao notifyMetaDao, NotifyMetaCache notifyMetaCache
    ) {
        this.notifyTopicDao = notifyTopicDao;
        this.notifyTopicCache = notifyTopicCache;
        this.notifyPreferenceDao = notifyPreferenceDao;
        this.notifyPreferenceCache = notifyPreferenceCache;
        this.notifyMetaDao = notifyMetaDao;
        this.notifyMetaCache = notifyMetaCache;
    }

    @Override
    public boolean exists(StringIdKey key) throws Exception {
        return notifyTopicCache.exists(key) || notifyTopicDao.exists(key);
    }

    @Override
    public NotifyTopic get(StringIdKey key) throws Exception {
        if (notifyTopicCache.exists(key)) {
            return notifyTopicCache.get(key);
        } else {
            if (!notifyTopicDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            NotifyTopic notifyTopic = notifyTopicDao.get(key);
            notifyTopicCache.push(notifyTopic, notifyTopicTimeout);
            return notifyTopic;
        }
    }

    @Override
    public StringIdKey insert(NotifyTopic notifyTopic) throws Exception {
        notifyTopicCache.push(notifyTopic, notifyTopicTimeout);
        return notifyTopicDao.insert(notifyTopic);
    }

    @Override
    public void update(NotifyTopic notifyTopic) throws Exception {
        notifyTopicCache.push(notifyTopic, notifyTopicTimeout);
        notifyTopicDao.update(notifyTopic);
    }

    @Override
    public void delete(StringIdKey key) throws Exception {
        // 删除与通知主题相关的通知偏好
        List<NotifyNodeKey> notifyNodeKeys = notifyPreferenceDao.lookup(
                NotifyPreferenceMaintainService.CHILD_FOR_NOTIFY_TOPIC, new Object[]{key}
        ).stream().map(NotifyPreference::getKey).collect(Collectors.toList());
        notifyPreferenceCache.batchDelete(notifyNodeKeys);
        notifyPreferenceDao.batchDelete(notifyNodeKeys);

        // 删除与通知主题相关的通知元数据
        notifyNodeKeys = notifyMetaDao.lookup(
                NotifyMetaMaintainService.CHILD_FOR_NOTIFY_TOPIC, new Object[]{key}
        ).stream().map(NotifyMeta::getKey).collect(Collectors.toList());
        notifyMetaCache.batchDelete(notifyNodeKeys);
        notifyMetaDao.batchDelete(notifyNodeKeys);

        // 删除通知设置实体本身。
        notifyTopicDao.delete(key);
        notifyTopicCache.delete(key);
    }

    @Override
    public boolean allExists(List<StringIdKey> keys) throws Exception {
        return notifyTopicCache.allExists(keys) || notifyTopicDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<StringIdKey> keys) throws Exception {
        return notifyTopicCache.nonExists(keys) && notifyTopicCache.nonExists(keys);
    }

    @Override
    public List<NotifyTopic> batchGet(List<StringIdKey> keys) throws Exception {
        if (notifyTopicCache.allExists(keys)) {
            return notifyTopicCache.batchGet(keys);
        } else {
            if (!notifyTopicDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<NotifyTopic> notifyTopics = notifyTopicDao.batchGet(keys);
            notifyTopicCache.batchPush(notifyTopics, notifyTopicTimeout);
            return notifyTopics;
        }
    }

    @Override
    public List<StringIdKey> batchInsert(List<NotifyTopic> notifyTopics) throws Exception {
        notifyTopicCache.batchPush(notifyTopics, notifyTopicTimeout);
        return notifyTopicDao.batchInsert(notifyTopics);
    }

    @Override
    public void batchUpdate(List<NotifyTopic> notifyTopics) throws Exception {
        notifyTopicCache.batchPush(notifyTopics, notifyTopicTimeout);
        notifyTopicDao.batchUpdate(notifyTopics);
    }

    @Override
    public void batchDelete(List<StringIdKey> keys) throws Exception {
        for (StringIdKey key : keys) {
            delete(key);
        }
    }
}