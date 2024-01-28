package com.dwarfeng.familyhelper.clannad.stack.handler;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFile;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateFileUploadInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateThumbnail;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 证件文件操作处理器。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface CertificateFileOperateHandler extends Handler {

    /**
     * 下载证件文件。
     *
     * @param userKey            执行用户主键。
     * @param certificateFileKey 证件文件主键。
     * @return 证件文件。
     * @throws HandlerException 处理器异常。
     */
    CertificateFile downloadCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey) throws HandlerException;

    /**
     * 下载证件缩略图。
     *
     * @param userKey            执行用户主键。
     * @param certificateFileKey 证件文件主键。
     * @return 证件缩略图。
     * @throws HandlerException 处理器异常。
     * @since 1.4.0
     */
    CertificateThumbnail downloadCertificateThumbnail(StringIdKey userKey, LongIdKey certificateFileKey)
            throws HandlerException;

    /**
     * 上传证件文件。
     *
     * @param userKey                   执行用户主键。
     * @param certificateFileUploadInfo 证件文件上传信息。
     * @throws HandlerException 处理器异常。
     */
    void uploadCertificateFile(StringIdKey userKey, CertificateFileUploadInfo certificateFileUploadInfo)
            throws HandlerException;

    /**
     * 删除证件文件。
     *
     * @param userKey            执行用户主键。
     * @param certificateFileKey 证件文件主键。
     * @throws HandlerException 处理器异常。
     */
    void removeCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey) throws HandlerException;
}
