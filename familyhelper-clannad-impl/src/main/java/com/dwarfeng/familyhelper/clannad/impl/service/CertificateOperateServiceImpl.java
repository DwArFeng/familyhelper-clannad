package com.dwarfeng.familyhelper.clannad.impl.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionRemoveInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionUpsertInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.handler.CertificateOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

@Service
public class CertificateOperateServiceImpl implements CertificateOperateService {

    private final CertificateOperateHandler certificateOperateHandler;

    private final ServiceExceptionMapper sem;

    public CertificateOperateServiceImpl(
            CertificateOperateHandler certificateOperateHandler, ServiceExceptionMapper sem
    ) {
        this.certificateOperateHandler = certificateOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey createCertificate(StringIdKey userKey, CertificateCreateInfo certificateCreateInfo)
            throws ServiceException {
        try {
            return certificateOperateHandler.createCertificate(userKey, certificateCreateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建证件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void updateCertificate(StringIdKey userKey, CertificateUpdateInfo certificateUpdateInfo)
            throws ServiceException {
        try {
            certificateOperateHandler.updateCertificate(userKey, certificateUpdateInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新证件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removeCertificate(StringIdKey userKey, LongIdKey certificateKey) throws ServiceException {
        try {
            certificateOperateHandler.removeCertificate(userKey, certificateKey);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("删除证件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey ownerUserKey, CertificatePermissionUpsertInfo certificatePermissionUpsertInfo
    ) throws ServiceException {
        try {
            certificateOperateHandler.upsertPermission(ownerUserKey, certificatePermissionUpsertInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("添加证件的访客权限时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void removePermission(
            StringIdKey ownerUserKey, CertificatePermissionRemoveInfo certificatePermissionRemoveInfo
    ) throws ServiceException {
        try {
            certificateOperateHandler.removePermission(ownerUserKey, certificatePermissionRemoveInfo);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("移除证件的访客权限时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
