package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.impl.service.operation.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.familyhelper.clannad.stack.cache.*;
import com.dwarfeng.familyhelper.clannad.stack.dao.*;
import com.dwarfeng.subgrade.impl.generation.ExceptionKeyGenerator;
import com.dwarfeng.subgrade.impl.service.CustomBatchCrudService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyEntireLookupService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyPresetLookupService;
import com.dwarfeng.subgrade.impl.service.GeneralBatchCrudService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;
    private final GenerateConfiguration generateConfiguration;

    private final ProfileDao profileDao;
    private final ProfileCrudOperation profileCrudOperation;
    private final UserCrudOperation userCrudOperation;
    private final ProfileTypeIndicatorDao profileTypeIndicatorDao;
    private final ProfileTypeIndicatorCache profileTypeIndicatorCache;
    private final PoprDao poprDao;
    private final PoprCache poprCache;
    private final NicknameDao nicknameDao;
    private final NicknameCache nicknameCache;
    private final AvatarInfoCrudOperation avatarInfoCrudOperation;
    private final NotificationDao notificationDao;
    private final NotificationCache notificationCache;
    private final CertificateCrudOperation certificateCrudOperation;
    private final CertificateDao certificateDao;
    private final CertificateFileInfoCrudOperation certificateFileInfoCrudOperation;
    private final CertificateFileInfoDao certificateFileInfoDao;
    private final PoceDao poceDao;
    private final PoceCache poceCache;

    @Value("${cache.timeout.entity.profile_type_indicator}")
    private long profileTypeIndicatorTimeout;
    @Value("${cache.timeout.entity.popr}")
    private long poprTimeout;
    @Value("${cache.timeout.entity.nickname}")
    private long nicknameTimeout;
    @Value("${cache.timeout.entity.notification}")
    private long notificationTimeout;
    @Value("${cache.timeout.entity.poce}")
    private long poceTimeout;

    public ServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            GenerateConfiguration generateConfiguration,
            ProfileDao profileDao,
            ProfileCrudOperation profileCrudOperation,
            UserCrudOperation userCrudOperation,
            ProfileTypeIndicatorDao profileTypeIndicatorDao,
            ProfileTypeIndicatorCache profileTypeIndicatorCache,
            PoprDao poprDao,
            PoprCache poprCache,
            NicknameDao nicknameDao,
            NicknameCache nicknameCache,
            AvatarInfoCrudOperation avatarInfoCrudOperation,
            NotificationDao notificationDao,
            NotificationCache notificationCache,
            CertificateCrudOperation certificateCrudOperation,
            CertificateDao certificateDao,
            CertificateFileInfoCrudOperation certificateFileInfoCrudOperation,
            CertificateFileInfoDao certificateFileInfoDao,
            PoceDao poceDao,
            PoceCache poceCache
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.generateConfiguration = generateConfiguration;
        this.profileDao = profileDao;
        this.profileCrudOperation = profileCrudOperation;
        this.userCrudOperation = userCrudOperation;
        this.profileTypeIndicatorDao = profileTypeIndicatorDao;
        this.profileTypeIndicatorCache = profileTypeIndicatorCache;
        this.poprDao = poprDao;
        this.poprCache = poprCache;
        this.nicknameDao = nicknameDao;
        this.nicknameCache = nicknameCache;
        this.avatarInfoCrudOperation = avatarInfoCrudOperation;
        this.notificationDao = notificationDao;
        this.notificationCache = notificationCache;
        this.certificateCrudOperation = certificateCrudOperation;
        this.certificateDao = certificateDao;
        this.certificateFileInfoCrudOperation = certificateFileInfoCrudOperation;
        this.certificateFileInfoDao = certificateFileInfoDao;
        this.poceDao = poceDao;
        this.poceCache = poceCache;
    }

    @Bean
    public CustomBatchCrudService<StringIdKey, Profile> profileBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Profile> profileDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileDao
        );
    }

    @Bean
    public CustomBatchCrudService<StringIdKey, User> userBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                userCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean
    public GeneralBatchCrudService<ProfileTypeIndicatorKey, ProfileTypeIndicator>
    profileTypeIndicatorGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileTypeIndicatorDao,
                profileTypeIndicatorCache,
                new ExceptionKeyGenerator<>(),
                profileTypeIndicatorTimeout
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<ProfileTypeIndicator>
    profileTypeIndicatorDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                profileTypeIndicatorDao
        );
    }

    @Bean
    public GeneralBatchCrudService<PoprKey, Popr> poprGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poprDao,
                poprCache,
                new ExceptionKeyGenerator<>(),
                poprTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Popr> poprDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poprDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Popr> poprDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poprDao
        );
    }

    @Bean
    public GeneralBatchCrudService<NicknameKey, Nickname> nicknameGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                nicknameDao,
                nicknameCache,
                new ExceptionKeyGenerator<>(),
                nicknameTimeout
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Nickname> nicknameDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                nicknameDao
        );
    }

    @Bean
    public CustomBatchCrudService<StringIdKey, AvatarInfo> avatarInfoBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                avatarInfoCrudOperation,
                new ExceptionKeyGenerator<>()
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, Notification> notificationGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notificationDao,
                notificationCache,
                generateConfiguration.snowflakeLongIdKeyGenerator(),
                notificationTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Notification> notificationDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notificationDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Notification> notificationDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notificationDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, Certificate> certificateBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                certificateCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Certificate> certificateDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                certificateDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Certificate> certificateDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                certificateDao
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, CertificateFileInfo> certificateFileInfoBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                certificateFileInfoCrudOperation,
                generateConfiguration.snowflakeLongIdKeyGenerator()
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<CertificateFileInfo> certificateFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                certificateFileInfoDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<CertificateFileInfo> certificateFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                certificateFileInfoDao
        );
    }

    @Bean
    public GeneralBatchCrudService<PoceKey, Poce> poceGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poceDao,
                poceCache,
                new ExceptionKeyGenerator<>(),
                poceTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poce> poceDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poceDao
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poce> poceDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poceDao
        );
    }
}
