package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 头像信息缓存。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public interface AvatarInfoCache extends BatchBaseCache<StringIdKey, AvatarInfo> {
}
