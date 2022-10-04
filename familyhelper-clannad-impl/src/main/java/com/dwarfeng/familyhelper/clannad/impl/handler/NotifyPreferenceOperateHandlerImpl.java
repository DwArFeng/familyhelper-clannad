package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotifyPreferenceOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyPreferenceMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

@Component
public class NotifyPreferenceOperateHandlerImpl implements NotifyPreferenceOperateHandler {

    private final NotifyPreferenceMaintainService notifyPreferenceMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public NotifyPreferenceOperateHandlerImpl(
            NotifyPreferenceMaintainService notifyPreferenceMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.notifyPreferenceMaintainService = notifyPreferenceMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public void updateNotifyPreference(NotifyPreferenceUpdateInfo notifyPreferenceUpdateInfo) throws HandlerException {
        try {
            // 确认用户存在。
            StringIdKey userKey = notifyPreferenceUpdateInfo.getUserKey();
            operateHandlerValidator.makeSureUserExists(userKey);

            // 确认通知设置存在。
            LongIdKey notifySettingKey = notifyPreferenceUpdateInfo.getNotifySettingKey();
            operateHandlerValidator.makeSureNotifySettingExists(notifySettingKey);

            // 确认通知主题存在。
            StringIdKey notifyTopicKey = notifyPreferenceUpdateInfo.getNotifyTopicKey();
            operateHandlerValidator.makeSureNotifyTopicExists(notifyTopicKey);

            // 将 NotifyPreferenceUpdateInfo 转化为 NotifyPreference 实体。
            NotifyPreference notifyPreference = new NotifyPreference(
                    new NotifyNodeKey(
                            notifySettingKey.getLongId(), notifyTopicKey.getStringId(), userKey.getStringId()
                    ),
                    notifyPreferenceUpdateInfo.isPreferred(),
                    notifyPreferenceUpdateInfo.getCoolDown(),
                    "通过 familyhelper-clannad 服务插入/更新通知偏好"
            );

            // 调用维护服务插入或更新。
            notifyPreferenceMaintainService.insertOrUpdate(notifyPreference);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
