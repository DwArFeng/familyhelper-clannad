package com.dwarfeng.familyhelper.clannad.node.configuration;

import com.dwarfeng.familyhelper.clannad.sdk.util.ServiceExceptionCodes;
import com.dwarfeng.familyhelper.clannad.stack.exception.*;
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
        destination.put(CertificateNotExistsException.class, ServiceExceptionCodes.CERTIFICATE_NOT_EXISTS);
        destination.put(CertificateFileNotExistsException.class, ServiceExceptionCodes.CERTIFICATE_FILE_NOT_EXISTS);
        destination.put(InvalidPermissionLevelException.class, ServiceExceptionCodes.INVALID_PERMISSION_LEVEL);
        destination.put(UserNotPermittedForCertificateException.class, ServiceExceptionCodes.USER_NOT_PERMITTED_FOR_CERTIFICATE);
        destination.put(MessageAttachmentNotExistsException.class, ServiceExceptionCodes.MESSAGE_ATTACHMENT_NOT_EXISTS);
        destination.put(MessageBodyNotExistsException.class, ServiceExceptionCodes.MESSAGE_BODY_NOT_EXISTS);
        destination.put(MessageNotExistsException.class, ServiceExceptionCodes.MESSAGE_NOT_EXISTS);
        destination.put(MessageStatusMismatchException.class, ServiceExceptionCodes.MESSAGE_STATUS_MISMATCH);
        destination.put(MessageUnauthorizedToSendException.class, ServiceExceptionCodes.MESSAGE_UNAUTHORIZED_TO_SEND);
        destination.put(UserMismatchException.class, ServiceExceptionCodes.USER_MISMATCH);
        destination.put(MessageAuthorizationExistsException.class, ServiceExceptionCodes.MESSAGE_AUTHORIZATION_EXISTS);
        destination.put(MessageAuthorizationNotExistsException.class, ServiceExceptionCodes.MESSAGE_AUTHORIZATION_NOT_EXISTS);
        return new MapServiceExceptionMapper(destination, com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes.UNDEFINED);
    }
}
