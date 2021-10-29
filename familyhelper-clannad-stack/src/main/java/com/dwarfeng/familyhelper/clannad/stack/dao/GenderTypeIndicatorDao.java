package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;

/**
 * 性别类型指示器数据访问层。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface GenderTypeIndicatorDao extends BatchBaseDao<StringIdKey, GenderTypeIndicator>,
        EntireLookupDao<GenderTypeIndicator> {
}
