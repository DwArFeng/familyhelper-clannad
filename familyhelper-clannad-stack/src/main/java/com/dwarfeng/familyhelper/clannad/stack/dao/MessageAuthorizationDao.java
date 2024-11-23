package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 留言授权数据访问层。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAuthorizationDao extends BatchBaseDao<MessageAuthorizationKey, MessageAuthorization>,
        EntireLookupDao<MessageAuthorization>, PresetLookupDao<MessageAuthorization> {
}
