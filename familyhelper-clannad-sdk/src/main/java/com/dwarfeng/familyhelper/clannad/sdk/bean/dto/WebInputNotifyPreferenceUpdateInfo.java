package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.NotifyPreferenceUpdateInfo.TopicDetail;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * WebInput 通知偏好更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputNotifyPreferenceUpdateInfo implements Dto {

    private static final long serialVersionUID = 4069017179740348479L;

    public static NotifyPreferenceUpdateInfo toStackBean(WebInputNotifyPreferenceUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new NotifyPreferenceUpdateInfo(
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    WebInputLongIdKey.toStackBean(webInput.getNotifySettingKey()),
                    webInput.getTopicDetails().stream().map(WebInputTopicDetail::toStackBean)
                            .collect(Collectors.toList())
            );
        }
    }

    @JSONField(name = "user_key")
    @NotNull
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "notify_setting_key")
    @NotNull
    @Valid
    private WebInputLongIdKey notifySettingKey;

    @JSONField(name = "topic_details")
    @NotNull
    @Valid
    private List<WebInputTopicDetail> webInputTopicDetails;

    public WebInputNotifyPreferenceUpdateInfo() {
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public WebInputLongIdKey getNotifySettingKey() {
        return notifySettingKey;
    }

    public void setNotifySettingKey(WebInputLongIdKey notifySettingKey) {
        this.notifySettingKey = notifySettingKey;
    }

    public List<WebInputTopicDetail> getTopicDetails() {
        return webInputTopicDetails;
    }

    public void setTopicDetails(List<WebInputTopicDetail> webInputTopicDetails) {
        this.webInputTopicDetails = webInputTopicDetails;
    }

    @Override
    public String toString() {
        return "WebInputNotifyPreferenceUpdateInfo{" +
                "userKey=" + userKey +
                ", notifySettingKey=" + notifySettingKey +
                ", webInputTopicDetails=" + webInputTopicDetails +
                '}';
    }

    public static class WebInputTopicDetail implements Dto {

        private static final long serialVersionUID = 759075791284596917L;

        public static TopicDetail toStackBean(WebInputTopicDetail webInputTopicDetail) {
            if (Objects.isNull(webInputTopicDetail)) {
                return null;
            } else {
                return new TopicDetail(
                        WebInputStringIdKey.toStackBean(webInputTopicDetail.getTopicKey()),
                        webInputTopicDetail.isPreferred()
                );
            }
        }

        @JSONField(name = "topic_key")
        @NotNull
        @Valid
        private WebInputStringIdKey topicKey;

        @JSONField(name = "preferred")
        private boolean preferred;

        public WebInputTopicDetail() {
        }

        public WebInputStringIdKey getTopicKey() {
            return topicKey;
        }

        public void setTopicKey(WebInputStringIdKey topicKey) {
            this.topicKey = topicKey;
        }

        public boolean isPreferred() {
            return preferred;
        }

        public void setPreferred(boolean preferred) {
            this.preferred = preferred;
        }

        @Override
        public String toString() {
            return "WebInputTopicDetail{" +
                    "topicKey=" + topicKey +
                    ", preferred=" + preferred +
                    '}';
        }
    }
}
