package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;

/**
 * 个人简介数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ProfileDao extends BatchBaseDao<StringIdKey, Profile>, EntireLookupDao<Profile> {
}
