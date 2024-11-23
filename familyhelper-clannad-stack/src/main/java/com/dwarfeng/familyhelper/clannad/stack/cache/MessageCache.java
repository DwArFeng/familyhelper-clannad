package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 留言缓存。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageCache extends BatchBaseCache<LongIdKey, Message> {
}
