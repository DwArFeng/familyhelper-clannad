package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constants;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateCreateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionRemoveInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificatePermissionUpsertInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.CertificateUpdateInfo;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Certificate;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.handler.CertificateOperateHandler;
import com.dwarfeng.familyhelper.clannad.stack.service.CertificateMaintainService;
import com.dwarfeng.familyhelper.clannad.stack.service.PoceMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CertificateOperateHandlerImpl implements CertificateOperateHandler {

    private final CertificateMaintainService certificateMaintainService;
    private final PoceMaintainService poceMaintainService;

    private final OperateHandlerValidator operateHandlerValidator;

    public CertificateOperateHandlerImpl(
            CertificateMaintainService certificateMaintainService,
            PoceMaintainService poceMaintainService,
            OperateHandlerValidator operateHandlerValidator
    ) {
        this.certificateMaintainService = certificateMaintainService;
        this.poceMaintainService = poceMaintainService;
        this.operateHandlerValidator = operateHandlerValidator;
    }

    @Override
    public LongIdKey createCertificate(StringIdKey userKey, CertificateCreateInfo certificateCreateInfo)
            throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 根据 certificateCreateInfo 以及创建的规则组合 账本 实体。
            Certificate certificate = new Certificate(
                    null, certificateCreateInfo.getName(), certificateCreateInfo.getRemark()
            );

            // 3. 插入账本实体，并获取生成的主键。
            LongIdKey certificateKey = certificateMaintainService.insert(certificate);

            // 4. 由账本实体生成的主键和用户主键组合权限信息，并插入。
            Poce poce = new Poce(
                    new PoceKey(certificateKey.getLongId(), userKey.getStringId()),
                    Constants.PERMISSION_LEVEL_OWNER,
                    "创建账本时自动插入，赋予创建人所有者权限"
            );
            poceMaintainService.insert(poce);

            // 5. 返回生成的主键。
            return certificateKey;
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void updateCertificate(StringIdKey userKey, CertificateUpdateInfo certificateUpdateInfo)
            throws HandlerException {
        try {
            LongIdKey certificateKey = certificateUpdateInfo.getCertificateKey();

            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认账本存在。
            operateHandlerValidator.makeSureCertificateExists(certificateKey);

            // 3. 确认用户有权限操作指定的账本。
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(userKey, certificateKey);

            // 4. 根据 certificateUpdateInfo 以及更新的规则设置 账本 实体。
            Certificate certificate = certificateMaintainService.get(certificateKey);
            certificate.setName(certificateUpdateInfo.getName());
            certificate.setRemark(certificateUpdateInfo.getRemark());

            // 5. 更新账本实体。
            certificateMaintainService.update(certificate);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removeCertificate(StringIdKey userKey, LongIdKey certificateKey) throws HandlerException {
        try {
            // 1. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(userKey);

            // 2. 确认账本存在。
            operateHandlerValidator.makeSureCertificateExists(certificateKey);

            // 3. 确认用户有权限操作指定的账本。
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(userKey, certificateKey);

            // 4. 删除指定主键的账本。
            certificateMaintainService.delete(certificateKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void upsertPermission(
            StringIdKey ownerUserKey, CertificatePermissionUpsertInfo certificatePermissionUpsertInfo
    ) throws HandlerException {
        try {
            LongIdKey certificateKey = certificatePermissionUpsertInfo.getCertificateKey();
            StringIdKey targetUserKey = certificatePermissionUpsertInfo.getUserKey();
            int permissionLevel = certificatePermissionUpsertInfo.getPermissionLevel();

            // 1. 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(ownerUserKey, targetUserKey)) {
                return;
            }

            // 2. 确认 permissionLevel 有效。
            operateHandlerValidator.makeSurePermissionLevelValid(permissionLevel);

            // 3. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(ownerUserKey);
            operateHandlerValidator.makeSureUserExists(targetUserKey);

            // 4. 确认账本存在。
            operateHandlerValidator.makeSureCertificateExists(certificateKey);

            // 5. 确认用户有权限操作指定的账本。
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(ownerUserKey, certificateKey);

            // 6. 通过入口信息组合权限实体，并进行插入或更新操作。
            String permissionLabel;
            switch (permissionLevel) {
                case Constants.PERMISSION_LEVEL_GUEST:
                    permissionLabel = "目标";
                    break;
                case Constants.PERMISSION_LEVEL_OWNER:
                    permissionLabel = "所有者";
                    break;
                default:
                    permissionLabel = "（未知）";
            }
            Poce poce = new Poce(
                    new PoceKey(certificateKey.getLongId(), targetUserKey.getStringId()),
                    permissionLevel,
                    "赋予用户 " + targetUserKey.getStringId() + " " + permissionLabel + "权限"
            );
            poceMaintainService.insertOrUpdate(poce);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }

    @Override
    public void removePermission(
            StringIdKey ownerUserKey, CertificatePermissionRemoveInfo certificatePermissionRemoveInfo
    ) throws HandlerException {
        try {
            LongIdKey certificateKey = certificatePermissionRemoveInfo.getCertificateKey();
            StringIdKey targetUserKey = certificatePermissionRemoveInfo.getUserKey();

            // 1. 如果用户主键与目标主键一致，则什么也不做。
            if (Objects.equals(ownerUserKey, targetUserKey)) {
                return;
            }

            // 2. 确认用户存在。
            operateHandlerValidator.makeSureUserExists(ownerUserKey);
            operateHandlerValidator.makeSureUserExists(targetUserKey);

            // 3. 确认账本存在。
            operateHandlerValidator.makeSureCertificateExists(certificateKey);

            // 4. 确认用户有权限操作指定的账本。
            operateHandlerValidator.makeSureUserModifyPermittedForCertificate(ownerUserKey, certificateKey);

            // 5. 通过入口信息组合权限实体主键，并进行存在删除操作。
            PoceKey poceKey = new PoceKey(certificateKey.getLongId(), targetUserKey.getStringId());
            poceMaintainService.deleteIfExists(poceKey);
        } catch (HandlerException e) {
            throw e;
        } catch (Exception e) {
            throw new HandlerException(e);
        }
    }
}
