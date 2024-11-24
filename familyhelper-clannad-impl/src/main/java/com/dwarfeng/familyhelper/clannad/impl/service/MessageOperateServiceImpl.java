package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class MessageOperateServiceImpl implements MessageOperateService {

    private final MessageOperateHandler messageOperateHandler;

    private final ServiceExceptionMapper sem;

    public MessageOperateServiceImpl(MessageOperateHandler messageOperateHandler, ServiceExceptionMapper sem) {
        this.messageOperateHandler = messageOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey create(MessageCreateInfo info, StringIdKey operateUserKey) throws ServiceException {
        try {
            return messageOperateHandler.create(info, operateUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建留言时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void update(MessageUpdateInfo info, StringIdKey operateUserKey) throws ServiceException {
        try {
            messageOperateHandler.update(info, operateUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新留言时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(MessageRemoveInfo info, StringIdKey operateUserKey) throws ServiceException {
        try {
            messageOperateHandler.remove(info, operateUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除留言时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void markSent(MessageMarkSentInfo info, StringIdKey operateUserKey) throws ServiceException {
        try {
            messageOperateHandler.markSent(info, operateUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("标记留言为已发送时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void markReceived(MessageMarkReceivedInfo info, StringIdKey operateUserKey) throws ServiceException {
        try {
            messageOperateHandler.markReceived(info, operateUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("标记留言为已接收时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void markReceiveUserHide(MessageMarkReceiveUserHideInfo info, StringIdKey operateUserKey)
            throws ServiceException {
        try {
            messageOperateHandler.markReceiveUserHide(info, operateUserKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("标记留言接收用户隐藏时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
