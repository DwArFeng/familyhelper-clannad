package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;

/**
 * 通知设置数据访问层。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifySettingDao extends BatchBaseDao<LongIdKey, NotifySetting>, EntireLookupDao<NotifySetting> {
}
