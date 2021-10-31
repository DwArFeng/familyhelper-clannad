package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.PoprKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 个人简介权限。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class Popr implements Entity<PoprKey> {

    private static final long serialVersionUID = 4291945407389641882L;

    private PoprKey key;
    private String remark;

    public Popr() {
    }

    public Popr(PoprKey key, String remark) {
        this.key = key;
        this.remark = remark;
    }

    @Override
    public PoprKey getKey() {
        return key;
    }

    @Override
    public void setKey(PoprKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Popr{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                '}';
    }
}
