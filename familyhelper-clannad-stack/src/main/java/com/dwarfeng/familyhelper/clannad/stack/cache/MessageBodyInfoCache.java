package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 留言正文信息缓存。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageBodyInfoCache extends BatchBaseCache<LongIdKey, MessageBodyInfo> {
}
