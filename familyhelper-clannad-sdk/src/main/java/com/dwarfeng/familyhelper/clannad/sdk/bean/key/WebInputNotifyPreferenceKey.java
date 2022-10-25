package com.dwarfeng.familyhelper.clannad.sdk.bean.key;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.subgrade.stack.bean.key.Key;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * WebInput 通知偏好主键。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputNotifyPreferenceKey implements Key {

    private static final long serialVersionUID = -8539393862474898511L;

    public static NotifyPreferenceKey toStackBean(WebInputNotifyPreferenceKey webInputNotifyPreferenceKey) {
        if (Objects.isNull(webInputNotifyPreferenceKey)) {
            return null;
        } else {
            return new NotifyPreferenceKey(
                    webInputNotifyPreferenceKey.getNotifySettingId(), webInputNotifyPreferenceKey.getNotifyTopicId(),
                    webInputNotifyPreferenceKey.getUserId()
            );
        }
    }

    @JSONField(name = "notify_setting_id")
    @NotNull
    private Long notifySettingId;

    @JSONField(name = "notify_topic_id")
    @NotEmpty
    @NotNull
    @Length(max = Constraints.LENGTH_ID)
    private String notifyTopicId;

    @JSONField(name = "userId")
    @NotEmpty
    @NotNull
    @Length(max = Constraints.LENGTH_USER)
    private String userId;

    public WebInputNotifyPreferenceKey() {
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
        return "WebInputNotifyPreferenceKey{" +
                "notifySettingId=" + notifySettingId +
                ", notifyTopicId='" + notifyTopicId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
