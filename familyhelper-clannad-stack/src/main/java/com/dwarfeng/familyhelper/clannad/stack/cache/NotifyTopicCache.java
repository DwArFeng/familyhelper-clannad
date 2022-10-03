package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 通知主题缓存。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyTopicCache extends BatchBaseCache<StringIdKey, NotifyTopic> {
}
