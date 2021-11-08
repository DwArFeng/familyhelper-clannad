package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.AvatarInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;

/**
 * 头像信息维护服务。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public interface AvatarInfoMaintainService extends BatchCrudService<StringIdKey, AvatarInfo> {
}
