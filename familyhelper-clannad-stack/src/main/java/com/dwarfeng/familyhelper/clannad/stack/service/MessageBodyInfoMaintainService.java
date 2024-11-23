package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageBodyInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 留言正文信息维护服务。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageBodyInfoMaintainService extends BatchCrudService<LongIdKey, MessageBodyInfo>,
        EntireLookupService<MessageBodyInfo>, PresetLookupService<MessageBodyInfo> {
}
