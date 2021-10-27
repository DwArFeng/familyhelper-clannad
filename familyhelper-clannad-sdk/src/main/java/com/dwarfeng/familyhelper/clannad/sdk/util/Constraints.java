package com.dwarfeng.familyhelper.clannad.sdk.util;

/**
 * 约束类。
 *
 * @author DwArFeng
 * @since 0.0.1-alpha
 */
public final class Constraints {

    /**
     * 用户主键的长度约束。
     */
    public static final int LENGTH_KEY = 50;

    /**
     * 名称的长度约束。
     */
    public static final int LENGTH_NAME = 20;

    /**
     * 身份证的长度约束。
     */
    public static final int LENGTH_ID_NUMBER = 20;

    /**
     * MOTD的长度约束。
     */
    public static final int LENGTH_MOTD = 200;

    /**
     * 生日的长度约束。
     */
    public static final int LENGTH_BIRTHDAY = 12;

    /**
     * 备注的长度约束。
     */
    public static final int LENGTH_REMARK = 100;

    /**
     * 标签的长度约束。
     */
    public static final int LENGTH_LABEL = 50;

    private Constraints() {
        throw new IllegalStateException("禁止实例化");
    }
}
