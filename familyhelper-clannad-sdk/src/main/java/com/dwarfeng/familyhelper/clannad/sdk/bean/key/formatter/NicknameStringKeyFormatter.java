package com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * NicknameKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class NicknameStringKeyFormatter implements StringKeyFormatter<NicknameKey> {

    private String prefix;

    public NicknameStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(NicknameKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getSubjectUserId() + "_" + key.getObjectUserId();
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
        return "NicknameStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
