package com.dwarfeng.familyhelper.clannad.impl.configuration;

import com.dwarfeng.familyhelper.clannad.impl.service.operation.UserCrudOperation;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.GenderTypeIndicator;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.User;
import com.dwarfeng.familyhelper.clannad.stack.cache.GenderTypeIndicatorCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.ProfileCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.GenderTypeIndicatorDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.ProfileDao;
import com.dwarfeng.sfds.api.integration.subgrade.SnowFlakeLongIdKeyFetcher;
import com.dwarfeng.subgrade.impl.bean.key.ExceptionKeyFetcher;
import com.dwarfeng.subgrade.impl.service.CustomBatchCrudService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyEntireLookupService;
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

    @Bean
    public KeyFetcher<LongIdKey> longIdKeyKeyFetcher() {
        return new SnowFlakeLongIdKeyFetcher();
    }

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;

    private final ProfileDao profileDao;
    private final ProfileCache profileCache;
    private final GenderTypeIndicatorDao genderTypeIndicatorDao;
    private final GenderTypeIndicatorCache genderTypeIndicatorCache;
    private final UserCrudOperation userCrudOperation;

    public ServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            ProfileDao profileDao,
            ProfileCache profileCache,
            GenderTypeIndicatorDao genderTypeIndicatorDao,
            GenderTypeIndicatorCache genderTypeIndicatorCache,
            UserCrudOperation userCrudOperation
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.profileDao = profileDao;
        this.profileCache = profileCache;
        this.genderTypeIndicatorDao = genderTypeIndicatorDao;
        this.genderTypeIndicatorCache = genderTypeIndicatorCache;
        this.userCrudOperation = userCrudOperation;
    }

    @Value("${cache.timeout.entity.profile}")
    private long profileTimeout;
    @Value("${cache.timeout.entity.gender_type_indicator}")
    private long genderTypeIndicatorTimeout;

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
    public GeneralBatchCrudService<StringIdKey, GenderTypeIndicator> genderTypeIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                genderTypeIndicatorDao,
                genderTypeIndicatorCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                genderTypeIndicatorTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<GenderTypeIndicator> genderTypeIndicatorDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                genderTypeIndicatorDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
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
}
