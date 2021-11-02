package com.dwarfeng.familyhelper.clannad.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.familyhelper.clannad.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

/**
 * WebInput 个人简介更新信息。
 *
 * @author DwArFeng
 * @since 1.1.1
 */
public class WebInputProfileUpdateInfo implements Dto {

    private static final long serialVersionUID = 1974148480204243172L;

    public static ProfileUpdateInfo toStackBean(WebInputProfileUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ProfileUpdateInfo(
                    webInput.getName(), webInput.getIdNumber(), webInput.getIdType(), webInput.getBirthday(),
                    webInput.getGender(), webInput.getBloodType(), webInput.getNationality(),
                    webInput.getFamilyAddress(), webInput.getPhoneNumber(), webInput.getEmailAddress(),
                    webInput.getEmployer(), webInput.getJobPosition(), webInput.getEmployerAddress(),
                    webInput.getJobTitle(), webInput.getLatestSchoolName(), webInput.getEducationalLevel(),
                    webInput.getEducationalBackground(), webInput.getPoliticalStatus(), webInput.getMaritalStatus(),
                    webInput.getRemark()
            );
        }
    }

    // -----------------------------------------------------------基本信息-----------------------------------------------------------
    @JSONField(name = "name")
    private String name;

    @JSONField(name = "id_number")
    private String idNumber;

    @JSONField(name = "id_type")
    @Length(max = Constraints.LENGTH_ID)
    private String idType;

    @JSONField(name = "birthday")
    private String birthday;

    @JSONField(name = "gender")
    @Length(max = Constraints.LENGTH_ID)
    private String gender;

    @JSONField(name = "bloodType")
    @Length(max = Constraints.LENGTH_ID)
    private String bloodType;

    @JSONField(name = "nationality")
    @Length(max = Constraints.LENGTH_ID)
    private String nationality;

    // -----------------------------------------------------------联系方式-----------------------------------------------------------
    @JSONField(name = "family_address")
    private String familyAddress;

    @JSONField(name = "phone_number")
    private String phoneNumber;

    @JSONField(name = "email_address")
    private String emailAddress;

    // -----------------------------------------------------------职务信息-----------------------------------------------------------
    @JSONField(name = "employer")
    private String employer;

    @JSONField(name = "job_position")
    @Length(max = Constraints.LENGTH_ID)
    private String jobPosition;

    @JSONField(name = "employer_address")
    private String employerAddress;

    @JSONField(name = "job_title")
    private String jobTitle;

    // -----------------------------------------------------------政治信息-----------------------------------------------------------
    @JSONField(name = "latest_school_name")
    private String latestSchoolName;

    @JSONField(name = "educational_level")
    @Length(max = Constraints.LENGTH_ID)
    private String educationalLevel;

    @JSONField(name = "educational_background")
    @Length(max = Constraints.LENGTH_ID)
    private String educationalBackground;

    // -----------------------------------------------------------政治信息-----------------------------------------------------------
    @JSONField(name = "political_status")
    @Length(max = Constraints.LENGTH_ID)
    private String politicalStatus;

    // -----------------------------------------------------------婚姻信息-----------------------------------------------------------
    @JSONField(name = "marital_status")
    @Length(max = Constraints.LENGTH_ID)
    private String maritalStatus;

    // -----------------------------------------------------------杂项-----------------------------------------------------------
    @JSONField(name = "remark")
    private String remark;

    public WebInputProfileUpdateInfo() {
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
        return "WebInputProfileUpdateInfo{" +
                "name='" + name + '\'' +
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
