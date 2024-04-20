package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 证件文件操作服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface CertificateFileOperateService extends Service {

    /**
     * 下载证件文件。
     *
     * @param userKey            执行用户主键。
     * @param certificateFileKey 证件文件主键。
     * @return 证件文件。
     * @throws ServiceException 服务异常。
     */
    CertificateFile downloadCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey) throws ServiceException;

    /**
     * 下载证件文件流。
     *
     * <p>
     * 如果返回的 <code>CertificateFileStream</code> 不为 <code>null</code>，则调用者有义务关闭
     * <code>CertificateFileStream</code> 中的输入流，即其中的 <code>CertificateFileStream.content</code>。
     *
     * @param userKey            执行用户主键。
     * @param certificateFileKey 证件文件主键。
     * @return 证件文件流。
     * @throws ServiceException 服务异常。
     * @since 1.4.1
     */
    CertificateFileStream downloadCertificateFileStream(StringIdKey userKey, LongIdKey certificateFileKey)
            throws ServiceException;

    /**
     * 下载证件缩略图。
     *
     * @param userKey            执行用户主键。
     * @param certificateFileKey 证件文件主键。
     * @return 证件缩略图。
     * @throws ServiceException 服务异常。
     * @since 1.4.0
     */
    CertificateThumbnail downloadCertificateThumbnail(StringIdKey userKey, LongIdKey certificateFileKey)
            throws ServiceException;

    /**
     * 上传证件文件。
     *
     * @param userKey    执行用户主键。
     * @param uploadInfo 证件文件上传信息。
     * @throws ServiceException 服务异常。
     */
    void uploadCertificateFile(StringIdKey userKey, CertificateFileUploadInfo uploadInfo) throws ServiceException;

    /**
     * 上传证件文件流。
     *
     * <p>
     * 调用者有义务关闭 <code>CertificateFileStreamUploadInfo</code> 中的输入流，
     * 即其中的 <code>CertificateFileStreamUploadInfo.content</code>。
     *
     * @param userKey    执行用户主键。
     * @param uploadInfo 证件文件流上传信息。
     * @throws ServiceException 服务异常。
     * @since 1.4.1
     */
    void uploadCertificateFileStream(StringIdKey userKey, CertificateFileStreamUploadInfo uploadInfo)
            throws ServiceException;

    /**
     * 删除证件文件。
     *
     * @param userKey            执行用户主键。
     * @param certificateFileKey 证件文件主键。
     * @throws ServiceException 服务异常。
     */
    void removeCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey) throws ServiceException;
}
