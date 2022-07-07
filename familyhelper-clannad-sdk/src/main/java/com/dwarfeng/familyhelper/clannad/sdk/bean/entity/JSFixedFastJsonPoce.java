package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.JSFixedFastJsonPoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Objects;

/**
 * JSFixed FastJson 证书权限。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class JSFixedFastJsonPoce implements Bean {

    private static final long serialVersionUID = -2695685306544920067L;

    public static JSFixedFastJsonPoce of(Poce poce) {
        if (Objects.isNull(poce)) {
            return null;
        } else {
            return new JSFixedFastJsonPoce(
                    JSFixedFastJsonPoceKey.of(poce.getKey()), poce.getPermissionLevel(), poce.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonPoceKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public JSFixedFastJsonPoce() {
    }

    public JSFixedFastJsonPoce(JSFixedFastJsonPoceKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    public JSFixedFastJsonPoceKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonPoceKey key) {
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
        return "JSFixedFastJsonPoce{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
