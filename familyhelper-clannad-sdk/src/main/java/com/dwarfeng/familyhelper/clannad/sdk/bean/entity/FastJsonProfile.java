package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Objects;

/**
 * FastJson 个人信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class FastJsonProfile implements Dto {

    private static final long serialVersionUID = -4539158247313379966L;

    public static FastJsonProfile of(Profile profile) {
        if (Objects.isNull(profile)) {
            return null;
        } else {
            return new FastJsonProfile(
                    FastJsonStringIdKey.of(profile.getKey()), profile.getName(), profile.getIdNumber(),
                    profile.getMotd(), profile.getBirthday(), profile.getGender(), profile.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "name", ordinal = 2)
    private String name;

    @JSONField(name = "id_number", ordinal = 3)
    private String idNumber;

    @JSONField(name = "motd", ordinal = 4)
    private String motd;

    @JSONField(name = "birthday", ordinal = 5)
    private String birthday;

    @JSONField(name = "gender", ordinal = 6)
    private Integer gender;

    @JSONField(name = "remark", ordinal = 7)
    private String remark;

    public FastJsonProfile() {
    }

    public FastJsonProfile(
            FastJsonStringIdKey key, String name, String idNumber, String motd, String birthday, Integer gender,
            String remark
    ) {
        this.key = key;
        this.name = name;
        this.idNumber = idNumber;
        this.motd = motd;
        this.birthday = birthday;
        this.gender = gender;
        this.remark = remark;
    }

    public FastJsonStringIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonStringIdKey key) {
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
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
        return "FastJsonProfile{" +
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
