package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.impl.service.operation.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.*;
import com.dwarfeng.familyhelper.clannad.stack.cache.*;
import com.dwarfeng.familyhelper.clannad.stack.dao.*;
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
    private final AvatarInfoCrudOperation avatarInfoCrudOperation;
    private final NotificationDao notificationDao;
    private final NotificationCache notificationCache;
    private final CertificateCrudOperation certificateCrudOperation;
    private final CertificateDao certificateDao;
    private final CertificateFileInfoCrudOperation certificateFileInfoCrudOperation;
    private final CertificateFileInfoDao certificateFileInfoDao;
    private final PoceDao poceDao;
    private final PoceCache poceCache;
    private final NotifySettingCrudOperation notifySettingCrudOperation;
    private final NotifySettingDao notifySettingDao;
    private final NotifyTopicCrudOperation notifyTopicCrudOperation;
    private final NotifyTopicDao notifyTopicDao;
    private final NotifyPreferenceDao notifyPreferenceDao;
    private final NotifyPreferenceCache notifyPreferenceCache;
    private final NotifyMetaDao notifyMetaDao;
    private final NotifyMetaCache notifyMetaCache;

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
    @Value("${cache.timeout.entity.notify_preference}")
    private long notifyPreferenceTimeout;
    @Value("${cache.timeout.entity.notify_meta}")
    private long notifyMetaTimeout;

    public ServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            ProfileCrudOperation profileCrudOperation,
            UserCrudOperation userCrudOperation,
            ProfileTypeIndicatorDao profileTypeIndicatorDao,
            ProfileTypeIndicatorCache profileTypeIndicatorCache,
            PoprDao poprDao, PoprCache poprCache,
            NicknameDao nicknameDao, NicknameCache nicknameCache,
            AvatarInfoCrudOperation avatarInfoCrudOperation,
            NotificationDao notificationDao, NotificationCache notificationCache,
            CertificateCrudOperation certificateCrudOperation, CertificateDao certificateDao,
            CertificateFileInfoCrudOperation certificateFileInfoCrudOperation, CertificateFileInfoDao certificateFileInfoDao,
            PoceDao poceDao, PoceCache poceCache,
            NotifySettingCrudOperation notifySettingCrudOperation, NotifySettingDao notifySettingDao,
            NotifyTopicCrudOperation notifyTopicCrudOperation, NotifyTopicDao notifyTopicDao,
            NotifyPreferenceDao notifyPreferenceDao, NotifyPreferenceCache notifyPreferenceCache,
            NotifyMetaDao notifyMetaDao, NotifyMetaCache notifyMetaCache
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
        this.avatarInfoCrudOperation = avatarInfoCrudOperation;
        this.notificationDao = notificationDao;
        this.notificationCache = notificationCache;
        this.certificateCrudOperation = certificateCrudOperation;
        this.certificateDao = certificateDao;
        this.certificateFileInfoCrudOperation = certificateFileInfoCrudOperation;
        this.certificateFileInfoDao = certificateFileInfoDao;
        this.poceDao = poceDao;
        this.poceCache = poceCache;
        this.notifySettingCrudOperation = notifySettingCrudOperation;
        this.notifySettingDao = notifySettingDao;
        this.notifyTopicCrudOperation = notifyTopicCrudOperation;
        this.notifyTopicDao = notifyTopicDao;
        this.notifyPreferenceDao = notifyPreferenceDao;
        this.notifyPreferenceCache = notifyPreferenceCache;
        this.notifyMetaDao = notifyMetaDao;
        this.notifyMetaCache = notifyMetaCache;
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

    @Bean
    public CustomBatchCrudService<StringIdKey, AvatarInfo> avatarInfoBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                avatarInfoCrudOperation,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<LongIdKey, Notification> notificationGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                notificationDao,
                notificationCache,
                longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notificationTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Notification> notificationDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                notificationDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Notification> notificationDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                notificationDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, Certificate> certificateBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                certificateCrudOperation,
                longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Certificate> certificateDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                certificateDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Certificate> certificateDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                certificateDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, CertificateFileInfo> certificateFileInfoBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                certificateFileInfoCrudOperation,
                longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<CertificateFileInfo> certificateFileInfoDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                certificateFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<CertificateFileInfo> certificateFileInfoDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                certificateFileInfoDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<PoceKey, Poce> poceGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                poceDao,
                poceCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                poceTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Poce> poceDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                poceDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<Poce> poceDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                poceDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, NotifySetting> notifySettingCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                notifySettingCrudOperation,
                longIdKeyKeyFetcher(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<NotifySetting> notifySettingDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                notifySettingDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public CustomBatchCrudService<StringIdKey, NotifyTopic> notifyTopicCustomBatchCrudService() {
        return new CustomBatchCrudService<>(
                notifyTopicCrudOperation,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<NotifyTopic> notifyTopicDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                notifyTopicDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<NotifyNodeKey, NotifyPreference> notifyPreferenceGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                notifyPreferenceDao,
                notifyPreferenceCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyPreferenceTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<NotifyPreference> notifyPreferenceDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                notifyPreferenceDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<NotifyPreference> notifyPreferenceDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                notifyPreferenceDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public GeneralBatchCrudService<NotifyNodeKey, NotifyMeta> notifyMetaGeneralBatchCrudService() {
        return new GeneralBatchCrudService<>(
                notifyMetaDao,
                notifyMetaCache,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN,
                notifyMetaTimeout
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<NotifyMeta> notifyMetaDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                notifyMetaDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyPresetLookupService<NotifyMeta> notifyMetaDaoOnlyPresetLookupService() {
        return new DaoOnlyPresetLookupService<>(
                notifyMetaDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }
}
