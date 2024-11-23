package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 留言授权维护服务。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAuthorizationMaintainService extends BatchCrudService<MessageAuthorizationKey, MessageAuthorization>,
        EntireLookupService<MessageAuthorization>, PresetLookupService<MessageAuthorization> {

    String CHILD_FOR_RECEIVE_USER = "child_for_receive_user";
    String CHILD_FOR_AUTHORIZED_SEND_USER = "child_for_authorized_send_user";
    String CHILD_FOR_AUTHORIZED_SEND_USER_ID_LIKE = "child_for_authorized_send_user_id_like";
}
