package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 证书缓存。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface CertificateCache extends BatchBaseCache<LongIdKey, Certificate> {
}
