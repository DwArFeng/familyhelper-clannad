package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 通知元数据数据访问层。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyMetaDao extends BatchBaseDao<NotifyNodeKey, NotifyMeta>,
        EntireLookupDao<NotifyMeta>, PresetLookupDao<NotifyMeta> {
}
