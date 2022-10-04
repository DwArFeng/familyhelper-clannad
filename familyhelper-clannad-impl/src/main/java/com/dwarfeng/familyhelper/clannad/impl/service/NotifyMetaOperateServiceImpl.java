package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotifyMetaOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyMetaOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class NotifyMetaOperateServiceImpl implements NotifyMetaOperateService {

    private final NotifyMetaOperateHandler notifyMetaOperateHandler;

    private final ServiceExceptionMapper sem;

    public NotifyMetaOperateServiceImpl(
            NotifyMetaOperateHandler notifyMetaOperateHandler, ServiceExceptionMapper sem
    ) {
        this.notifyMetaOperateHandler = notifyMetaOperateHandler;
        this.sem = sem;
    }

    @Override
    public void updateLastReceivedDate(NotifyNodeKey notifyNodeKey) throws ServiceException {
        try {
            notifyMetaOperateHandler.updateLastReceivedDate(notifyNodeKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logAndThrow("更新元数据的最后接收日期时发生异常", LogLevel.WARN, sem, e);
        }
    }
}
