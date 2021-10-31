package com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * ProfileTypeIndicatorKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class ProfileTypeIndicatorStringKeyFormatter implements StringKeyFormatter<ProfileTypeIndicatorKey> {

    private String prefix;

    public ProfileTypeIndicatorStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(ProfileTypeIndicatorKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getCategoryId() + "_" + key.getStringId();
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
        return "ProfileTypeIndicatorStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
