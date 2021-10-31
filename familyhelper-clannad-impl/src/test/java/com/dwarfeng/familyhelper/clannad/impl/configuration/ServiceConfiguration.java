package com.dwarfeng.familyhelper.clannad.impl.configuration;

import com.dwarfeng.familyhelper.clannad.impl.service.operation.UserCrudOperation;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.ProfileTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.ProfileCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.ProfileTypeIndicatorCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.ProfileDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.ProfileTypeIndicatorDao;
import com.dwarfeng.sfds.api.integration.subgrade.SnowFlakeLongIdKeyFetcher;
import com.dwarfeng.subgrade.impl.bean.key.ExceptionKeyFetcher;
import com.dwarfeng.subgrade.impl.service.CustomBatchCrudService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyPresetLookupService;
import com.dwarfeng.subgrade.impl.service.GeneralBatchCrudService;
import com.dwarfeng.subgrade.stack.bean.key.KeyFetcher;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;

    private final ProfileDao profileDao;
    private final ProfileCache profileCache;
    private final UserCrudOperation userCrudOperation;
    private final ProfileTypeIndicatorDao profileTypeIndicatorDao;
    private final ProfileTypeIndicatorCache profileTypeIndicatorCache;

    @Value("${cache.timeout.entity.profile}")
    private long profileTimeout;
    @Value("${cache.timeout.entity.profile_type_indicator}")
    private long profileTypeIndicatorTimeout;

    public ServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            ProfileDao profileDao,
            ProfileCache profileCache,
            UserCrudOperation userCrudOperation,
            ProfileTypeIndicatorDao profileTypeIndicatorDao,
            ProfileTypeIndicatorCache profileTypeIndicatorCache
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.profileDao = profileDao;
        this.profileCache = profileCache;
        this.userCrudOperation = userCrudOperation;
        this.profileTypeIndicatorDao = profileTypeIndicatorDao;
        this.profileTypeIndicatorCache = profileTypeIndicatorCache;
    }

    @Bean
    public KeyFetcher<LongIdKey> longIdKeyKeyFetcher() {
        return new SnowFlakeLongIdKeyFetcher();
    }

    @Bean
    public GeneralBatchCrudService<StringIdKey, Profile> profileGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                profileDao,
                profileCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileTimeout
        );
    }

    @Bean
    public CustomBatchCrudService<StringIdKey, User> userBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                userCrudOperation,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<ProfileTypeIndicatorKey, ProfileTypeIndicator>
    profileTypeIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                profileTypeIndicatorDao,
                profileTypeIndicatorCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileTypeIndicatorTimeout
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ProfileTypeIndicator>
    profileTypeIndicatorDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                profileTypeIndicatorDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }
}
