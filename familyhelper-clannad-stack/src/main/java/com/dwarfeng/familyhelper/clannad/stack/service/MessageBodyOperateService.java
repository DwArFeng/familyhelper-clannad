package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBody;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.MessageBodyUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 留言正文操作服务。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageBodyOperateService extends Service {

    /**
     * 下载留言正文。
     *
     * @param userKey    执行用户主键。
     * @param messageBodyKey 留言正文主键。
     * @return 留言正文。
     * @throws ServiceException 服务异常。
     */
    MessageBody download(StringIdKey userKey, LongIdKey messageBodyKey) throws ServiceException;

    /**
     * 更新留言正文。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 留言正文更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(StringIdKey userKey, MessageBodyUpdateInfo updateInfo) throws ServiceException;
}
