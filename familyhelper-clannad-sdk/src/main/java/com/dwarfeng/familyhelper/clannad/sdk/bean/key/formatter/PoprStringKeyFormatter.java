package com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * PoprKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class PoprStringKeyFormatter implements StringKeyFormatter<PoprKey> {

    private String prefix;

    public PoprStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(PoprKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getProfileId() + "_" + key.getUserId();
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
        return "PoprStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
