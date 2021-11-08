package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 昵称缓存。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public interface NicknameCache extends BatchBaseCache<NicknameKey, Nickname> {
}
