package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAttachmentInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 留言附件信息维护服务。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAttachmentInfoMaintainService extends BatchCrudService<LongIdKey, MessageAttachmentInfo>,
        EntireLookupService<MessageAttachmentInfo>, PresetLookupService<MessageAttachmentInfo> {

    String CHILD_FOR_MESSAGE = "child_for_message";
    String CHILD_FOR_MESSAGE_ORIGIN_NAME_ASC = "child_for_message_origin_name_asc";
    String CHILD_FOR_MESSAGE_UPLOAD_DATE_DESC = "child_for_message_upload_date_desc";
}
