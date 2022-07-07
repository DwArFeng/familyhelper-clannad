package com.dwarfeng.familyhelper.clannad.stack.cache;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 证书文件信息缓存。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface CertificateFileInfoCache extends BatchBaseCache<LongIdKey, CertificateFileInfo> {
}
