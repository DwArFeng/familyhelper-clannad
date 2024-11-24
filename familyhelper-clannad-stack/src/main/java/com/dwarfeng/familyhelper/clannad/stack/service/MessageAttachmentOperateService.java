package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 留言附件操作服务。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAttachmentOperateService extends Service {

    /**
     * 下载留言附件。
     *
     * @param userKey              执行用户主键。
     * @param messageAttachmentKey 留言附件主键。
     * @return 留言附件。
     * @throws ServiceException 服务异常。
     */
    MessageAttachment download(StringIdKey userKey, LongIdKey messageAttachmentKey) throws ServiceException;

    /**
     * 下载留言附件流。
     *
     * <p>
     * 如果返回的 <code>MessageAttachmentStream</code> 不为 <code>null</code>，则调用者有义务关闭
     * <code>MessageAttachmentStream</code> 中的输入流，即其中的 <code>MessageAttachmentStream.content</code>。
     *
     * @param userKey              执行用户主键。
     * @param messageAttachmentKey 留言附件主键。
     * @return 留言附件流。
     * @throws ServiceException 服务异常。
     */
    MessageAttachmentStream downloadStream(StringIdKey userKey, LongIdKey messageAttachmentKey) throws ServiceException;

    /**
     * 上传留言附件。
     *
     * @param userKey    执行用户主键。
     * @param uploadInfo 留言附件上传信息。
     * @throws ServiceException 服务异常。
     */
    void upload(StringIdKey userKey, MessageAttachmentUploadInfo uploadInfo) throws ServiceException;

    /**
     * 上传留言附件流。
     *
     * <p>
     * 调用者有义务关闭 <code>MessageAttachmentStreamUploadInfo</code> 中的输入流，
     * 即其中的 <code>MessageAttachmentStreamUploadInfo.content</code>。
     *
     * @param userKey    执行用户主键。
     * @param uploadInfo 留言附件流上传信息。
     */
    void uploadStream(StringIdKey userKey, MessageAttachmentStreamUploadInfo uploadInfo) throws ServiceException;

    /**
     * 更新留言附件。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 留言附件更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(StringIdKey userKey, MessageAttachmentUpdateInfo updateInfo) throws ServiceException;

    /**
     * 更新留言附件流。
     *
     * <p>
     * 调用者有义务关闭 <code>MessageAttachmentStreamUpdateInfo</code> 中的输入流，
     * 即其中的 <code>MessageAttachmentStreamUpdateInfo.content</code>。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 留言附件流更新信息。
     */
    void updateStream(StringIdKey userKey, MessageAttachmentStreamUpdateInfo updateInfo) throws ServiceException;

    /**
     * 删除留言附件。
     *
     * @param userKey              执行用户主键。
     * @param messageAttachmentKey 留言附件主键。
     * @throws ServiceException 服务异常。
     */
    void remove(StringIdKey userKey, LongIdKey messageAttachmentKey) throws ServiceException;
}
