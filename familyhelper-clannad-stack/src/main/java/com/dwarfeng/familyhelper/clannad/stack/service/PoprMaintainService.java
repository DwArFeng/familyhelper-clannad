package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Popr;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人简介维护服务。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface PoprMaintainService extends BatchCrudService<PoprKey, Popr>, EntireLookupService<Popr>,
        PresetLookupService<Popr> {

    String CHILD_FOR_PROFILE = "child_for_profile";
    String CHILD_FOR_USER = "child_for_user";
}
