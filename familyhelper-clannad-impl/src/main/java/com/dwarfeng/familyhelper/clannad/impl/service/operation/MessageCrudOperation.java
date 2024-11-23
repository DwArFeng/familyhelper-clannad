package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo;
import com.dwarfeng.familyhelper.clannad.stack.cache.MessageCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.MessageAttachmentInfoDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.MessageBodyInfoDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.MessageDao;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageAttachmentInfoMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageCrudOperation implements BatchCrudOperation<LongIdKey, Message> {

    private final MessageDao messageDao;
    private final MessageCache messageCache;

    private final MessageBodyInfoCrudOperation messageBodyInfoCrudOperation;
    private final MessageBodyInfoDao messageBodyInfoDao;

    private final MessageAttachmentInfoCrudOperation messageAttachmentInfoCrudOperation;
    private final MessageAttachmentInfoDao messageAttachmentInfoDao;

    @Value("${cache.timeout.entity.message}")
    private long messageTimeout;

    public MessageCrudOperation(
            MessageDao messageDao,
            MessageCache messageCache,
            MessageBodyInfoCrudOperation messageBodyInfoCrudOperation,
            MessageBodyInfoDao messageBodyInfoDao,
            MessageAttachmentInfoCrudOperation messageAttachmentInfoCrudOperation,
            MessageAttachmentInfoDao messageAttachmentInfoDao
    ) {
        this.messageDao = messageDao;
        this.messageCache = messageCache;
        this.messageBodyInfoCrudOperation = messageBodyInfoCrudOperation;
        this.messageBodyInfoDao = messageBodyInfoDao;
        this.messageAttachmentInfoCrudOperation = messageAttachmentInfoCrudOperation;
        this.messageAttachmentInfoDao = messageAttachmentInfoDao;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return messageCache.exists(key) || messageDao.exists(key);
    }

    @Override
    public Message get(LongIdKey key) throws Exception {
        if (messageCache.exists(key)) {
            return messageCache.get(key);
        } else {
            if (!messageDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            Message message = messageDao.get(key);
            messageCache.push(message, messageTimeout);
            return message;
        }
    }

    @Override
    public LongIdKey insert(Message message) throws Exception {
        messageCache.push(message, messageTimeout);
        return messageDao.insert(message);
    }

    @Override
    public void update(Message message) throws Exception {
        messageCache.push(message, messageTimeout);
        messageDao.update(message);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 删除与 留言 相关的 正文信息。
        if (messageBodyInfoDao.exists(key)) {
            messageBodyInfoCrudOperation.delete(key);
        }

        // 删除与 留言 相关的 附件信息。
        List<LongIdKey> messageAttachmentInfoKeys = messageAttachmentInfoDao.lookup(
                MessageAttachmentInfoMaintainService.CHILD_FOR_MESSAGE, new Object[]{key}
        ).stream().map(MessageAttachmentInfo::getKey).collect(Collectors.toList());
        messageAttachmentInfoCrudOperation.batchDelete(messageAttachmentInfoKeys);

        // 删除 留言 自身。
        messageDao.delete(key);
        messageCache.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return messageCache.allExists(keys) || messageDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return messageCache.nonExists(keys) && messageDao.nonExists(keys);
    }

    @Override
    public List<Message> batchGet(List<LongIdKey> keys) throws Exception {
        if (messageCache.allExists(keys)) {
            return messageCache.batchGet(keys);
        } else {
            if (!messageDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<Message> messages = messageDao.batchGet(keys);
            messageCache.batchPush(messages, messageTimeout);
            return messages;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<Message> messages) throws Exception {
        messageCache.batchPush(messages, messageTimeout);
        return messageDao.batchInsert(messages);
    }

    @Override
    public void batchUpdate(List<Message> messages) throws Exception {
        messageCache.batchPush(messages, messageTimeout);
        messageDao.batchUpdate(messages);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
