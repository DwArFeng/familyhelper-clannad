package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 通知缓存。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public interface NotificationCache extends BatchBaseCache<LongIdKey, Notification> {
}
