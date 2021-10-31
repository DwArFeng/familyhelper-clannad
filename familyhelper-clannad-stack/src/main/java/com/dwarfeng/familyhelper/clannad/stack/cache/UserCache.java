package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 用户缓存。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface UserCache extends BatchBaseCache<StringIdKey, User> {
}
