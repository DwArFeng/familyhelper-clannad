package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 通知设置缓存。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifySettingCache extends BatchBaseCache<LongIdKey, NotifySetting> {
}
