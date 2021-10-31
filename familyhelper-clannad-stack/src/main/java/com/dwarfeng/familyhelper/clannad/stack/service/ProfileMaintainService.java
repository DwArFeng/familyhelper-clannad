package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;

/**
 * 个人简介维护服务。
 *
 * @author DwArFeng
 * @since 1.1.0
 */
public interface ProfileMaintainService extends BatchCrudService<StringIdKey, Profile> {
}
