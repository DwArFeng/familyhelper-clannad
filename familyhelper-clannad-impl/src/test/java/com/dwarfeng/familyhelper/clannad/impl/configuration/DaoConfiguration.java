package com.dwarfeng.familyhelper.clannad.impl.configuration;

import com.dwarfeng.familyhelper.clannad.impl.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateNicknameKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernatePoceKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernatePoprKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.impl.dao.preset.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.impl.bean.DozerBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class DaoConfiguration {

    private final HibernateTemplate template;
    private final Mapper mapper;

    private final ProfileTypeIndicatorPresetCriteriaMaker profileTypeIndicatorPresetCriteriaMaker;
    private final PoprPresetCriteriaMaker poprPresetCriteriaMaker;
    private final NicknamePresetCriteriaMaker nicknamePresetCriteriaMaker;
    private final NotificationPresetCriteriaMaker notificationPresetCriteriaMaker;
    private final CertificatePresetCriteriaMaker certificatePresetCriteriaMaker;
    private final CertificateFileInfoPresetCriteriaMaker certificateFileInfoPresetCriteriaMaker;
    private final PocePresetCriteriaMaker pocePresetCriteriaMaker;

    @Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    public DaoConfiguration(
            HibernateTemplate template,
            Mapper mapper,
            ProfileTypeIndicatorPresetCriteriaMaker profileTypeIndicatorPresetCriteriaMaker,
            PoprPresetCriteriaMaker poprPresetCriteriaMaker,
            NicknamePresetCriteriaMaker nicknamePresetCriteriaMaker,
            NotificationPresetCriteriaMaker notificationPresetCriteriaMaker,
            CertificatePresetCriteriaMaker certificatePresetCriteriaMaker,
            CertificateFileInfoPresetCriteriaMaker certificateFileInfoPresetCriteriaMaker,
            PocePresetCriteriaMaker pocePresetCriteriaMaker
    ) {
        this.template = template;
        this.mapper = mapper;
        this.profileTypeIndicatorPresetCriteriaMaker = profileTypeIndicatorPresetCriteriaMaker;
        this.poprPresetCriteriaMaker = poprPresetCriteriaMaker;
        this.nicknamePresetCriteriaMaker = nicknamePresetCriteriaMaker;
        this.notificationPresetCriteriaMaker = notificationPresetCriteriaMaker;
        this.certificatePresetCriteriaMaker = certificatePresetCriteriaMaker;
        this.certificateFileInfoPresetCriteriaMaker = certificateFileInfoPresetCriteriaMaker;
        this.pocePresetCriteriaMaker = pocePresetCriteriaMaker;
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, Profile, HibernateProfile>
    profileHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, mapper),
                new DozerBeanTransformer<>(Profile.class, HibernateProfile.class, mapper),
                HibernateProfile.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, User, HibernateUser> userHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, mapper),
                new DozerBeanTransformer<>(User.class, HibernateUser.class, mapper),
                HibernateUser.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateBatchBaseDao<ProfileTypeIndicatorKey, HibernateProfileTypeIndicatorKey, ProfileTypeIndicator,
            HibernateProfileTypeIndicator> profileTypeIndicatorHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(ProfileTypeIndicatorKey.class, HibernateProfileTypeIndicatorKey.class, mapper),
                new DozerBeanTransformer<>(ProfileTypeIndicator.class, HibernateProfileTypeIndicator.class, mapper),
                HibernateProfileTypeIndicator.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernatePresetLookupDao<ProfileTypeIndicator, HibernateProfileTypeIndicator>
    profileTypeIndicatorHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(ProfileTypeIndicator.class, HibernateProfileTypeIndicator.class, mapper),
                HibernateProfileTypeIndicator.class,
                profileTypeIndicatorPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoprKey, HibernatePoprKey, Popr, HibernatePopr> poprHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(PoprKey.class, HibernatePoprKey.class, mapper),
                new DozerBeanTransformer<>(Popr.class, HibernatePopr.class, mapper),
                HibernatePopr.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Popr, HibernatePopr> poprHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(Popr.class, HibernatePopr.class, mapper),
                HibernatePopr.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Popr, HibernatePopr> poprHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(Popr.class, HibernatePopr.class, mapper),
                HibernatePopr.class,
                poprPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<NicknameKey, HibernateNicknameKey, Nickname, HibernateNickname> nicknameHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(NicknameKey.class, HibernateNicknameKey.class, mapper),
                new DozerBeanTransformer<>(Nickname.class, HibernateNickname.class, mapper),
                HibernateNickname.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernatePresetLookupDao<Nickname, HibernateNickname> nicknameHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(Nickname.class, HibernateNickname.class, mapper),
                HibernateNickname.class,
                nicknamePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, AvatarInfo, HibernateAvatarInfo>
    avatarInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, mapper),
                new DozerBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, mapper),
                HibernateAvatarInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Notification, HibernateNotification>
    notificationHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(Notification.class, HibernateNotification.class, mapper),
                HibernateNotification.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Notification, HibernateNotification> notificationHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(Notification.class, HibernateNotification.class, mapper),
                HibernateNotification.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Notification, HibernateNotification> notificationHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(Notification.class, HibernateNotification.class, mapper),
                HibernateNotification.class,
                notificationPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Certificate, HibernateCertificate>
    certificateHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(Certificate.class, HibernateCertificate.class, mapper),
                HibernateCertificate.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Certificate, HibernateCertificate> certificateHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(Certificate.class, HibernateCertificate.class, mapper),
                HibernateCertificate.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Certificate, HibernateCertificate> certificateHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(Certificate.class, HibernateCertificate.class, mapper),
                HibernateCertificate.class,
                certificatePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, CertificateFileInfo, HibernateCertificateFileInfo>
    certificateFileInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, mapper),
                new DozerBeanTransformer<>(CertificateFileInfo.class, HibernateCertificateFileInfo.class, mapper),
                HibernateCertificateFileInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<CertificateFileInfo, HibernateCertificateFileInfo>
    certificateFileInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(CertificateFileInfo.class, HibernateCertificateFileInfo.class, mapper),
                HibernateCertificateFileInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<CertificateFileInfo, HibernateCertificateFileInfo>
    certificateFileInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(CertificateFileInfo.class, HibernateCertificateFileInfo.class, mapper),
                HibernateCertificateFileInfo.class,
                certificateFileInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoceKey, HibernatePoceKey, Poce, HibernatePoce> poceHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new DozerBeanTransformer<>(PoceKey.class, HibernatePoceKey.class, mapper),
                new DozerBeanTransformer<>(Poce.class, HibernatePoce.class, mapper),
                HibernatePoce.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poce, HibernatePoce> poceHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new DozerBeanTransformer<>(Poce.class, HibernatePoce.class, mapper),
                HibernatePoce.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poce, HibernatePoce> poceHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new DozerBeanTransformer<>(Poce.class, HibernatePoce.class, mapper),
                HibernatePoce.class,
                pocePresetCriteriaMaker
        );
    }
}
