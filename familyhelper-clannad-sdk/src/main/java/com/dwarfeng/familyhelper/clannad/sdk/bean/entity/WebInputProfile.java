package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.sdk.validation.IdNumber;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * WebInput 个人信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputProfile implements Dto {

    private static final long serialVersionUID = 1367904127740306517L;

    public static Profile toStackBean(WebInputProfile webInputProfile) {
        if (Objects.isNull(webInputProfile)) {
            return null;
        } else {
            return new Profile(
                    WebInputStringIdKey.toStackBean(webInputProfile.getKey()),
                    webInputProfile.getName(),
                    webInputProfile.getIdNumber(),
                    webInputProfile.getMotd(),
                    webInputProfile.getBirthday(),
                    webInputProfile.getGender(),
                    webInputProfile.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputStringIdKey key;

    @JSONField(name = "name")
    @Length(max = Constraints.LENGTH_NAME)
    private String name;

    @JSONField(name = "id_number")
    @IdNumber
    private String idNumber;

    @JSONField(name = "motd")
    @Length(max = Constraints.LENGTH_MOTD)
    private String motd;

    @JSONField(name = "birthday")
    @Pattern(regexp = "\\d\\d\\d\\d-\\d\\d-\\d\\d")
    private String birthday;

    @JSONField(name = "gender")
    private Integer gender;

    @JSONField(name = "remark")
    @Length(max = Constraints.LENGTH_REMARK)
    private String remark;

    public WebInputProfile() {
    }

    public WebInputStringIdKey getKey() {
        return key;
    }

    public void setKey(WebInputStringIdKey key) {
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
        return "WebInputProfile{" +
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
