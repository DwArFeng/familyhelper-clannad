package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBody;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBodyUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 留言正文操作处理器。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageBodyOperateHandler extends Handler {

    /**
     * 下载留言正文。
     *
     * @param userKey    执行用户主键。
     * @param messageBodyKey 留言正文主键。
     * @return 留言正文。
     * @throws HandlerException 处理器异常。
     */
    MessageBody download(StringIdKey userKey, LongIdKey messageBodyKey) throws HandlerException;

    /**
     * 更新留言正文。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 留言正文更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(StringIdKey userKey, MessageBodyUpdateInfo updateInfo) throws HandlerException;
}
