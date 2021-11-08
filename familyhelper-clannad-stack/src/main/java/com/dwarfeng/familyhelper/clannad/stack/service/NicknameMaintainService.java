package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Nickname;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 昵称维护服务。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public interface NicknameMaintainService extends BatchCrudService<NicknameKey, Nickname>,
        PresetLookupService<Nickname> {

    String CHILD_FOR_SUBJECT_USER = "child_for_subject_user";
    String CHILD_FOR_OBJECT_USER = "child_for_object_user";
}
