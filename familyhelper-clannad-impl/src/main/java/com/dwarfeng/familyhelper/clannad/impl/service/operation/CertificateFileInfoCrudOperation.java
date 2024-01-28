package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.impl.util.FtpConstants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.familyhelper.clannad.stack.cache.CertificateFileInfoCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.CertificateFileInfoDao;
import com.dwarfeng.ftp.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificateFileInfoCrudOperation implements BatchCrudOperation<LongIdKey, CertificateFileInfo> {

    private final CertificateFileInfoDao certificateFileInfoDao;
    private final CertificateFileInfoCache certificateFileInfoCache;

    private final FtpHandler ftpHandler;

    @Value("${cache.timeout.entity.certificate_file_info}")
    private long certificateFileInfoTimeout;

    public CertificateFileInfoCrudOperation(
            CertificateFileInfoDao certificateFileInfoDao, CertificateFileInfoCache certificateFileInfoCache,
            FtpHandler ftpHandler
    ) {
        this.certificateFileInfoDao = certificateFileInfoDao;
        this.certificateFileInfoCache = certificateFileInfoCache;
        this.ftpHandler = ftpHandler;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return certificateFileInfoCache.exists(key) || certificateFileInfoDao.exists(key);
    }

    @Override
    public CertificateFileInfo get(LongIdKey key) throws Exception {
        if (certificateFileInfoCache.exists(key)) {
            return certificateFileInfoCache.get(key);
        } else {
            if (!certificateFileInfoDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            CertificateFileInfo certificateFileInfo = certificateFileInfoDao.get(key);
            certificateFileInfoCache.push(certificateFileInfo, certificateFileInfoTimeout);
            return certificateFileInfo;
        }
    }

    @Override
    public LongIdKey insert(CertificateFileInfo certificateFileInfo) throws Exception {
        certificateFileInfoCache.push(certificateFileInfo, certificateFileInfoTimeout);
        return certificateFileInfoDao.insert(certificateFileInfo);
    }

    @Override
    public void update(CertificateFileInfo certificateFileInfo) throws Exception {
        certificateFileInfoCache.push(certificateFileInfo, certificateFileInfoTimeout);
        certificateFileInfoDao.update(certificateFileInfo);
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void delete(LongIdKey key) throws Exception {
        // 如果存在证书文件，则删除证书文件。
        if (ftpHandler.existsFile(FtpConstants.PATH_CERTIFICATE_FILE, getFileName(key))) {
            ftpHandler.deleteFile(FtpConstants.PATH_CERTIFICATE_FILE, getFileName(key));
        }

        // 删除证书文件信息实体自身。
        certificateFileInfoCache.delete(key);
        certificateFileInfoDao.delete(key);
    }

    private String getFileName(LongIdKey certificateFileKey) {
        return Long.toString(certificateFileKey.getLongId());
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return certificateFileInfoCache.allExists(keys) || certificateFileInfoDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return certificateFileInfoCache.nonExists(keys) && certificateFileInfoDao.nonExists(keys);
    }

    @Override
    public List<CertificateFileInfo> batchGet(List<LongIdKey> keys) throws Exception {
        if (certificateFileInfoCache.allExists(keys)) {
            return certificateFileInfoCache.batchGet(keys);
        } else {
            if (!certificateFileInfoDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<CertificateFileInfo> certificateFileInfos = certificateFileInfoDao.batchGet(keys);
            certificateFileInfoCache.batchPush(certificateFileInfos, certificateFileInfoTimeout);
            return certificateFileInfos;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<CertificateFileInfo> certificateFileInfos) throws Exception {
        certificateFileInfoCache.batchPush(certificateFileInfos, certificateFileInfoTimeout);
        return certificateFileInfoDao.batchInsert(certificateFileInfos);
    }

    @Override
    public void batchUpdate(List<CertificateFileInfo> certificateFileInfos) throws Exception {
        certificateFileInfoCache.batchPush(certificateFileInfos, certificateFileInfoTimeout);
        certificateFileInfoDao.batchUpdate(certificateFileInfos);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
