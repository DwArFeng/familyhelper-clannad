package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;

/**
 * 用户维护服务。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public interface UserMaintainService extends BatchCrudService<StringIdKey, User> {

}
