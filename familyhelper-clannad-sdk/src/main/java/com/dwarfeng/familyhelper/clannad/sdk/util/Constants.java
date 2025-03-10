package com.dwarfeng.familyhelper.clannad.sdk.util;

/**
 * 常量类。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public final class Constants {

    public static final int PERMISSION_LEVEL_OWNER = 0;
    public static final int PERMISSION_LEVEL_GUEST = 1;

    public static final int IO_TRANS_BUFFER_SIZE = 4096;

    public static final int MESSAGE_STATUS_EDITING = 0;
    public static final int MESSAGE_STATUS_SENT = 1;
    public static final int MESSAGE_STATUS_RECEIVED = 2;

    private Constants() {
        throw new IllegalStateException("禁止实例化");
    }
}
