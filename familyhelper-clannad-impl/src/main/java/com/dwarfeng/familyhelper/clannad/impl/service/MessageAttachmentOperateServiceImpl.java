package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageAttachmentOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageAttachmentOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class MessageAttachmentOperateServiceImpl implements MessageAttachmentOperateService {

    private final MessageAttachmentOperateHandler messageAttachmentOperateHandler;

    private final ServiceExceptionMapper sem;

    public MessageAttachmentOperateServiceImpl(
            MessageAttachmentOperateHandler messageAttachmentOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.messageAttachmentOperateHandler = messageAttachmentOperateHandler;
        this.sem = sem;
    }

    @Override
    public MessageAttachment download(StringIdKey userKey, LongIdKey messageAttachmentKey)
            throws ServiceException {
        try {
            return messageAttachmentOperateHandler.download(userKey, messageAttachmentKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载留言附件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public MessageAttachmentStream downloadStream(StringIdKey userKey, LongIdKey messageAttachmentKey)
            throws ServiceException {
        try {
            return messageAttachmentOperateHandler.downloadStream(userKey, messageAttachmentKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载留言附件流时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void upload(StringIdKey userKey, MessageAttachmentUploadInfo messageAttachmentUploadInfo)
            throws ServiceException {
        try {
            messageAttachmentOperateHandler.upload(userKey, messageAttachmentUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("上传留言附件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void uploadStream(StringIdKey userKey, MessageAttachmentStreamUploadInfo uploadInfo)
            throws ServiceException {
        try {
            messageAttachmentOperateHandler.uploadStream(userKey, uploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("上传留言附件流时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void update(StringIdKey userKey, MessageAttachmentUpdateInfo messageAttachmentUpdateInfo)
            throws ServiceException {
        try {
            messageAttachmentOperateHandler.update(userKey, messageAttachmentUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新留言附件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void updateStream(StringIdKey userKey, MessageAttachmentStreamUpdateInfo updateInfo)
            throws ServiceException {
        try {
            messageAttachmentOperateHandler.updateStream(userKey, updateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新留言附件流时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(StringIdKey userKey, LongIdKey messageAttachmentKey) throws ServiceException {
        try {
            messageAttachmentOperateHandler.remove(userKey, messageAttachmentKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除留言附件时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
