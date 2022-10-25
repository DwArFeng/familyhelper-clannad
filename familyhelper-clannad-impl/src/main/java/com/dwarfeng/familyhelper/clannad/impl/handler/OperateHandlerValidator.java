package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.exception.*;
import com.dwarfeng.familyhelper.clannad.stack.service.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 操作处理器验证器。
 *
 * <p>
 * 为操作处理器提供公共的验证方法。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
@Component
public class OperateHandlerValidator {

    private final UserMaintainService userMaintainService;
    private final AvatarInfoMaintainService avatarInfoMaintainService;
    private final NotificationMaintainService notificationMaintainService;
    private final ProfileMaintainService profileMaintainService;
    private final CertificateMaintainService certificateMaintainService;
    private final PoceMaintainService poceMaintainService;
    private final CertificateFileInfoMaintainService certificateFileInfoMaintainService;

    public OperateHandlerValidator(
            UserMaintainService userMaintainService,
            AvatarInfoMaintainService avatarInfoMaintainService,
            NotificationMaintainService notificationMaintainService,
            ProfileMaintainService profileMaintainService,
            CertificateMaintainService certificateMaintainService,
            PoceMaintainService poceMaintainService,
            CertificateFileInfoMaintainService certificateFileInfoMaintainService
    ) {
        this.userMaintainService = userMaintainService;
        this.avatarInfoMaintainService = avatarInfoMaintainService;
        this.notificationMaintainService = notificationMaintainService;
        this.profileMaintainService = profileMaintainService;
        this.certificateMaintainService = certificateMaintainService;
        this.poceMaintainService = poceMaintainService;
        this.certificateFileInfoMaintainService = certificateFileInfoMaintainService;
    }

    public void makeSureUserExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!userMaintainService.exists(userKey)) {
                throw new UserNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureAvatarExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!avatarInfoMaintainService.exists(userKey)) {
                throw new AvatarNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureNotificationExists(LongIdKey notificationKey) throws HandlerException {
        try {
            if (Objects.isNull(notificationKey) || !notificationMaintainService.exists(notificationKey)) {
                throw new NotificationNotExistsException(notificationKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureProfileExists(StringIdKey profileKey) throws HandlerException {
        try {
            if (!profileMaintainService.exists(profileKey)) {
                throw new ProfileNotExistsException(profileKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureCertificateExists(LongIdKey certificateKey) throws HandlerException {
        try {
            if (!certificateMaintainService.exists(certificateKey)) {
                throw new CertificateNotExistsException(certificateKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSurePermissionLevelValid(int permissionLevel) throws HandlerException {
        if (permissionLevel == Constants.PERMISSION_LEVEL_GUEST) {
            return;
        }
        throw new InvalidPermissionLevelException(permissionLevel);
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserInspectPermittedForCertificate(StringIdKey userKey, LongIdKey certificateKey)
            throws HandlerException {
        try {
            // 1. 构造 Poce 主键。
            PoceKey poceKey = new PoceKey(certificateKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poce 实体是否存在，如果不存在，则没有权限。
            if (!poceMaintainService.exists(poceKey)) {
                throw new UserNotPermittedForCertificateException(userKey, certificateKey);
            }

            // 3. 查看 Poce.permissionLevel 是否为 Poce.PERMISSION_LEVEL_OWNER 或 Poce.PERMISSION_LEVEL_GUEST，
            // 如果不是，则没有权限。
            Poce poce = poceMaintainService.get(poceKey);
            if (Objects.equals(poce.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            if (Objects.equals(poce.getPermissionLevel(), Constants.PERMISSION_LEVEL_GUEST)) {
                return;
            }
            throw new UserNotPermittedForCertificateException(userKey, certificateKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public void makeSureUserModifyPermittedForCertificate(StringIdKey userKey, LongIdKey assetCatalogKey)
            throws HandlerException {
        try {
            // 1. 构造 Poce 主键。
            PoceKey poceKey = new PoceKey(assetCatalogKey.getLongId(), userKey.getStringId());

            // 2. 查看 Poce 实体是否存在，如果不存在，则没有权限。
            if (!poceMaintainService.exists(poceKey)) {
                throw new UserNotPermittedForCertificateException(userKey, assetCatalogKey);
            }

            // 3. 查看 Poce.permissionLevel 是否为 Poce.PERMISSION_LEVEL_OWNER，如果不是，则没有权限。
            Poce poce = poceMaintainService.get(poceKey);
            if (Objects.equals(poce.getPermissionLevel(), Constants.PERMISSION_LEVEL_OWNER)) {
                return;
            }
            throw new UserNotPermittedForCertificateException(userKey, assetCatalogKey);
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureCertificateFileExists(LongIdKey certificateFileKey) throws HandlerException {
        try {
            if (!certificateFileInfoMaintainService.exists(certificateFileKey)) {
                throw new CertificateFileNotExistsException(certificateFileKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
