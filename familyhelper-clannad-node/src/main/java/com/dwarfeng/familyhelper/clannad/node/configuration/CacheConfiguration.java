package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.sdk.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter.NicknameStringKeyFormatter;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter.PoprStringKeyFormatter;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.formatter.ProfileTypeIndicatorStringKeyFormatter;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.*;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.key.ProfileTypeIndicatorKey;
import com.dwarfeng.subgrade.impl.bean.DozerBeanTransformer;
import com.dwarfeng.subgrade.impl.cache.RedisBatchBaseCache;
import com.dwarfeng.subgrade.sdk.redis.formatter.LongIdStringKeyFormatter;
import com.dwarfeng.subgrade.sdk.redis.formatter.StringIdStringKeyFormatter;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class CacheConfiguration {

    private final RedisTemplate<String, ?> template;
    private final Mapper mapper;

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

    public CacheConfiguration(RedisTemplate<String, ?> template, Mapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, Profile, FastJsonProfile> profileRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonProfile>) template,
                new StringIdStringKeyFormatter(profilePrefix),
                new DozerBeanTransformer<>(Profile.class, FastJsonProfile.class, mapper)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, User, FastJsonUser> userRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonUser>) template,
                new StringIdStringKeyFormatter(userPrefix),
                new DozerBeanTransformer<>(User.class, FastJsonUser.class, mapper)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<ProfileTypeIndicatorKey, ProfileTypeIndicator, FastJsonProfileTypeIndicator>
    profileTypeIndicatorRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonProfileTypeIndicator>) template,
                new ProfileTypeIndicatorStringKeyFormatter(profileTypeIndicatorPrefix),
                new DozerBeanTransformer<>(ProfileTypeIndicator.class, FastJsonProfileTypeIndicator.class, mapper)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<PoprKey, Popr, FastJsonPopr> poprRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonPopr>) template,
                new PoprStringKeyFormatter(poprPrefix),
                new DozerBeanTransformer<>(Popr.class, FastJsonPopr.class, mapper)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<NicknameKey, Nickname, FastJsonNickname> nicknameRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonNickname>) template,
                new NicknameStringKeyFormatter(nicknamePrefix),
                new DozerBeanTransformer<>(Nickname.class, FastJsonNickname.class, mapper)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<StringIdKey, AvatarInfo, FastJsonAvatarInfo> avatarInfoRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonAvatarInfo>) template,
                new StringIdStringKeyFormatter(avatarInfoPrefix),
                new DozerBeanTransformer<>(AvatarInfo.class, FastJsonAvatarInfo.class, mapper)
        );
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, Notification, FastJsonNotification> notificationRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonNotification>) template,
                new LongIdStringKeyFormatter(notificationPrefix),
                new DozerBeanTransformer<>(Notification.class, FastJsonNotification.class, mapper)
        );
    }
}
