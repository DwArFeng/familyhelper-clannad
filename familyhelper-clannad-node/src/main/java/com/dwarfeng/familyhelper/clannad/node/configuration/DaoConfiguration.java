package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.impl.bean.entity.HibernateProfile;
import com.dwarfeng.familyhelper.clannad.impl.bean.entity.HibernateProfileTypeIndicator;
import com.dwarfeng.familyhelper.clannad.impl.bean.entity.HibernateUser;
import com.dwarfeng.familyhelper.clannad.impl.bean.key.HibernateProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.impl.dao.preset.ProfileTypeIndicatorPresetCriteriaMaker;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.impl.bean.DozerBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
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

    @Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    public DaoConfiguration(
            HibernateTemplate template,
            Mapper mapper,
            ProfileTypeIndicatorPresetCriteriaMaker profileTypeIndicatorPresetCriteriaMaker
    ) {
        this.template = template;
        this.mapper = mapper;
        this.profileTypeIndicatorPresetCriteriaMaker = profileTypeIndicatorPresetCriteriaMaker;
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
}
