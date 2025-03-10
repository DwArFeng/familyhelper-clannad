package com.dwarfeng.familyhelper.clannad.sdk.util;

/**
 * 约束类。
 *
 * @author DwArFeng
 * @since 0.0.1-alpha
 */
public final class Constraints {

    /**
     * 名称的长度约束。
     */
    public static final int LENGTH_NAME = 20;

    /**
     * MOTD 的长度约束。
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

    /**
     * 主键的长度约束。
     */
    public static final int LENGTH_ID = 50;

    /**
     * 用户主键的长度约束。
     */
    public static final int LENGTH_USER = 50;

    /**
     * 主题的长度约束。
     */
    public static final int LENGTH_SUBJECT = 100;

    private Constraints() {
        throw new IllegalStateException("禁止实例化");
    }
}
