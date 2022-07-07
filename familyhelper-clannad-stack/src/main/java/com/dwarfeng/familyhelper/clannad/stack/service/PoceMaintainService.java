package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人简介维护服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface PoceMaintainService extends BatchCrudService<PoceKey, Poce>, EntireLookupService<Poce>,
        PresetLookupService<Poce> {

    String CHILD_FOR_CERTIFICATE = "child_for_certificate";
    String CHILD_FOR_USER = "child_for_user";
}
