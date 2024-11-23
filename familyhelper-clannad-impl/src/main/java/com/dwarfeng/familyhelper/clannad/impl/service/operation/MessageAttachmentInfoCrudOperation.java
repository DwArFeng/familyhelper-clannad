package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo;
import com.dwarfeng.familyhelper.clannad.stack.cache.MessageAttachmentInfoCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.MessageAttachmentInfoDao;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageAttachmentInfoCrudOperation implements BatchCrudOperation<LongIdKey, MessageAttachmentInfo> {

    private final MessageAttachmentInfoDao messageAttachmentInfoDao;
    private final MessageAttachmentInfoCache messageAttachmentInfoCache;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.message_attachment_info}")
    private long messageAttachmentInfoTimeout;

    public MessageAttachmentInfoCrudOperation(
            MessageAttachmentInfoDao messageAttachmentInfoDao,
            MessageAttachmentInfoCache messageAttachmentInfoCache,
            FtpHandler ftpHandler
    ) {
        this.messageAttachmentInfoDao = messageAttachmentInfoDao;
        this.messageAttachmentInfoCache = messageAttachmentInfoCache;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return messageAttachmentInfoCache.exists(key) || messageAttachmentInfoDao.exists(key);
    }

    @Override
    public MessageAttachmentInfo get(LongIdKey key) throws Exception {
        if (messageAttachmentInfoCache.exists(key)) {
            return messageAttachmentInfoCache.get(key);
        } else {
            if (!messageAttachmentInfoDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            MessageAttachmentInfo messageAttachmentInfo = messageAttachmentInfoDao.get(key);
            messageAttachmentInfoCache.push(messageAttachmentInfo, messageAttachmentInfoTimeout);
            return messageAttachmentInfo;
        }
    }

    @Override
    public LongIdKey insert(MessageAttachmentInfo messageAttachmentInfo) throws Exception {
        messageAttachmentInfoCache.push(messageAttachmentInfo, messageAttachmentInfoTimeout);
        return messageAttachmentInfoDao.insert(messageAttachmentInfo);
    }

    @Override
    public void update(MessageAttachmentInfo messageAttachmentInfo) throws Exception {
        messageAttachmentInfoCache.push(messageAttachmentInfo, messageAttachmentInfoTimeout);
        messageAttachmentInfoDao.update(messageAttachmentInfo);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 如果存在留言附件文件，则删除留言附件文件。
        if (ftpHandler.existsFile(FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(key))) {
            ftpHandler.deleteFile(FtpConstants.PATH_MESSAGE_ATTACHMENT, getFileName(key));
        }

        // 删除留言附件文件信息实体自身。
        messageAttachmentInfoCache.delete(key);
        messageAttachmentInfoDao.delete(key);
    }

    private String getFileName(LongIdKey messageAttachmentKey) {
        return Long.toString(messageAttachmentKey.getLongId());
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return messageAttachmentInfoCache.allExists(keys) || messageAttachmentInfoDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return messageAttachmentInfoCache.nonExists(keys) && messageAttachmentInfoDao.nonExists(keys);
    }

    @Override
    public List<MessageAttachmentInfo> batchGet(List<LongIdKey> keys) throws Exception {
        if (messageAttachmentInfoCache.allExists(keys)) {
            return messageAttachmentInfoCache.batchGet(keys);
        } else {
            if (!messageAttachmentInfoDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<MessageAttachmentInfo> messageAttachmentInfos = messageAttachmentInfoDao.batchGet(keys);
            messageAttachmentInfoCache.batchPush(messageAttachmentInfos, messageAttachmentInfoTimeout);
            return messageAttachmentInfos;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<MessageAttachmentInfo> messageAttachmentInfos) throws Exception {
        messageAttachmentInfoCache.batchPush(messageAttachmentInfos, messageAttachmentInfoTimeout);
        return messageAttachmentInfoDao.batchInsert(messageAttachmentInfos);
    }

    @Override
    public void batchUpdate(List<MessageAttachmentInfo> messageAttachmentInfos) throws Exception {
        messageAttachmentInfoCache.batchPush(messageAttachmentInfos, messageAttachmentInfoTimeout);
        messageAttachmentInfoDao.batchUpdate(messageAttachmentInfos);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
