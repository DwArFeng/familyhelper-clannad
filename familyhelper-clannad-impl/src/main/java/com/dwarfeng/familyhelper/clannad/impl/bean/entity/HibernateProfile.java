package com.dwarfeng.familyhelper.clannad.impl.bean.entity;

import com.dwarfeng.familyhelper.clannad.sdk.util.Constraints;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateStringIdKey.class)
@Table(name = "tbl_profile")
public class HibernateProfile implements Bean {

    private static final long serialVersionUID = 1708588983724769069L;

    // -----------------------------------------------------------主键-----------------------------------------------------------
    @Id
    @Column(name = "id", nullable = false, unique = true, length = Constraints.LENGTH_ID)
    private String stringId;

    // -----------------------------------------------------------主属性字段-----------------------------------------------------------
    @Column(name = "name", length = Constraints.LENGTH_NAME)
    private String name;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "id_type", length = Constraints.LENGTH_ID)
    private String idType;

    @Column(name = "birthday", length = Constraints.LENGTH_BIRTHDAY)
    private String birthday;

    @Column(name = "gender", length = Constraints.LENGTH_ID)
    private String gender;

    @Column(name = "bloodType", length = Constraints.LENGTH_ID)
    private String bloodType;

    @Column(name = "nationality", length = Constraints.LENGTH_ID)
    private String nationality;

    @Column(name = "family_address")
    private String familyAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "employer")
    private String employer;

    @Column(name = "job_position", length = Constraints.LENGTH_ID)
    private String jobPosition;

    @Column(name = "employer_address")
    private String employerAddress;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "latest_school_name")
    private String latestSchoolName;

    @Column(name = "educational_level", length = Constraints.LENGTH_ID)
    private String educationalLevel;

    @Column(name = "educational_background", length = Constraints.LENGTH_ID)
    private String educationalBackground;

    @Column(name = "political_status", length = Constraints.LENGTH_ID)
    private String politicalStatus;

    @Column(name = "marital_status", length = Constraints.LENGTH_ID)
    private String maritalStatus;

    @Column(name = "remark")
    private String remark;

    // -----------------------------------------------------------一对多-----------------------------------------------------------
    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernatePopr.class, mappedBy = "profile")
    private Set<HibernatePopr> poprs = new HashSet<>();

    public HibernateProfile() {
    }

    // -----------------------------------------------------------映射用属性区-----------------------------------------------------------
    public HibernateStringIdKey getKey() {
        return Optional.ofNullable(stringId).map(HibernateStringIdKey::new).orElse(null);
    }

    public void setKey(HibernateStringIdKey idKey) {
        this.stringId = Optional.ofNullable(idKey).map(HibernateStringIdKey::getStringId).orElse(null);
    }

    // -----------------------------------------------------------常规属性区-----------------------------------------------------------
    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
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

    public Set<HibernatePopr> getPoprs() {
        return poprs;
    }

    public void setPoprs(Set<HibernatePopr> poprs) {
        this.poprs = poprs;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "stringId = " + stringId + ", " +
                "name = " + name + ", " +
                "idNumber = " + idNumber + ", " +
                "idType = " + idType + ", " +
                "birthday = " + birthday + ", " +
                "gender = " + gender + ", " +
                "bloodType = " + bloodType + ", " +
                "nationality = " + nationality + ", " +
                "familyAddress = " + familyAddress + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "emailAddress = " + emailAddress + ", " +
                "employer = " + employer + ", " +
                "jobPosition = " + jobPosition + ", " +
                "employerAddress = " + employerAddress + ", " +
                "jobTitle = " + jobTitle + ", " +
                "latestSchoolName = " + latestSchoolName + ", " +
                "educationalLevel = " + educationalLevel + ", " +
                "educationalBackground = " + educationalBackground + ", " +
                "politicalStatus = " + politicalStatus + ", " +
                "maritalStatus = " + maritalStatus + ", " +
                "remark = " + remark + ")";
    }
}
