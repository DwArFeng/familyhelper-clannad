package com.dwarfeng.familyhelper.clannad.sdk.util;

import com.dwarfeng.subgrade.stack.exception.ServiceException;

/**
 * 服务异常代码。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public final class ServiceExceptionCodes {

    private static int EXCEPTION_CODE_OFFSET = 10000;

    public static final ServiceException.Code PROFILE_NOT_EXISTS =
            new ServiceException.Code(offset(0), "profile not exists");
    public static final ServiceException.Code USER_NOT_EXISTS =
            new ServiceException.Code(offset(10), "user not exists");
    public static final ServiceException.Code AVATAR_NOT_EXISTS =
            new ServiceException.Code(offset(20), "avatar not exists");
    public static final ServiceException.Code NOTIFICATION_NOT_EXISTS =
            new ServiceException.Code(offset(30), "notification not exists");
    public static final ServiceException.Code CERTIFICATE_NOT_EXISTS =
            new ServiceException.Code(offset(40), "certificate not exists");
    public static final ServiceException.Code CERTIFICATE_FILE_NOT_EXISTS =
            new ServiceException.Code(offset(50), "certificate file not exists");
    public static final ServiceException.Code INVALID_PERMISSION_LEVEL =
            new ServiceException.Code(offset(60), "invalid permission level");
    public static final ServiceException.Code USER_NOT_PERMITTED_FOR_CERTIFICATE =
            new ServiceException.Code(offset(70), "user not permitted for certificate");
    public static final ServiceException.Code MESSAGE_ATTACHMENT_NOT_EXISTS =
            new ServiceException.Code(offset(80), "message attachment not exists");
    public static final ServiceException.Code MESSAGE_BODY_NOT_EXISTS =
            new ServiceException.Code(offset(90), "message body not exists");
    public static final ServiceException.Code MESSAGE_NOT_EXISTS =
            new ServiceException.Code(offset(100), "message not exists");
    public static final ServiceException.Code MESSAGE_STATUS_MISMATCH =
            new ServiceException.Code(offset(110), "message status mismatch");
    public static final ServiceException.Code MESSAGE_UNAUTHORIZED_TO_SEND =
            new ServiceException.Code(offset(120), "message unauthorized to send");
    public static final ServiceException.Code USER_MISMATCH =
            new ServiceException.Code(offset(130), "user mismatch");
    public static final ServiceException.Code MESSAGE_AUTHORIZATION_EXISTS =
            new ServiceException.Code(offset(140), "message authorization exists");
    public static final ServiceException.Code MESSAGE_AUTHORIZATION_NOT_EXISTS =
            new ServiceException.Code(offset(150), "message authorization not exists");

    private static int offset(int i) {
        return EXCEPTION_CODE_OFFSET + i;
    }

    /**
     * 获取异常代号的偏移量。
     *
     * @return 异常代号的偏移量。
     */
    public static int getExceptionCodeOffset() {
        return EXCEPTION_CODE_OFFSET;
    }

    /**
     * 设置异常代号的偏移量。
     *
     * @param exceptionCodeOffset 指定的异常代号的偏移量。
     */
    public static void setExceptionCodeOffset(int exceptionCodeOffset) {
        // 设置 EXCEPTION_CODE_OFFSET 的值。
        EXCEPTION_CODE_OFFSET = exceptionCodeOffset;

        // 以新的 EXCEPTION_CODE_OFFSET 为基准，更新异常代码的值。
        PROFILE_NOT_EXISTS.setCode(offset(0));
        USER_NOT_EXISTS.setCode(offset(10));
        AVATAR_NOT_EXISTS.setCode(offset(20));
        NOTIFICATION_NOT_EXISTS.setCode(offset(30));
        CERTIFICATE_NOT_EXISTS.setCode(offset(40));
        CERTIFICATE_FILE_NOT_EXISTS.setCode(offset(50));
        INVALID_PERMISSION_LEVEL.setCode(offset(60));
        USER_NOT_PERMITTED_FOR_CERTIFICATE.setCode(offset(70));
        MESSAGE_ATTACHMENT_NOT_EXISTS.setCode(offset(80));
        MESSAGE_BODY_NOT_EXISTS.setCode(offset(90));
        MESSAGE_NOT_EXISTS.setCode(offset(100));
        MESSAGE_STATUS_MISMATCH.setCode(offset(110));
        MESSAGE_UNAUTHORIZED_TO_SEND.setCode(offset(120));
        USER_MISMATCH.setCode(offset(130));
        MESSAGE_AUTHORIZATION_EXISTS.setCode(offset(140));
        MESSAGE_AUTHORIZATION_NOT_EXISTS.setCode(offset(150));
    }

    private ServiceExceptionCodes() {
        throw new IllegalStateException("禁止实例化");
    }
}
