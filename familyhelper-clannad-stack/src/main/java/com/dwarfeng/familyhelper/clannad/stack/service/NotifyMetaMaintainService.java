package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyMeta;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 通知元数据维护服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyMetaMaintainService extends BatchCrudService<NotifyNodeKey, NotifyMeta>,
        EntireLookupService<NotifyMeta>, PresetLookupService<NotifyMeta> {

    String CHILD_FOR_NOTIFY_SETTING = "child_for_notify_setting";
    String CHILD_FOR_NOTIFY_TOPIC = "child_for_notify_topic";
    String CHILD_FOR_USER = "child_for_user";
}
