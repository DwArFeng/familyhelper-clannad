package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.impl.service.operation.ProfileCrudOperation;
import com.dwarfeng.familyhelper.clannad.impl.service.operation.UserCrudOperation;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.NicknameCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.PoprCache;
import com.dwarfeng.familyhelper.clannad.stack.cache.ProfileTypeIndicatorCache;
import com.dwarfeng.familyhelper.clannad.stack.dao.NicknameDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.PoprDao;
import com.dwarfeng.familyhelper.clannad.stack.dao.ProfileTypeIndicatorDao;
import com.dwarfeng.sfds.api.integration.subgrade.SnowFlakeLongIdKeyFetcher;
import com.dwarfeng.subgrade.impl.bean.key.ExceptionKeyFetcher;
import com.dwarfeng.subgrade.impl.service.CustomBatchCrudService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyEntireLookupService;
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

    private final ProfileCrudOperation profileCrudOperation;
    private final UserCrudOperation userCrudOperation;
    private final ProfileTypeIndicatorDao profileTypeIndicatorDao;
    private final ProfileTypeIndicatorCache profileTypeIndicatorCache;
    private final PoprDao poprDao;
    private final PoprCache poprCache;
    private final NicknameDao nicknameDao;
    private final NicknameCache nicknameCache;

    @Value("${cache.timeout.entity.profile_type_indicator}")
    private long profileTypeIndicatorTimeout;
    @Value("${cache.timeout.entity.popr}")
    private long poprTimeout;
    @Value("${cache.timeout.entity.nickname}")
    private long nicknameTimeout;

    public ServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            ProfileCrudOperation profileCrudOperation,
            UserCrudOperation userCrudOperation,
            ProfileTypeIndicatorDao profileTypeIndicatorDao,
            ProfileTypeIndicatorCache profileTypeIndicatorCache,
            PoprDao poprDao, PoprCache poprCache,
            NicknameDao nicknameDao, NicknameCache nicknameCache
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.profileCrudOperation = profileCrudOperation;
        this.userCrudOperation = userCrudOperation;
        this.profileTypeIndicatorDao = profileTypeIndicatorDao;
        this.profileTypeIndicatorCache = profileTypeIndicatorCache;
        this.poprDao = poprDao;
        this.poprCache = poprCache;
        this.nicknameDao = nicknameDao;
        this.nicknameCache = nicknameCache;
    }

    @Bean
    public KeyFetcher<LongIdKey> longIdKeyKeyFetcher() {
        return new SnowFlakeLongIdKeyFetcher();
    }

    @Bean
    public CustomBatchCrudService<StringIdKey, Profile> profileBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                profileCrudOperation,
                new ExceptionKeyFetcher<>(),
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

    @Bean
    public GeneralBatchCrudService<PoprKey, Popr> poprGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                poprDao,
                poprCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poprTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Popr> poprDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                poprDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Popr> poprDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                poprDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<NicknameKey, Nickname> nicknameGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                nicknameDao,
                nicknameCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                nicknameTimeout
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Nickname> nicknameDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                nicknameDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }
}
