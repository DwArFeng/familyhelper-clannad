package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifySetting;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;

/**
 * 路由器信息维护服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifySettingMaintainService extends BatchCrudService<LongIdKey, NotifySetting>,
        EntireLookupService<NotifySetting> {
}
