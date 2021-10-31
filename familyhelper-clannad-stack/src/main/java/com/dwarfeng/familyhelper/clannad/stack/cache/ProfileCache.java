package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 个人简介缓存。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface ProfileCache extends BatchBaseCache<StringIdKey, Profile> {
}
