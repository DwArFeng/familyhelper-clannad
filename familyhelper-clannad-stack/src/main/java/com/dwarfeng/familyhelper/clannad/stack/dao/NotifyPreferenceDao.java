package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyPreferenceKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 通知偏好数据访问层。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyPreferenceDao extends BatchBaseDao<NotifyPreferenceKey, NotifyPreference>,
        EntireLookupDao<NotifyPreference>, PresetLookupDao<NotifyPreference> {
}
