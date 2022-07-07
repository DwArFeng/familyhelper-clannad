package com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.subgrade.sdk.common.Constants;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringKeyFormatter;

import java.util.Objects;

/**
 * PoceKey 的文本格式化转换器。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class PoceStringKeyFormatter implements StringKeyFormatter<PoceKey> {

    private String prefix;

    public PoceStringKeyFormatter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String format(PoceKey key) {
        Objects.requireNonNull(key);
        return prefix + key.getCertificateId() + "_" + key.getUserId();
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
        return "PoceStringKeyFormatter{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
