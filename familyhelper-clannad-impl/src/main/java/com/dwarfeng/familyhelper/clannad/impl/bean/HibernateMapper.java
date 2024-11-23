package com.dwarfeng.familyhelper.clannad.impl.bean;

import com.dwarfeng.familyhelper.clannad.impl.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.*;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Hibernate Bean 映射器。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
@Mapper
public interface HibernateMapper {

    HibernateLongIdKey longIdKeyToHibernate(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromHibernate(HibernateLongIdKey hibernateLongIdKey);

    HibernateStringIdKey stringIdKeyToHibernate(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromHibernate(HibernateStringIdKey hibernateStringIdKey);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "stringId", ignore = true)
    HibernateAvatarInfo avatarInfoToHibernate(AvatarInfo avatarInfo);

    @InheritInverseConfiguration
    AvatarInfo avatarInfoFromHibernate(HibernateAvatarInfo hibernateAvatarInfo);

    HibernatePoceKey poceKeyToHibernate(PoceKey poceKey);

    @InheritInverseConfiguration
    PoceKey poceKeyFromHibernate(HibernatePoceKey hibernatePoceKey);

    HibernatePoprKey poprKeyToHibernate(PoprKey poprKey);

    @InheritInverseConfiguration
    PoprKey poprKeyFromHibernate(HibernatePoprKey hibernatePoprKey);

    HibernateMessageAuthorizationKey messageAuthorizationKeyToHibernate(
            MessageAuthorizationKey messageAuthorizationKey
    );

    @InheritInverseConfiguration
    MessageAuthorizationKey messageAuthorizationKeyFromHibernate(
            HibernateMessageAuthorizationKey hibernateMessageAuthorizationKey
    );

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "certificateId", ignore = true)
    @Mapping(target = "certificate", ignore = true)
    HibernatePoce poceToHibernate(Poce poce);

    @InheritInverseConfiguration
    Poce poceFromHibernate(HibernatePoce hibernatePoce);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "profileId", ignore = true)
    @Mapping(target = "profile", ignore = true)
    HibernatePopr poprToHibernate(Popr popr);

    @InheritInverseConfiguration
    Popr poprFromHibernate(HibernatePopr hibernatePopr);

    @Mapping(target = "poces", ignore = true)
    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "certificateFileInfos", ignore = true)
    HibernateCertificate certificateToHibernate(Certificate certificate);

    @InheritInverseConfiguration
    Certificate certificateFromHibernate(HibernateCertificate hibernateCertificate);

    @Mapping(target = "longId", ignore = true)
    @Mapping(target = "certificateLongId", ignore = true)
    @Mapping(target = "certificate", ignore = true)
    HibernateCertificateFileInfo certificateFileInfoToHibernate(CertificateFileInfo certificateFileInfo);

    @InheritInverseConfiguration
    CertificateFileInfo certificateFileInfoFromHibernate(HibernateCertificateFileInfo hibernateCertificateFileInfo);

    HibernateNicknameKey nicknameKeyToHibernate(NicknameKey nicknameKey);

    @InheritInverseConfiguration
    NicknameKey nicknameKeyFromHibernate(HibernateNicknameKey hibernateNicknameKey);

    @Mapping(target = "subjectUserId", ignore = true)
    @Mapping(target = "subjectUser", ignore = true)
    @Mapping(target = "objectUserId", ignore = true)
    @Mapping(target = "objectUser", ignore = true)
    HibernateNickname nicknameToHibernate(Nickname nickname);

    @InheritInverseConfiguration
    Nickname nicknameFromHibernate(HibernateNickname hibernateNickname);

    @Mapping(target = "userStringId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "longId", ignore = true)
    HibernateNotification notificationToHibernate(Notification notification);

    @InheritInverseConfiguration
    Notification notificationFromHibernate(HibernateNotification hibernateNotification);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "stringId", ignore = true)
    @Mapping(target = "poprs", ignore = true)
    HibernateProfile profileToHibernate(Profile profile);

    @InheritInverseConfiguration
    Profile profileFromHibernate(HibernateProfile hibernateProfile);

    HibernateProfileTypeIndicatorKey profileTypeIndicatorKeyToHibernate(
            ProfileTypeIndicatorKey profileTypeIndicatorKey
    );

    @InheritInverseConfiguration
    ProfileTypeIndicatorKey profileTypeIndicatorKeyFromHibernate(
            HibernateProfileTypeIndicatorKey hibernateProfileTypeIndicatorKey
    );

    @Mapping(target = "stringId", ignore = true)
    @Mapping(target = "categoryId", ignore = true)
    HibernateProfileTypeIndicator profileTypeIndicatorToHibernate(ProfileTypeIndicator profileTypeIndicator);

    @InheritInverseConfiguration
    ProfileTypeIndicator profileTypeIndicatorFromHibernate(HibernateProfileTypeIndicator hibernateProfileTypeIndicator);

    @Mapping(target = "subjectNicknames", ignore = true)
    @Mapping(target = "stringId", ignore = true)
    @Mapping(target = "sendMessages", ignore = true)
    @Mapping(target = "receivedMessageAuthorizations", ignore = true)
    @Mapping(target = "receiveMessages", ignore = true)
    @Mapping(target = "profile", ignore = true)
    @Mapping(target = "poprs", ignore = true)
    @Mapping(target = "poces", ignore = true)
    @Mapping(target = "objectNicknames", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "avatarInfo", ignore = true)
    @Mapping(target = "authorizedSendMessageAuthorizations", ignore = true)
    HibernateUser userToHibernate(User user);

    @InheritInverseConfiguration
    User userFromHibernate(HibernateUser hibernateUser);

    @Mapping(target = "sendUserStringId", ignore = true)
    @Mapping(target = "sendUser", ignore = true)
    @Mapping(target = "receiveUserStringId", ignore = true)
    @Mapping(target = "receiveUser", ignore = true)
    @Mapping(target = "messageBodyInfo", ignore = true)
    @Mapping(target = "messageAttachmentInfos", ignore = true)
    @Mapping(target = "longId", ignore = true)
    HibernateMessage messageToHibernate(Message message);

    @InheritInverseConfiguration
    Message messageFromHibernate(HibernateMessage hibernateMessage);

    @Mapping(target = "message", ignore = true)
    @Mapping(target = "longId", ignore = true)
    HibernateMessageBodyInfo messageBodyInfoToHibernate(MessageBodyInfo messageBodyInfo);

    @InheritInverseConfiguration
    MessageBodyInfo messageBodyInfoFromHibernate(
            HibernateMessageBodyInfo hibernateMessageBodyInfo
    );

    @Mapping(target = "messageLongId", ignore = true)
    @Mapping(target = "message", ignore = true)
    @Mapping(target = "longId", ignore = true)
    HibernateMessageAttachmentInfo messageAttachmentInfoToHibernate(MessageAttachmentInfo messageAttachmentInfo);

    @InheritInverseConfiguration
    MessageAttachmentInfo messageAttachmentInfoFromHibernate(
            HibernateMessageAttachmentInfo hibernateMessageAttachmentInfo
    );

    @Mapping(target = "receiveUserId", ignore = true)
    @Mapping(target = "receiveUser", ignore = true)
    @Mapping(target = "authorizedSendUserId", ignore = true)
    @Mapping(target = "authorizedSendUser", ignore = true)
    HibernateMessageAuthorization messageAuthorizationToHibernate(MessageAuthorization messageAuthorization);

    @InheritInverseConfiguration
    MessageAuthorization messageAuthorizationFromHibernate(HibernateMessageAuthorization hibernateMessageAuthorization);
}
