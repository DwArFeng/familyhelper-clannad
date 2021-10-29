package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;

/**
 * 性别类型指示器维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface GenderTypeIndicatorMaintainService extends BatchCrudService<StringIdKey, GenderTypeIndicator>,
        EntireLookupService<GenderTypeIndicator> {
}
