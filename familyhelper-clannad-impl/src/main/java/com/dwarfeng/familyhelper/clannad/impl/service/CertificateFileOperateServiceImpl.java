package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.*;
import com.dwarfeng.familyhelper.clannad.stack.handler.CertificateFileOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateFileOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class CertificateFileOperateServiceImpl implements CertificateFileOperateService {

    private final CertificateFileOperateHandler certificateFileOperateHandler;

    private final ServiceExceptionMapper sem;

    public CertificateFileOperateServiceImpl(
            CertificateFileOperateHandler certificateFileOperateHandler,
            ServiceExceptionMapper sem
    ) {
        this.certificateFileOperateHandler = certificateFileOperateHandler;
        this.sem = sem;
    }

    @Override
    public CertificateFile downloadCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey)
            throws ServiceException {
        try {
            return certificateFileOperateHandler.downloadCertificateFile(userKey, certificateFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载证件文件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public CertificateFileStream downloadCertificateFileStream(StringIdKey userKey, LongIdKey certificateFileKey)
            throws ServiceException {
        try {
            return certificateFileOperateHandler.downloadCertificateFileStream(userKey, certificateFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载证件文件流时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public CertificateThumbnail downloadCertificateThumbnail(StringIdKey userKey, LongIdKey certificateFileKey)
            throws ServiceException {
        try {
            return certificateFileOperateHandler.downloadCertificateThumbnail(userKey, certificateFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载证件缩略图时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void uploadCertificateFile(StringIdKey userKey, CertificateFileUploadInfo certificateFileUploadInfo)
            throws ServiceException {
        try {
            certificateFileOperateHandler.uploadCertificateFile(userKey, certificateFileUploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("上传证件文件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void uploadCertificateFileStream(StringIdKey userKey, CertificateFileStreamUploadInfo uploadInfo)
            throws ServiceException {
        try {
            certificateFileOperateHandler.uploadCertificateFileStream(userKey, uploadInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("上传证件文件流时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removeCertificateFile(StringIdKey userKey, LongIdKey certificateFileKey) throws ServiceException {
        try {
            certificateFileOperateHandler.removeCertificateFile(userKey, certificateFileKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除证件文件时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
