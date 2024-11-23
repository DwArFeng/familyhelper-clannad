package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 留言授权缓存。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAuthorizationCache extends BatchBaseCache<MessageAuthorizationKey, MessageAuthorization> {
}
