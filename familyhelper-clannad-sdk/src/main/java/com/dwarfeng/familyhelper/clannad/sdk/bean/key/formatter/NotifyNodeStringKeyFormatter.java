package com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * NotifyNodeKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class NotifyNodeStringKeyFormatter implements StringKeyFormatter<NotifyNodeKey> {

    private String prefix;

    public NotifyNodeStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(NotifyNodeKey key) {
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
        return "NotifyNodeStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}