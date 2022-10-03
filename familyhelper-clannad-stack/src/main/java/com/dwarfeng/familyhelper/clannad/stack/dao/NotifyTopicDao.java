package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;

/**
 * 通知主题数据访问层。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyTopicDao extends BatchBaseDao<StringIdKey, NotifyTopic>, EntireLookupDao<NotifyTopic> {
}
