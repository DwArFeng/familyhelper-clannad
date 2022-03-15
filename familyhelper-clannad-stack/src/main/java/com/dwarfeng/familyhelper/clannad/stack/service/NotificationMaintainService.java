package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Notification;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 通知维护服务。
 *
 * @author DwArFeng
 * @since 1.2.2
 */
public interface NotificationMaintainService extends BatchCrudService<LongIdKey, Notification>,
        EntireLookupService<Notification>, PresetLookupService<Notification> {

    String CHILD_FOR_USER = "child_for_user";
    String CHILD_FOR_USER_UNREAD = "child_for_user_unread";
}
