package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBody;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBodyUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.MessageBodyOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.MessageBodyOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class MessageBodyOperateServiceImpl implements MessageBodyOperateService {

    private final MessageBodyOperateHandler messageBodyOperateHandler;

    private final ServiceExceptionMapper sem;

    public MessageBodyOperateServiceImpl(
            MessageBodyOperateHandler messageBodyOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.messageBodyOperateHandler = messageBodyOperateHandler;
        this.sem = sem;
    }

    @Override
    public MessageBody download(StringIdKey userKey, LongIdKey messageBodyKey)
            throws ServiceException {
        try {
            return messageBodyOperateHandler.download(userKey, messageBodyKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载留言正文时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void update(StringIdKey userKey, MessageBodyUpdateInfo messageBodyUpdateInfo)
            throws ServiceException {
        try {
            messageBodyOperateHandler.update(userKey, messageBodyUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新留言正文时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
