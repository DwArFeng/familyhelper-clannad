package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 个人简介权限缓存。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface PoprCache extends BatchBaseCache<PoprKey, Popr> {
}
