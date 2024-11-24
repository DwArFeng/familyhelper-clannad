package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationRemoveInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageAuthorizationUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 留言授权操作处理器。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAuthorizationOperateHandler extends Handler {

    /**
     * 创建留言授权。
     *
     * @param info 留言授权创建信息。
     * @return 创建的留言授权的主键。
     * @throws HandlerException 处理器异常。
     */
    MessageAuthorizationKey create(MessageAuthorizationCreateInfo info) throws HandlerException;

    /**
     * 更新留言授权。
     *
     * @param info 留言授权更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(MessageAuthorizationUpdateInfo info) throws HandlerException;

    /**
     * 删除留言授权。
     *
     * @param info 留言授权删除信息。
     * @throws HandlerException 处理器异常。
     */
    void remove(MessageAuthorizationRemoveInfo info) throws HandlerException;
}
