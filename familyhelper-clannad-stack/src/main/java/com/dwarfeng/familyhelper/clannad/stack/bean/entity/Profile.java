package com.dwarfeng.familyhelper.clannad.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 个人简介。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class Profile implements Entity<StringIdKey> {

    private static final long serialVersionUID = -5933079675799617491L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    private StringIdKey key;

    // -----------------------------------------------------------基本信息-----------------------------------------------------------
    private String name;
    private String idNumber;
    private String idType;
    private String birthday;
    private String gender;
    private String bloodType;
    private String nationality;

    // -----------------------------------------------------------联系方式-----------------------------------------------------------
    private String familyAddress;
    private String phoneNumber;
    private String emailAddress;

    // -----------------------------------------------------------职务信息-----------------------------------------------------------
    private String employer;
    private String jobPosition;
    private String employerAddress;
    private String jobTitle;

    // -----------------------------------------------------------政治信息-----------------------------------------------------------
    private String latestSchoolName;
    private String educationalLevel;
    private String educationalBackground;

    // -----------------------------------------------------------政治信息-----------------------------------------------------------
    private String politicalStatus;

    // -----------------------------------------------------------婚姻信息-----------------------------------------------------------
    private String maritalStatus;

    // -----------------------------------------------------------杂项-----------------------------------------------------------
    private String remark;

    public Profile() {
    }

    public Profile(
            StringIdKey key, String name, String idNumber, String idType, String birthday, String gender,
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

    @SuppressWarnings("DuplicatedCode")
    @Override
    public String toString() {
        return "Profile{" +
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
