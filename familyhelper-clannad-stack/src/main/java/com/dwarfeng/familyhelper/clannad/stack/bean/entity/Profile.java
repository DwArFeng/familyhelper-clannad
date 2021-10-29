package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 个人信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class Profile implements Entity<StringIdKey> {

    private static final long serialVersionUID = 5034705068636847209L;

    private StringIdKey key;
    private String name;
    private String idNumber;
    private String motd;
    private String birthday;
    private String gender;
    private String remark;

    public Profile() {
    }

    public Profile(
            StringIdKey key, String name, String idNumber, String motd, String birthday, String gender, String remark
    ) {
        this.key = key;
        this.name = name;
        this.idNumber = idNumber;
        this.motd = motd;
        this.birthday = birthday;
        this.gender = gender;
        this.remark = remark;
    }

    @Override
    public StringIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(StringIdKey key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", motd='" + motd + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", remark='" + remark + '\'' +
                '}';
    }
}
