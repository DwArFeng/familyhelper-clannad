package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFile;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFileUploadInfo;
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
     * 上传证件文件。
     *
     * @param userKey                   执行用户主键。
     * @param certificateFileUploadInfo 证件文件上传信息。
     * @throws ServiceException 服务异常。
     */
    void uploadCertificateFile(StringIdKey userKey, CertificateFileUploadInfo certificateFileUploadInfo)
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
