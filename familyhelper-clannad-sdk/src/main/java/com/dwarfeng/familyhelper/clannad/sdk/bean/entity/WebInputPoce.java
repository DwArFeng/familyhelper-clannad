package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.bean.key.WebInputPoceKey;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Poce;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 证书权限。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class WebInputPoce implements Bean {

    private static final long serialVersionUID = -5612484946927862464L;

    public static Poce toStackBean(WebInputPoce webInputPoce) {
        if (Objects.isNull(webInputPoce)) {
            return null;
        } else {
            return new Poce(
                    WebInputPoceKey.toStackBean(webInputPoce.getKey()),
                    webInputPoce.getPermissionLevel(),
                    webInputPoce.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    @Valid
    private WebInputPoceKey key;

    @JSONField(name = "permission_level", ordinal = 2)
    private int permissionLevel;

    @JSONField(name = "remark", ordinal = 3)
    private String remark;

    public WebInputPoce() {
    }

    public WebInputPoceKey getKey() {
        return key;
    }

    public void setKey(WebInputPoceKey key) {
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
        return "WebInputPoce{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
