package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.FastJsonPoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * FastJson 证件权限。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class FastJsonPoce implements Bean {

    private static final long serialVersionUID = -4791805416590447264L;

    public static FastJsonPoce of(Poce poce) {
        if (Objects.isNull(poce)) {
            return null;
        } else {
            return new FastJsonPoce(FastJsonPoceKey.of(poce.getKey()), poce.getPermissionLevel(), poce.getRemark());
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonPoceKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public FastJsonPoce() {
    }

    public FastJsonPoce(FastJsonPoceKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public FastJsonPoceKey getKey() {
        return key;
    }

    public void setKey(FastJsonPoceKey key) {
        this.key = key;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonPoce{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
