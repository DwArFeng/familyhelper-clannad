package com.dwarfeng.familyhelper.clannad.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Objects;

/**
 * FastJson 个人简介。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class FastJsonProfile implements Dto {

    private static final long serialVersionUID = -7404896419562944273L;

    public static FastJsonProfile of(Profile profile) {
        if (Objects.isNull(profile)) {
            return null;
        } else {
            return new FastJsonProfile(
                    FastJsonStringIdKey.of(profile.getKey()), profile.getName(), profile.getIdNumber(),
                    profile.getIdType(), profile.getBirthday(), profile.getGender(), profile.getBloodType(),
                    profile.getNationality(), profile.getFamilyAddress(), profile.getPhoneNumber(),
                    profile.getEmailAddress(), profile.getEmployer(), profile.getJobPosition(),
                    profile.getEmployerAddress(), profile.getJobTitle(), profile.getLatestSchoolName(),
                    profile.getEducationalLevel(), profile.getEducationalBackground(), profile.getPoliticalStatus(),
                    profile.getMaritalStatus(), profile.getRemark()
            );
        }
    }

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    // -----------------------------------------------------------基本信息-----------------------------------------------------------
    @JSONField(name = "name", ordinal = 2)
    private String name;

    @JSONField(name = "id_number", ordinal = 3)
    private String idNumber;

    @JSONField(name = "id_type", ordinal = 4)
    private String idType;

    @JSONField(name = "birthday", ordinal = 5)
    private String birthday;

    @JSONField(name = "gender", ordinal = 6)
    private String gender;

    @JSONField(name = "bloodType", ordinal = 7)
    private String bloodType;

    @JSONField(name = "nationality", ordinal = 8)
    private String nationality;

    // -----------------------------------------------------------联系方式-----------------------------------------------------------
    @JSONField(name = "family_address", ordinal = 9)
    private String familyAddress;

    @JSONField(name = "phone_number", ordinal = 10)
    private String phoneNumber;

    @JSONField(name = "email_address", ordinal = 11)
    private String emailAddress;

    // -----------------------------------------------------------职务信息-----------------------------------------------------------
    @JSONField(name = "employer", ordinal = 12)
    private String employer;

    @JSONField(name = "job_position", ordinal = 13)
    private String jobPosition;

    @JSONField(name = "employer_address", ordinal = 14)
    private String employerAddress;

    @JSONField(name = "job_title", ordinal = 15)
    private String jobTitle;

    // -----------------------------------------------------------政治信息-----------------------------------------------------------
    @JSONField(name = "latest_school_name", ordinal = 16)
    private String latestSchoolName;

    @JSONField(name = "educational_level", ordinal = 17)
    private String educationalLevel;

    @JSONField(name = "educational_background", ordinal = 18)
    private String educationalBackground;

    // -----------------------------------------------------------政治信息-----------------------------------------------------------
    @JSONField(name = "political_status", ordinal = 19)
    private String politicalStatus;

    // -----------------------------------------------------------婚姻信息-----------------------------------------------------------
    @JSONField(name = "marital_status", ordinal = 20)
    private String maritalStatus;

    // -----------------------------------------------------------杂项-----------------------------------------------------------
    @JSONField(name = "remark", ordinal = 21)
    private String remark;

    public FastJsonProfile() {
    }

    public FastJsonProfile(
            FastJsonStringIdKey key, String name, String idNumber, String idType, String birthday, String gender,
            String bloodType, String nationality, String familyAddress, String phoneNumber, String emailAddress,
            String employer, String jobPosition, String employerAddress, String jobTitle, String latestSchoolName,
            String educationalLevel, String educationalBackground, String politicalStatus, String maritalStatus,
            String remark
    ) {
        this.key = key;
        this.name = name;
        this.idNumber = idNumber;
        this.idType = idType;
        this.birthday = birthday;
        this.gender = gender;
        this.bloodType = bloodType;
        this.nationality = nationality;
        this.familyAddress = familyAddress;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.employer = employer;
        this.jobPosition = jobPosition;
        this.employerAddress = employerAddress;
        this.jobTitle = jobTitle;
        this.latestSchoolName = latestSchoolName;
        this.educationalLevel = educationalLevel;
        this.educationalBackground = educationalBackground;
        this.politicalStatus = politicalStatus;
        this.maritalStatus = maritalStatus;
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

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLatestSchoolName() {
        return latestSchoolName;
    }

    public void setLatestSchoolName(String latestSchoolName) {
        this.latestSchoolName = latestSchoolName;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
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
                ", idType='" + idType + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", nationality='" + nationality + '\'' +
                ", familyAddress='" + familyAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", employer='" + employer + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", employerAddress='" + employerAddress + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", latestSchoolName='" + latestSchoolName + '\'' +
                ", educationalLevel='" + educationalLevel + '\'' +
                ", educationalBackground='" + educationalBackground + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
