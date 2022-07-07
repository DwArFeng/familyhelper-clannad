package com.dwarfeng.familyhelper.clannad.stack.service;

import com.dwarfeng.familyhelper.clannad.stack.bean.entity.CertificateFileInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 证书文件信息维护服务。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public interface CertificateFileInfoMaintainService extends BatchCrudService<LongIdKey, CertificateFileInfo>,
        EntireLookupService<CertificateFileInfo>, PresetLookupService<CertificateFileInfo> {

    String CHILD_FOR_CERTIFICATE = "child_for_certificate";
}
