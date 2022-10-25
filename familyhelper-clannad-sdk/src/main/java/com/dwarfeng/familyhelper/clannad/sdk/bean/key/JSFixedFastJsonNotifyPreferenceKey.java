package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;

import java.util.Objects;

/**
 * JSFixed FastJson 通知偏好主键。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class JSFixedFastJsonNotifyPreferenceKey implements Key {

    private static final long serialVersionUID = -6960126495416099784L;

    public static JSFixedFastJsonNotifyPreferenceKey of(NotifyPreferenceKey notifyPreferenceKey) {
        if (Objects.isNull(notifyPreferenceKey)) {
            return null;
        } else {
            return new JSFixedFastJsonNotifyPreferenceKey(
                    notifyPreferenceKey.getNotifySettingId(), notifyPreferenceKey.getNotifyTopicId(),
                    notifyPreferenceKey.getUserId()
            );
        }
    }

    @JSONField(name = "notify_setting_id", ordinal = 1, serializeUsing = ToStringSerializer.class)
    private Long notifySettingId;

    @JSONField(name = "notify_topic_id", ordinal = 2)
    private String notifyTopicId;

    @JSONField(name = "userId", ordinal = 3)
    private String userId;

    public JSFixedFastJsonNotifyPreferenceKey() {
    }

    public JSFixedFastJsonNotifyPreferenceKey(Long notifySettingId, String notifyTopicId, String userId) {
        this.notifySettingId = notifySettingId;
        this.notifyTopicId = notifyTopicId;
        this.userId = userId;
    }

    public Long getNotifySettingId() {
        return notifySettingId;
    }

    public void setNotifySettingId(Long notifySettingId) {
        this.notifySettingId = notifySettingId;
    }

    public String getNotifyTopicId() {
        return notifyTopicId;
    }

    public void setNotifyTopicId(String notifyTopicId) {
        this.notifyTopicId = notifyTopicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "JSFixedFastJsonNotifyPreferenceKey{" +
                "notifySettingId=" + notifySettingId +
                ", notifyTopicId='" + notifyTopicId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
