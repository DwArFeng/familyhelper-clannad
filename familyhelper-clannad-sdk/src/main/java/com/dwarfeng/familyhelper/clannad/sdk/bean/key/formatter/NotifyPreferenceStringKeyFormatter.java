package com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * NotifyPreferenceKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyPreferenceStringKeyFormatter implements StringKeyFormatter<NotifyPreferenceKey> {

    private String prefix;

    public NotifyPreferenceStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(NotifyPreferenceKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getNotifySettingId() + "_" + key.getNotifyTopicId() + "_" + key.getUserId();
    }

    @Override
    public String generalFormat() {
        return prefix + Constants.REDIS_KEY_WILDCARD_CHARACTER;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "NotifyPreferenceStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
