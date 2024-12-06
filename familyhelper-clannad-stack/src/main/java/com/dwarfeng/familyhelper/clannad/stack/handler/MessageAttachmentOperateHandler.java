package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 留言附件操作处理器。
 *
 * @author DwArFeng
 * @since 1.5.0
 */
public interface MessageAttachmentOperateHandler extends Handler {

    /**
     * 下载留言附件。
     *
     * @param userKey              执行用户主键。
     * @param messageAttachmentKey 留言附件主键。
     * @return 留言附件。
     * @throws HandlerException 处理器异常。
     */
    MessageAttachment download(StringIdKey userKey, LongIdKey messageAttachmentKey) throws HandlerException;

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
     * @throws HandlerException 处理器异常。
     */
    MessageAttachmentStream downloadStream(StringIdKey userKey, LongIdKey messageAttachmentKey) throws HandlerException;

    /**
     * 上传留言附件。
     *
     * @param userKey    执行用户主键。
     * @param uploadInfo 留言附件上传信息。
     * @throws HandlerException 处理器异常。
     */
    void upload(StringIdKey userKey, MessageAttachmentUploadInfo uploadInfo) throws HandlerException;

    /**
     * 上传留言附件流。
     *
     * <p>
     * 调用者有义务关闭 <code>MessageAttachmentStreamUploadInfo</code> 中的输入流，
     * 即其中的 <code>MessageAttachmentStreamUploadInfo.content</code>。
     *
     * @param userKey    执行用户主键。
     * @param uploadInfo 留言附件流上传信息。
     * @throws HandlerException 处理器异常。
     */
    void uploadStream(StringIdKey userKey, MessageAttachmentStreamUploadInfo uploadInfo) throws HandlerException;

    /**
     * 更新留言附件。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 留言附件更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(StringIdKey userKey, MessageAttachmentUpdateInfo updateInfo) throws HandlerException;

    /**
     * 更新留言附件流。
     *
     * <p>
     * 调用者有义务关闭 <code>MessageAttachmentStreamUpdateInfo</code> 中的输入流，
     * 即其中的 <code>MessageAttachmentStreamUpdateInfo.content</code>。
     *
     * @param userKey    执行用户主键。
     * @param updateInfo 留言附件流更新信息。
     * @throws HandlerException 处理器异常。
     */
    void updateStream(StringIdKey userKey, MessageAttachmentStreamUpdateInfo updateInfo) throws HandlerException;

    /**
     * 删除留言附件。
     *
     * @param userKey              执行用户主键。
     * @param messageAttachmentKey 留言附件主键。
     * @throws HandlerException 处理器异常。
     */
    void remove(StringIdKey userKey, LongIdKey messageAttachmentKey) throws HandlerException;
}