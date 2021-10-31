package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 个人简介权限数据访问层。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface PoprDao extends BatchBaseDao<PoprKey, Popr>, EntireLookupDao<Popr>, PresetLookupDao<Popr> {
}
