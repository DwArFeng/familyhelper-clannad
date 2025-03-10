package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.sdk.bean.FastJsonMapper;
import com.dwarfeng.familyhelper.clannad.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.*;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.cache.RedisBatchBaseCache;
import com.dwarfeng.subgrade.sdk.redis.formatter.LongIdStringKeyFormatter;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringIdStringKeyFormatter;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class CacheConfiguration {

    private final RedisTemplate<String, ?> template;

    @Value("${cache.prefix.entity.profile}")
    private String profilePrefix;
    @Value("${cache.prefix.entity.user}")
    private String userPrefix;
    @Value("${cache.prefix.entity.profile_type_indicator}")
    private String profileTypeIndicatorPrefix;
    @Value("${cache.prefix.entity.popr}")
    private String poprPrefix;
    @Value("${cache.prefix.entity.nickname}")
    private String nicknamePrefix;
    @Value("${cache.prefix.entity.avatar_info}")
    private String avatarInfoPrefix;
    @Value("${cache.prefix.entity.notification}")
    private String notificationPrefix;
    @Value("${cache.prefix.entity.certificate}")
    private String certificatePrefix;
    @Value("${cache.prefix.entity.certificate_file_info}")
    private String certificateFileInfoPrefix;
    @Value("${cache.prefix.entity.poce}")
    private String pocePrefix;
    @Value("${cache.prefix.entity.message}")
    private String messagePrefix;
    @Value("${cache.prefix.entity.message_body_info}")
    private String messageBodyInfoPrefix;
    @Value("${cache.prefix.entity.message_attachment_info}")
    private String messageAttachmentInfoPrefix;
    @Value("${cache.prefix.entity.message_authorization}")
    private String messageAuthorizationPrefix;

    public CacheConfiguration(RedisTemplate<String, ?> template) {
        this.template = template;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, Profile, FastJsonProfile> profileRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonProfile>) template,
                new StringIdStringKeyFormatter(profilePrefix),
                new MapStructBeanTransformer<>(Profile.class, FastJsonProfile.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, User, FastJsonUser> userRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonUser>) template,
                new StringIdStringKeyFormatter(userPrefix),
                new MapStructBeanTransformer<>(User.class, FastJsonUser.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<ProfileTypeIndicatorKey, ProfileTypeIndicator, FastJsonProfileTypeIndicator>
    profileTypeIndicatorRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonProfileTypeIndicator>) template,
                new ProfileTypeIndicatorStringKeyFormatter(profileTypeIndicatorPrefix),
                new MapStructBeanTransformer<>(
                        ProfileTypeIndicator.class, FastJsonProfileTypeIndicator.class, FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PoprKey, Popr, FastJsonPopr> poprRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPopr>) template,
                new PoprStringKeyFormatter(poprPrefix),
                new MapStructBeanTransformer<>(Popr.class, FastJsonPopr.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<NicknameKey, Nickname, FastJsonNickname> nicknameRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonNickname>) template,
                new NicknameStringKeyFormatter(nicknamePrefix),
                new MapStructBeanTransformer<>(Nickname.class, FastJsonNickname.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, AvatarInfo, FastJsonAvatarInfo> avatarInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonAvatarInfo>) template,
                new StringIdStringKeyFormatter(avatarInfoPrefix),
                new MapStructBeanTransformer<>(AvatarInfo.class, FastJsonAvatarInfo.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, Notification, FastJsonNotification> notificationRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonNotification>) template,
                new LongIdStringKeyFormatter(notificationPrefix),
                new MapStructBeanTransformer<>(Notification.class, FastJsonNotification.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, Certificate, FastJsonCertificate> certificateRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonCertificate>) template,
                new LongIdStringKeyFormatter(certificatePrefix),
                new MapStructBeanTransformer<>(Certificate.class, FastJsonCertificate.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, CertificateFileInfo, FastJsonCertificateFileInfo>
    certificateFileInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonCertificateFileInfo>) template,
                new LongIdStringKeyFormatter(certificateFileInfoPrefix),
                new MapStructBeanTransformer<>(
                        CertificateFileInfo.class, FastJsonCertificateFileInfo.class, FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PoceKey, Poce, FastJsonPoce> poceRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPoce>) template,
                new PoceStringKeyFormatter(pocePrefix),
                new MapStructBeanTransformer<>(Poce.class, FastJsonPoce.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, Message, FastJsonMessage> messageRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonMessage>) template,
                new LongIdStringKeyFormatter(messagePrefix),
                new MapStructBeanTransformer<>(Message.class, FastJsonMessage.class, FastJsonMapper.class)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, MessageBodyInfo, FastJsonMessageBodyInfo>
    messageBodyInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonMessageBodyInfo>) template,
                new LongIdStringKeyFormatter(messageBodyInfoPrefix),
                new MapStructBeanTransformer<>(
                        MessageBodyInfo.class, FastJsonMessageBodyInfo.class, FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, MessageAttachmentInfo, FastJsonMessageAttachmentInfo>
    messageAttachmentInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonMessageAttachmentInfo>) template,
                new LongIdStringKeyFormatter(messageAttachmentInfoPrefix),
                new MapStructBeanTransformer<>(
                        MessageAttachmentInfo.class, FastJsonMessageAttachmentInfo.class, FastJsonMapper.class
                )
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<MessageAuthorizationKey, MessageAuthorization, FastJsonMessageAuthorization>
    messageAuthorizationRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonMessageAuthorization>) template,
                new MessageAuthorizationStringKeyFormatter(messageAuthorizationPrefix),
                new MapStructBeanTransformer<>(
                        MessageAuthorization.class, FastJsonMessageAuthorization.class, FastJsonMapper.class
                )
        );
    }
}
