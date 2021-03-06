package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.sdk.util.ServiceExceptionCodes;
import com.dwarfeng.familyhelper.clannad.stack.exception.AvatarNotExistsException;
import com.dwarfeng.familyhelper.clannad.stack.exception.NotificationNotExistsException;
import com.dwarfeng.familyhelper.clannad.stack.exception.ProfileNotExistsException;
import com.dwarfeng.familyhelper.clannad.stack.exception.UserNotExistsException;
import com.dwarfeng.subgrade.impl.exception.MapServiceExceptionMapper;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ServiceExceptionMapperConfiguration {

    @Bean
    public MapServiceExceptionMapper mapServiceExceptionMapper() {
        Map<Class<? extends Exception>, ServiceException.Code> destination = ServiceExceptionHelper.putDefaultDestination(null);
        destination = com.dwarfeng.ftp.util.ServiceExceptionHelper.putDefaultDestination(destination);
        destination.put(ProfileNotExistsException.class, ServiceExceptionCodes.PROFILE_NOT_EXISTS);
        destination.put(UserNotExistsException.class, ServiceExceptionCodes.USER_NOT_EXISTS);
        destination.put(AvatarNotExistsException.class, ServiceExceptionCodes.AVATAR_NOT_EXISTS);
        destination.put(NotificationNotExistsException.class, ServiceExceptionCodes.NOTIFICATION_NOT_EXISTS);
        return new MapServiceExceptionMapper(destination, com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes.UNDEFINE);
    }
}
