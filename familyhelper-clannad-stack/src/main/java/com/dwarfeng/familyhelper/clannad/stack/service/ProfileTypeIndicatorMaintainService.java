package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人简介类型指示器维护服务。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface ProfileTypeIndicatorMaintainService extends
        BatchCrudService<ProfileTypeIndicatorKey, ProfileTypeIndicator>, PresetLookupService<ProfileTypeIndicator> {

    String CHILD_FOR_CATEGORY = "child_for_category";
}
