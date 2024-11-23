package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 留言维护服务。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageMaintainService extends BatchCrudService<LongIdKey, Message>,
        EntireLookupService<Message>, PresetLookupService<Message> {

    String CHILD_FOR_SEND_USER = "child_for_send_user";
    String CHILD_FOR_RECEIVE_USER = "child_for_receive_user";

    /**
     * 获取发送用户为指定值的展示用的留言。
     *
     * <p>
     * 参数列表：
     * <ol>
     *     <li>StringIdKey 发送用户的键。</li>
     * </ol>
     * 返回的数据按照创建日期降序排列。
     */
    String CHILD_FOR_SEND_USER_DISPLAY = "child_for_send_user_display";

    /**
     * 获取发送用户为指定值的展示用的留言。
     *
     * <p>
     * 参数列表：
     * <ol>
     *     <li>StringIdKey 发送用户的键。</li>
     *     <li>int 发送用户的展示状态。</li>
     * </ol>
     * 返回的数据按照创建日期降序排列。
     */
    String CHILD_FOR_SEND_USER_DISPLAY_STATUS_EQ = "child_for_send_user_display_created_date_desc";

    /**
     * 获取接收用户为指定值的展示用的留言。
     *
     * <p>
     * 参数列表：
     * <ol>
     *     <li>StringIdKey 接收用户的键。</li>
     * </ol>
     * 返回的数据满足以下条件：
     * <ul>
     *     <li>接收用户隐藏标记为 <code>false</code>。</li>
     *     <li>留言状态为 <code>[MESSAGE_STATUS_SENT, MESSAGE_STATUS_RECEIVED]</code> 之一。</li>
     * </ul>
     * 返回的数据按照创建日期降序排列。
     */
    String CHILD_FOR_RECEIVE_USER_DISPLAY = "child_for_receive_user_display";
}
