package com.dwarfeng.familyhelper.clannad.impl.service.operation;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.CertificateCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.PoceCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.CertificateDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.CertificateFileInfoDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.PoceDao;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateFileInfoMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.PoceMaintainService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CertificateCrudOperation implements BatchCrudOperation<LongIdKey, Certificate> {

    private final CertificateDao certificateDao;
    private final CertificateCache certificateCache;

    private final CertificateFileInfoCrudOperation certificateFileInfoCrudOperation;
    private final CertificateFileInfoDao certificateFileInfoDao;

    private final PoceDao poceDao;
    private final PoceCache poceCache;

    @Value("${cache.timeout.entity.certificate}")
    private long certificateTimeout;

    public CertificateCrudOperation(
            CertificateDao certificateDao, CertificateCache certificateCache,
            CertificateFileInfoCrudOperation certificateFileInfoCrudOperation, CertificateFileInfoDao certificateFileInfoDao,
            PoceDao poceDao, PoceCache poceCache
    ) {
        this.certificateDao = certificateDao;
        this.certificateCache = certificateCache;
        this.certificateFileInfoCrudOperation = certificateFileInfoCrudOperation;
        this.certificateFileInfoDao = certificateFileInfoDao;
        this.poceDao = poceDao;
        this.poceCache = poceCache;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return certificateCache.exists(key) || certificateDao.exists(key);
    }

    @Override
    public Certificate get(LongIdKey key) throws Exception {
        if (certificateCache.exists(key)) {
            return certificateCache.get(key);
        } else {
            if (!certificateDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            Certificate certificate = certificateDao.get(key);
            certificateCache.push(certificate, certificateTimeout);
            return certificate;
        }
    }

    @Override
    public LongIdKey insert(Certificate certificate) throws Exception {
        certificateCache.push(certificate, certificateTimeout);
        return certificateDao.insert(certificate);
    }

    @Override
    public void update(Certificate certificate) throws Exception {
        certificateCache.push(certificate, certificateTimeout);
        certificateDao.update(certificate);
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void delete(LongIdKey key) throws Exception {
        // 删除与证书相关的证书文件信息。
        List<LongIdKey> certificateFileInfoKeys = certificateFileInfoDao.lookup(
                CertificateFileInfoMaintainService.CHILD_FOR_CERTIFICATE, new Object[]{key}
        ).stream().map(CertificateFileInfo::getKey).collect(Collectors.toList());
        certificateFileInfoCrudOperation.batchDelete(certificateFileInfoKeys);

        // 删除与证书相关的证书权限。
        List<PoceKey> poceKeys = poceDao.lookup(PoceMaintainService.CHILD_FOR_CERTIFICATE, new Object[]{key})
                .stream().map(Poce::getKey).collect(Collectors.toList());
        poceCache.batchDelete(poceKeys);
        poceDao.batchDelete(poceKeys);

        // 删除证书实体自身。
        certificateCache.delete(key);
        certificateDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return certificateCache.allExists(keys) || certificateDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return certificateCache.nonExists(keys) && certificateDao.nonExists(keys);
    }

    @Override
    public List<Certificate> batchGet(List<LongIdKey> keys) throws Exception {
        if (certificateCache.allExists(keys)) {
            return certificateCache.batchGet(keys);
        } else {
            if (!certificateDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<Certificate> certificates = certificateDao.batchGet(keys);
            certificateCache.batchPush(certificates, certificateTimeout);
            return certificates;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<Certificate> certificates) throws Exception {
        certificateCache.batchPush(certificates, certificateTimeout);
        return certificateDao.batchInsert(certificates);
    }

    @Override
    public void batchUpdate(List<Certificate> certificates) throws Exception {
        certificateCache.batchPush(certificates, certificateTimeout);
        certificateDao.batchUpdate(certificates);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
