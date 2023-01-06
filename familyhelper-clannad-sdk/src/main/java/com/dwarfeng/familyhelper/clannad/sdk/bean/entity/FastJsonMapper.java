package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonNicknameKey;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonPoceKey;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonPoprKey;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * FastJson Bean 映射器。
 *
 * @author DwArFeng
 * @since 1.2.4
 */
@Mapper
public interface FastJsonMapper {

    FastJsonLongIdKey longIdKeyToFastJson(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromFastJson(FastJsonLongIdKey fastJsonLongIdKey);

    FastJsonStringIdKey stringIdKeyToFastJson(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromFastJson(FastJsonStringIdKey fastJsonStringIdKey);

    FastJsonAvatarInfo avatarInfoToFastJson(AvatarInfo avatarInfo);

    @InheritInverseConfiguration
    AvatarInfo avatarInfoFromFastJson(FastJsonAvatarInfo fastJsonAvatarInfo);

    FastJsonPoceKey poceKeyToFastJson(PoceKey poceKey);

    @InheritInverseConfiguration
    PoceKey poceKeyFromFastJson(FastJsonPoceKey fastJsonPoceKey);

    FastJsonPoce poceToFastJson(Poce poce);

    @InheritInverseConfiguration
    Poce poceFromFastJson(FastJsonPoce fastJsonPoce);

    FastJsonPoprKey poprKeyToFastJson(PoprKey poprKey);

    @InheritInverseConfiguration
    PoprKey poprKeyFromFastJson(FastJsonPoprKey fastJsonPoprKey);

    FastJsonPopr poprToFastJson(Popr popr);

    @InheritInverseConfiguration
    Popr poprFromFastJson(FastJsonPopr fastJsonPopr);

    FastJsonCertificate certificateToFastJson(Certificate certificate);

    @InheritInverseConfiguration
    Certificate certificateFromFastJson(FastJsonCertificate fastJsonCertificate);

    FastJsonCertificateFileInfo certificateFileInfoToFastJson(CertificateFileInfo certificateFileInfo);

    @InheritInverseConfiguration
    CertificateFileInfo certificateFileInfoFromFastJson(FastJsonCertificateFileInfo fastJsonCertificateFileInfo);

    FastJsonNicknameKey nicknameKeyToFastJson(NicknameKey nicknameKey);

    @InheritInverseConfiguration
    NicknameKey nicknameKeyFromFastJson(FastJsonNicknameKey fastJsonNicknameKey);

    FastJsonNickname nicknameToFastJson(Nickname nickname);

    @InheritInverseConfiguration
    Nickname nicknameFromFastJson(FastJsonNickname fastJsonNickname);

    FastJsonNotification notificationToFastJson(Notification notification);

    @InheritInverseConfiguration
    Notification notificationFromFastJson(FastJsonNotification fastJsonNotification);

    FastJsonProfile profileToFastJson(Profile profile);

    @InheritInverseConfiguration
    Profile profileFromFastJson(FastJsonProfile fastJsonProfile);

    FastJsonProfileTypeIndicatorKey profileTypeIndicatorKeyToFastJson(
            ProfileTypeIndicatorKey profileTypeIndicatorKey
    );

    @InheritInverseConfiguration
    ProfileTypeIndicatorKey profileTypeIndicatorKeyFromFastJson(
            FastJsonProfileTypeIndicatorKey fastJsonProfileTypeIndicatorKey
    );

    FastJsonProfileTypeIndicator profileTypeIndicatorToFastJson(ProfileTypeIndicator profileTypeIndicator);

    @InheritInverseConfiguration
    ProfileTypeIndicator profileTypeIndicatorFromFastJson(FastJsonProfileTypeIndicator fastJsonProfileTypeIndicator);

    FastJsonUser userToFastJson(User user);

    @InheritInverseConfiguration
    User userFromFastJson(FastJsonUser fastJsonUser);
}
