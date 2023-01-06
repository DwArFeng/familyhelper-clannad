package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateNicknameKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernatePoceKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernatePoprKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
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

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "certificateId", ignore = true)
    @Mapping(target = "certificate", ignore = true)
    HibernatePoce poceToHibernate(Poce poce);

    @InheritInverseConfiguration
    Poce poceFromHibernate(HibernatePoce hibernatePoce);

    HibernatePoprKey poprKeyToHibernate(PoprKey poprKey);

    @InheritInverseConfiguration
    PoprKey poprKeyFromHibernate(HibernatePoprKey hibernatePoprKey);

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
    @Mapping(target = "profile", ignore = true)
    @Mapping(target = "poprs", ignore = true)
    @Mapping(target = "poces", ignore = true)
    @Mapping(target = "objectNicknames", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "avatarInfo", ignore = true)
    HibernateUser userToHibernate(User user);

    @InheritInverseConfiguration
    User userFromHibernate(HibernateUser hibernateUser);
}
