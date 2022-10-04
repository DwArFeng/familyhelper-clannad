package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NotifyNodeKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 通知元数据操作处理器。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface NotifyMetaOperateHandler extends Handler {

    /**
     * 更新元数据的最后接收日期。
     *
     * @param notifyNodeKey 通知节点主键。
     * @throws HandlerException 处理器异常。
     */
    void updateLastReceivedDate(NotifyNodeKey notifyNodeKey) throws HandlerException;
}
