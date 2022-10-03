package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.NotifyTopic;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;

/**
 * 路由器信息维护服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyTopicMaintainService extends BatchCrudService<StringIdKey, NotifyTopic>,
        EntireLookupService<NotifyTopic> {
}
