package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 留言操作处理器。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageOperateHandler extends Handler {

    /**
     * 创建留言。
     *
     * @param info           留言信息。
     * @param operateUserKey 操作用户的键。
     * @return 创建的留言的键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey create(MessageCreateInfo info, StringIdKey operateUserKey) throws HandlerException;

    /**
     * 更新留言。
     *
     * @param info           留言更新信息。
     * @param operateUserKey 操作用户的键。
     * @throws HandlerException 处理器异常。
     */
    void update(MessageUpdateInfo info, StringIdKey operateUserKey) throws HandlerException;

    /**
     * 删除留言。
     *
     * @param info           删除信息。
     * @param operateUserKey 操作用户的键。
     * @throws HandlerException 处理器异常。
     */
    void remove(MessageRemoveInfo info, StringIdKey operateUserKey) throws HandlerException;

    /**
     * 标记留言为已发送。
     *
     * @param info           标记为已发送信息。
     * @param operateUserKey 操作用户的键。
     * @throws HandlerException 处理器异常。
     */
    void markSent(MessageMarkSentInfo info, StringIdKey operateUserKey) throws HandlerException;

    /**
     * 标记留言为已接收。
     *
     * @param info           标记为已接收信息。
     * @param operateUserKey 操作用户的键。
     * @throws HandlerException 处理器异常。
     */
    void markReceived(MessageMarkReceivedInfo info, StringIdKey operateUserKey) throws HandlerException;

    /**
     * 标记留言接收用户隐藏。
     *
     * @param info           标记接收用户隐藏信息。
     * @param operateUserKey 操作用户的键。
     * @throws HandlerException 处理器异常。
     */
    void markReceiveUserHide(MessageMarkReceiveUserHideInfo info, StringIdKey operateUserKey) throws HandlerException;
}
