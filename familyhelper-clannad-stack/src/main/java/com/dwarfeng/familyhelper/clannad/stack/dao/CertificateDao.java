package com.dwarfeng.familyhelper.clannad.stack.dao;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 证书数据访问层。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface CertificateDao extends BatchBaseDao<LongIdKey, Certificate>, EntireLookupDao<Certificate>,
        PresetLookupDao<Certificate> {
}
