package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoceKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 证件权限。
 *
 * @author DwArFeng
 * @since 1.2.3
 */
public class Poce implements Entity<PoceKey> {

    private static final long serialVersionUID = -5573866611063401387L;

    private PoceKey key;
    private int permissionLevel;
    private String remark;

    public Poce() {
    }

    public Poce(PoceKey key, int permissionLevel, String remark) {
        this.key = key;
        this.permissionLevel = permissionLevel;
        this.remark = remark;
    }

    @Override
    public PoceKey getKey() {
        return key;
    }

    @Override
    public void setKey(PoceKey key) {
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
        return "Poce{" +
                "key=" + key +
                ", permissionLevel=" + permissionLevel +
                ", remark='" + remark + '\'' +
                '}';
    }
}
