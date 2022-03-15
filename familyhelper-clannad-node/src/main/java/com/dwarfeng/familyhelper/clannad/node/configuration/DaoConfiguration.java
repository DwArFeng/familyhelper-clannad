package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.impl.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateNicknameKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernatePoprKey;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.impl.dao.preset.NicknamePresetCriteriaMaker;
import com.dwarfeng.familyhelper.clannad.impl.dao.preset.NotificationPresetCriteriaMaker;
import com.dwarfeng.familyhelper.clannad.impl.dao.preset.PoprPresetCriteriaMaker;
import com.dwarfeng.familyhelper.clannad.impl.dao.preset.ProfileTypeIndicatorPresetCriteriaMaker;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
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

    @Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    public DaoConfiguration(
            HibernateTemplate template,
            Mapper mapper,
            ProfileTypeIndicatorPresetCriteriaMaker profileTypeIndicatorPresetCriteriaMaker,
            PoprPresetCriteriaMaker poprPresetCriteriaMaker,
            NicknamePresetCriteriaMaker nicknamePresetCriteriaMaker,
            NotificationPresetCriteriaMaker notificationPresetCriteriaMaker
    ) {
        this.template = template;
        this.mapper = mapper;
        this.profileTypeIndicatorPresetCriteriaMaker = profileTypeIndicatorPresetCriteriaMaker;
        this.poprPresetCriteriaMaker = poprPresetCriteriaMaker;
        this.nicknamePresetCriteriaMaker = nicknamePresetCriteriaMaker;
        this.notificationPresetCriteriaMaker = notificationPresetCriteriaMaker;
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
}
