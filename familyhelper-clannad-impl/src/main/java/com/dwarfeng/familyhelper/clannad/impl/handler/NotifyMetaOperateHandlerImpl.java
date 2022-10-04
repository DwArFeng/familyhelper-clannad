package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotifyMetaOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyMetaMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NotifyMetaOperateHandlerImpl implements NotifyMetaOperateHandler {

    private final NotifyMetaMaintainService notifyMetaMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public NotifyMetaOperateHandlerImpl(
            NotifyMetaMaintainService notifyMetaMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.notifyMetaMaintainService = notifyMetaMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public void updateLastReceivedDate(NotifyNodeKey notifyNodeKey) throws HandlerException {
        try {
            // 确认用户存在。
            StringIdKey userKey = new StringIdKey(notifyNodeKey.getUserId());
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认通知设置存在。
            LongIdKey notifySettingKey = new LongIdKey(notifyNodeKey.getNotifySettingId());
            operateHandlerValidator.makeSureNotifySettingExists(notifySettingKey);

            // 确认通知主题存在。
            StringIdKey notifyTopicKey = new StringIdKey(notifyNodeKey.getNotifyTopicId());
            operateHandlerValidator.makeSureNotifyTopicExists(notifyTopicKey);

            // 构造 NotifyMeta 实体。
            NotifyMeta notifyMeta = new NotifyMeta(
                    new NotifyNodeKey(
                            notifySettingKey.getLongId(), notifyTopicKey.getStringId(), userKey.getStringId()
                    ),
                    new Date(),
                    "通过 familyhelper-clannad 服务插入/更新通知元数据"
            );

            // 调用维护服务插入或更新。
            notifyMetaMaintainService.insertOrUpdate(notifyMeta);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
