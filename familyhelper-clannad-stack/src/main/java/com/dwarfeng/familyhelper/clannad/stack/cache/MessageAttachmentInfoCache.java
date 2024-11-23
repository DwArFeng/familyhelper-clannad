package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 留言附件信息缓存。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAttachmentInfoCache extends BatchBaseCache<LongIdKey, MessageAttachmentInfo> {
}
