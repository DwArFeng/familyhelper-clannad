package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 个人简介类型指示器数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ProfileTypeIndicatorDao extends BatchBaseDao<ProfileTypeIndicatorKey, ProfileTypeIndicator>,
        PresetLookupDao<ProfileTypeIndicator> {
}
