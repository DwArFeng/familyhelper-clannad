package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo.TopicDetail;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.NotifyPreferenceOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.NotifyPreferenceMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
            List<StringIdKey> topicKeys = notifyPreferenceUpdateInfo.getTopicDetails().stream()
                    .map(TopicDetail::getTopicKey).collect(Collectors.toList());
            for (StringIdKey topicKey : topicKeys) {
                operateHandlerValidator.makeSureNotifyTopicExists(topicKey);
            }

            // 将 NotifyPreferenceUpdateInfo 转化为 NotifyPreference 实体。
            List<NotifyPreference> notifyPreferences = notifyPreferenceUpdateInfo.getTopicDetails().stream().map(
                    detail -> new NotifyPreference(
                            new NotifyPreferenceKey(
                                    notifySettingKey.getLongId(),
                                    detail.getTopicKey().getStringId(),
                                    userKey.getStringId()
                            ),
                            detail.isPreferred(),
                            "通过 familyhelper-clannad 服务插入/更新通知偏好"
                    )).collect(Collectors.toList());

            // 调用维护服务批量插入或更新。
            notifyPreferenceMaintainService.batchInsertOrUpdate(notifyPreferences);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
