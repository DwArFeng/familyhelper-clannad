package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyPreference;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 通知偏好维护服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyPreferenceMaintainService extends BatchCrudService<NotifyNodeKey, NotifyPreference>,
        EntireLookupService<NotifyPreference>, PresetLookupService<NotifyPreference> {

    String CHILD_FOR_NOTIFY_SETTING = "child_for_notify_setting";
    String CHILD_FOR_NOTIFY_TOPIC = "child_for_notify_topic";
    String CHILD_FOR_USER = "child_for_user";
    String CHILD_FOR_NOTIFY_SETTING_USER = "child_for_notify_setting_user";
}
