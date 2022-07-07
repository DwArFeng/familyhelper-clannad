package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 证书维护服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface CertificateMaintainService extends BatchCrudService<LongIdKey, Certificate>,
        EntireLookupService<Certificate>, PresetLookupService<Certificate> {

    String NAME_LIKE = "name_like";
}
