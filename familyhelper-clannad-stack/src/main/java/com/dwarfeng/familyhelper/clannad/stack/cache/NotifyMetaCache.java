package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 通知元数据缓存。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyMetaCache extends BatchBaseCache<NotifyNodeKey, NotifyMeta> {
}
