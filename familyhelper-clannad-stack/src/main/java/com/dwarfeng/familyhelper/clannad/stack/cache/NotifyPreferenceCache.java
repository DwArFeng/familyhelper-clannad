package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 通知偏好缓存。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyPreferenceCache extends BatchBaseCache<NotifyPreferenceKey, NotifyPreference> {
}
