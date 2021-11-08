package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.familyhelper.clannad.stack.bean.key.NicknameKey;
import com.dwarfeng.subgrade.stack.bean.entity.Entity;

/**
 * 昵称。
 *
 * @author DwArFeng
 * @since 1.1.4
 */
public class Nickname implements Entity<NicknameKey> {

    private static final long serialVersionUID = 4112149616952077323L;

    private NicknameKey key;
    private String call;
    private String remark;

    public Nickname() {
    }

    public Nickname(NicknameKey key, String call, String remark) {
        this.key = key;
        this.call = call;
        this.remark = remark;
    }

    @Override
    public NicknameKey getKey() {
        return key;
    }

    @Override
    public void setKey(NicknameKey key) {
        this.key = key;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Nickname{" +
                "key=" + key +
                ", call='" + call + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
