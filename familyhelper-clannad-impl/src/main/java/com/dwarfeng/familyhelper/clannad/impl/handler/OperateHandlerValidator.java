package com.dwarfeng.familyhelper.clannad.impl.handler;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constants;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Message;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.MessageAuthorization;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.MessageAuthorizationKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.exception.*;
import com.dwarfeng.familyhelper.clannad.stack.service.*;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

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
    private final MessageMaintainService messageMaintainService;
    private final MessageAuthorizationMaintainService messageAuthorizationMaintainService;
    private final MessageBodyInfoMaintainService messageBodyInfoMaintainService;
    private final MessageAttachmentInfoMaintainService messageAttachmentInfoMaintainService;

    public OperateHandlerValidator(
            UserMaintainService userMaintainService,
            AvatarInfoMaintainService avatarInfoMaintainService,
            NotificationMaintainService notificationMaintainService,
            ProfileMaintainService profileMaintainService,
            CertificateMaintainService certificateMaintainService,
            PoceMaintainService poceMaintainService,
            CertificateFileInfoMaintainService certificateFileInfoMaintainService,
            MessageMaintainService messageMaintainService,
            MessageAuthorizationMaintainService messageAuthorizationMaintainService,
            MessageBodyInfoMaintainService messageBodyInfoMaintainService,
            MessageAttachmentInfoMaintainService messageAttachmentInfoMaintainService
    ) {
        this.userMaintainService = userMaintainService;
        this.avatarInfoMaintainService = avatarInfoMaintainService;
        this.notificationMaintainService = notificationMaintainService;
        this.profileMaintainService = profileMaintainService;
        this.certificateMaintainService = certificateMaintainService;
        this.poceMaintainService = poceMaintainService;
        this.certificateFileInfoMaintainService = certificateFileInfoMaintainService;
        this.messageMaintainService = messageMaintainService;
        this.messageAuthorizationMaintainService = messageAuthorizationMaintainService;
        this.messageBodyInfoMaintainService = messageBodyInfoMaintainService;
        this.messageAttachmentInfoMaintainService = messageAttachmentInfoMaintainService;
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

    public void makeSureMessageExists(LongIdKey messageKey) throws HandlerException {
        try {
            if (!messageMaintainService.exists(messageKey)) {
                throw new MessageNotExistsException(messageKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureMessageAuthorizedToSend(StringIdKey sendUserKey, StringIdKey receiveUserKey)
            throws HandlerException {
        try {
            if (Objects.isNull(sendUserKey) || Objects.isNull(receiveUserKey)) {
                throw new UserNotExistsException(null);
            }
            MessageAuthorizationKey key = new MessageAuthorizationKey(
                    receiveUserKey.getStringId(), sendUserKey.getStringId()
            );
            MessageAuthorization messageAuthorization = messageAuthorizationMaintainService.getIfExists(key);
            if (Objects.isNull(messageAuthorization)) {
                throw new MessageUnauthorizedToSendException(sendUserKey, receiveUserKey);
            }
            if (!messageAuthorization.isEnabled()) {
                throw new MessageUnauthorizedToSendException(sendUserKey, receiveUserKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureUserMatch(StringIdKey actualUserKey, Set<StringIdKey> validUserKeys) throws HandlerException {
        if (!validUserKeys.contains(actualUserKey)) {
            throw new UserMismatchException(validUserKeys, actualUserKey);
        }
    }

    public void makeSureMessageStatusMatch(LongIdKey messageKey, Set<Integer> validStatusSet) throws
            HandlerException {
        try {
            Message message = messageMaintainService.getIfExists(messageKey);
            if (Objects.isNull(message)) {
                throw new MessageNotExistsException(messageKey);
            }
            int messageStatus = message.getStatus();
            if (!validStatusSet.contains(messageStatus)) {
                throw new MessageStatusMismatchException(validStatusSet, messageStatus);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureMessageBodyExists(LongIdKey messageBodyKey) throws HandlerException {
        try {
            if (!messageBodyInfoMaintainService.exists(messageBodyKey)) {
                throw new MessageBodyNotExistsException(messageBodyKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureMessageAttachmentExists(LongIdKey messageAttachmentKey) throws HandlerException {
        try {
            if (!messageAttachmentInfoMaintainService.exists(messageAttachmentKey)) {
                throw new MessageAttachmentNotExistsException(messageAttachmentKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureMessageAuthorizationExists(MessageAuthorizationKey key) throws Exception {
        try {
            if (!messageAuthorizationMaintainService.exists(key)) {
                throw new MessageAuthorizationNotExistsException(key);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureMessageAuthorizationNotExists(MessageAuthorizationKey key) throws Exception {
        try {
            if (messageAuthorizationMaintainService.exists(key)) {
                throw new MessageAuthorizationExistsException(key);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
