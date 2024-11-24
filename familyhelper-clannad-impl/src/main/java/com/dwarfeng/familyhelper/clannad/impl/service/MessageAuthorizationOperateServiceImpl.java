package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationRemoveInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageAuthorizationOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageAuthorizationOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class MessageAuthorizationOperateServiceImpl implements MessageAuthorizationOperateService {

    private final MessageAuthorizationOperateHandler messageAuthorizationOperateHandler;

    private final ServiceExceptionMapper sem;

    public MessageAuthorizationOperateServiceImpl(
            MessageAuthorizationOperateHandler messageAuthorizationOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.messageAuthorizationOperateHandler = messageAuthorizationOperateHandler;
        this.sem = sem;
    }

    @Override
    public MessageAuthorizationKey create(MessageAuthorizationCreateInfo info) throws ServiceException {
        try {
            return messageAuthorizationOperateHandler.create(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建留言授权时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void update(MessageAuthorizationUpdateInfo info) throws ServiceException {
        try {
            messageAuthorizationOperateHandler.update(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新留言授权时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(MessageAuthorizationRemoveInfo info) throws ServiceException {
        try {
            messageAuthorizationOperateHandler.remove(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除留言授权时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
