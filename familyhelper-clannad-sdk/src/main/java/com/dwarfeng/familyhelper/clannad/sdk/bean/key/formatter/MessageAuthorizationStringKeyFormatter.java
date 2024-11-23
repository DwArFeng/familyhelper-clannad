package com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * MessageAuthorizationKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public class MessageAuthorizationStringKeyFormatter implements StringKeyFormatter<MessageAuthorizationKey> {

    private String prefix;

    public MessageAuthorizationStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(MessageAuthorizationKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getReceiveUserId() + "_" + key.getAuthorizedSendUserId();
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
        return "MessageAuthorizationStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
