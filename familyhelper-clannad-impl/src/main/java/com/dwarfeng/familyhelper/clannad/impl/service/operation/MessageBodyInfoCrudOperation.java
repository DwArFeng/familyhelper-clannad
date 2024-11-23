package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.familyhelper.clannad.stack.cache.MessageBodyInfoCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.MessageBodyInfoDao;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageBodyInfoCrudOperation implements BatchCrudOperation<LongIdKey, MessageBodyInfo> {

    private final MessageBodyInfoDao messageBodyInfoDao;
    private final MessageBodyInfoCache messageBodyInfoCache;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.message_body_info}")
    private long messageBodyInfoTimeout;

    public MessageBodyInfoCrudOperation(
            MessageBodyInfoDao messageBodyInfoDao,
            MessageBodyInfoCache messageBodyInfoCache,
            FtpHandler ftpHandler
    ) {
        this.messageBodyInfoDao = messageBodyInfoDao;
        this.messageBodyInfoCache = messageBodyInfoCache;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return messageBodyInfoCache.exists(key) || messageBodyInfoDao.exists(key);
    }

    @Override
    public MessageBodyInfo get(LongIdKey key) throws Exception {
        if (messageBodyInfoCache.exists(key)) {
            return messageBodyInfoCache.get(key);
        } else {
            if (!messageBodyInfoDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            MessageBodyInfo messageBodyInfo = messageBodyInfoDao.get(key);
            messageBodyInfoCache.push(messageBodyInfo, messageBodyInfoTimeout);
            return messageBodyInfo;
        }
    }

    @Override
    public LongIdKey insert(MessageBodyInfo messageBodyInfo) throws Exception {
        messageBodyInfoCache.push(messageBodyInfo, messageBodyInfoTimeout);
        return messageBodyInfoDao.insert(messageBodyInfo);
    }

    @Override
    public void update(MessageBodyInfo messageBodyInfo) throws Exception {
        messageBodyInfoCache.push(messageBodyInfo, messageBodyInfoTimeout);
        messageBodyInfoDao.update(messageBodyInfo);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 如果存在留言正文文件，则删除留言正文文件。
        if (ftpHandler.existsFile(FtpConstants.PATH_MESSAGE_BODY, getFileName(key))) {
            ftpHandler.deleteFile(FtpConstants.PATH_MESSAGE_BODY, getFileName(key));
        }

        // 删除留言正文文件信息实体自身。
        messageBodyInfoCache.delete(key);
        messageBodyInfoDao.delete(key);
    }

    private String getFileName(LongIdKey messageBodyKey) {
        return Long.toString(messageBodyKey.getLongId());
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return messageBodyInfoCache.allExists(keys) || messageBodyInfoDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return messageBodyInfoCache.nonExists(keys) && messageBodyInfoDao.nonExists(keys);
    }

    @Override
    public List<MessageBodyInfo> batchGet(List<LongIdKey> keys) throws Exception {
        if (messageBodyInfoCache.allExists(keys)) {
            return messageBodyInfoCache.batchGet(keys);
        } else {
            if (!messageBodyInfoDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<MessageBodyInfo> messageBodyInfos = messageBodyInfoDao.batchGet(keys);
            messageBodyInfoCache.batchPush(messageBodyInfos, messageBodyInfoTimeout);
            return messageBodyInfos;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<MessageBodyInfo> messageBodyInfos) throws Exception {
        messageBodyInfoCache.batchPush(messageBodyInfos, messageBodyInfoTimeout);
        return messageBodyInfoDao.batchInsert(messageBodyInfos);
    }

    @Override
    public void batchUpdate(List<MessageBodyInfo> messageBodyInfos) throws Exception {
        messageBodyInfoCache.batchPush(messageBodyInfos, messageBodyInfoTimeout);
        messageBodyInfoDao.batchUpdate(messageBodyInfos);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
