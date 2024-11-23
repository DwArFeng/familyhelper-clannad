package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 留言正文信息数据访问层。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageBodyInfoDao extends BatchBaseDao<LongIdKey, MessageBodyInfo>,
        EntireLookupDao<MessageBodyInfo>, PresetLookupDao<MessageBodyInfo> {
}
