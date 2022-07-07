package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 证书权限数据访问层。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface PoceDao extends BatchBaseDao<PoceKey, Poce>, EntireLookupDao<Poce>, PresetLookupDao<Poce> {
}
