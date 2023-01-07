package com.dwarfeng.familyhelper.clannad.node.configuration;

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
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class DaoConfiguration {

    private final HibernateTemplate template;

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
            ProfileTypeIndicatorPresetCriteriaMaker profileTypeIndicatorPresetCriteriaMaker,
            PoprPresetCriteriaMaker poprPresetCriteriaMaker,
            NicknamePresetCriteriaMaker nicknamePresetCriteriaMaker,
            NotificationPresetCriteriaMaker notificationPresetCriteriaMaker,
            CertificatePresetCriteriaMaker certificatePresetCriteriaMaker,
            CertificateFileInfoPresetCriteriaMaker certificateFileInfoPresetCriteriaMaker,
            PocePresetCriteriaMaker pocePresetCriteriaMaker
    ) {
        this.template = template;
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
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(Profile.class, HibernateProfile.class, HibernateMapper.class),
                HibernateProfile.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Profile, HibernateProfile> profileHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        Profile.class, HibernateProfile.class, HibernateMapper.class
                ),
                HibernateProfile.class
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, User, HibernateUser> userHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, HibernateMapper.class),
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
                new MapStructBeanTransformer<>(
                        ProfileTypeIndicatorKey.class, HibernateProfileTypeIndicatorKey.class, HibernateMapper.class
                ),
                new MapStructBeanTransformer<>(
                        ProfileTypeIndicator.class, HibernateProfileTypeIndicator.class, HibernateMapper.class
                ),
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
                new MapStructBeanTransformer<>(
                        ProfileTypeIndicator.class, HibernateProfileTypeIndicator.class, HibernateMapper.class
                ),
                HibernateProfileTypeIndicator.class,
                profileTypeIndicatorPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoprKey, HibernatePoprKey, Popr, HibernatePopr> poprHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoprKey.class, HibernatePoprKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(Popr.class, HibernatePopr.class, HibernateMapper.class),
                HibernatePopr.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Popr, HibernatePopr> poprHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Popr.class, HibernatePopr.class, HibernateMapper.class),
                HibernatePopr.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Popr, HibernatePopr> poprHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Popr.class, HibernatePopr.class, HibernateMapper.class),
                HibernatePopr.class,
                poprPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<NicknameKey, HibernateNicknameKey, Nickname, HibernateNickname>
    nicknameHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(NicknameKey.class, HibernateNicknameKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(Nickname.class, HibernateNickname.class, HibernateMapper.class),
                HibernateNickname.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernatePresetLookupDao<Nickname, HibernateNickname> nicknameHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Nickname.class, HibernateNickname.class, HibernateMapper.class),
                HibernateNickname.class,
                nicknamePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, AvatarInfo, HibernateAvatarInfo>
    avatarInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, HibernateMapper.class),
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
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, HibernateMapper.class),
                HibernateNotification.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Notification, HibernateNotification> notificationHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, HibernateMapper.class),
                HibernateNotification.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Notification, HibernateNotification> notificationHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, HibernateMapper.class),
                HibernateNotification.class,
                notificationPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Certificate, HibernateCertificate>
    certificateHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(Certificate.class, HibernateCertificate.class, HibernateMapper.class),
                HibernateCertificate.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Certificate, HibernateCertificate> certificateHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Certificate.class, HibernateCertificate.class, HibernateMapper.class),
                HibernateCertificate.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Certificate, HibernateCertificate> certificateHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Certificate.class, HibernateCertificate.class, HibernateMapper.class),
                HibernateCertificate.class,
                certificatePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, CertificateFileInfo, HibernateCertificateFileInfo>
    certificateFileInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(
                        CertificateFileInfo.class, HibernateCertificateFileInfo.class, HibernateMapper.class
                ),
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
                new MapStructBeanTransformer<>(
                        CertificateFileInfo.class, HibernateCertificateFileInfo.class, HibernateMapper.class
                ),
                HibernateCertificateFileInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<CertificateFileInfo, HibernateCertificateFileInfo>
    certificateFileInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(
                        CertificateFileInfo.class, HibernateCertificateFileInfo.class, HibernateMapper.class
                ),
                HibernateCertificateFileInfo.class,
                certificateFileInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<PoceKey, HibernatePoceKey, Poce, HibernatePoce> poceHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(PoceKey.class, HibernatePoceKey.class, HibernateMapper.class),
                new MapStructBeanTransformer<>(Poce.class, HibernatePoce.class, HibernateMapper.class),
                HibernatePoce.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Poce, HibernatePoce> poceHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poce.class, HibernatePoce.class, HibernateMapper.class),
                HibernatePoce.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Poce, HibernatePoce> poceHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Poce.class, HibernatePoce.class, HibernateMapper.class),
                HibernatePoce.class,
                pocePresetCriteriaMaker
        );
    }
}
