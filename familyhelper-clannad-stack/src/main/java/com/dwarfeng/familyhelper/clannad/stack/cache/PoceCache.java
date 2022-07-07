package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 证书权限缓存。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface PoceCache extends BatchBaseCache<PoceKey, Poce> {
}
