package com.dwarfeng.familyhelper.clannad.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

import java.util.List;

/**
 * 通知偏好更新信息。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyPreferenceUpdateInfo implements Dto {

    private static final long serialVersionUID = 4128544607594169585L;

    private StringIdKey userKey;
    private LongIdKey notifySettingKey;
    private List<TopicDetail> topicDetails;

    public NotifyPreferenceUpdateInfo() {
    }

    public NotifyPreferenceUpdateInfo(
            StringIdKey userKey, LongIdKey notifySettingKey, List<TopicDetail> topicDetails
    ) {
        this.userKey = userKey;
        this.notifySettingKey = notifySettingKey;
        this.topicDetails = topicDetails;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public LongIdKey getNotifySettingKey() {
        return notifySettingKey;
    }

    public void setNotifySettingKey(LongIdKey notifySettingKey) {
        this.notifySettingKey = notifySettingKey;
    }

    public List<TopicDetail> getTopicDetails() {
        return topicDetails;
    }

    public void setTopicDetails(List<TopicDetail> topicDetails) {
        this.topicDetails = topicDetails;
    }

    @Override
    public String toString() {
        return "NotifyPreferenceUpdateInfo{" +
                "userKey=" + userKey +
                ", notifySettingKey=" + notifySettingKey +
                ", topicDetails=" + topicDetails +
                '}';
    }

    public static class TopicDetail implements Dto {

        private static final long serialVersionUID = 4020909933546703253L;

        private StringIdKey topicKey;
        private boolean preferred;

        public TopicDetail() {
        }

        public TopicDetail(StringIdKey topicKey, boolean preferred) {
            this.topicKey = topicKey;
            this.preferred = preferred;
        }

        public StringIdKey getTopicKey() {
            return topicKey;
        }

        public void setTopicKey(StringIdKey topicKey) {
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
            return "TopicDetail{" +
                    "topicKey=" + topicKey +
                    ", preferred=" + preferred +
                    '}';
        }
    }
}
