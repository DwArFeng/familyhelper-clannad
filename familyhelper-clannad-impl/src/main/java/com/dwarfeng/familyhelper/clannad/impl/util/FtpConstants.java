package com.dwarfeng.familyhelper.clannad.impl.util;

/**
 * FTP 常量。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public final class FtpConstants {

    public static final String[] PATH_AVATAR = new String[]{"familyhelper-clannad", "avatar"};

    /**
     * @since 1.2.3
     */
    public static final String[] PATH_CERTIFICATE_FILE = new String[]{"familyhelper-clannad", "certificate-file"};

    /**
     * @since 1.4.0
     */
    public static final String[] PATH_CERTIFICATE_THUMBNAIL = new String[]{
            "familyhelper-clannad", "certificate-thumbnail"
    };

    private FtpConstants() {
        throw new IllegalStateException("禁止实例化");
    }
}
