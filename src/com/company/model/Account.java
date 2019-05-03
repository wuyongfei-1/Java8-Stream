package com.company.model;

import java.sql.Timestamp;

/**
 * this class by created wuyongfei
 **/
public class Account implements Comparable{
    public Account(String uid,String nickName, GenderEnum gender, Integer age, String userName, String password, String mobile, String address, Timestamp createdOn) {
        this.uid = uid;
        this.nickName = nickName;
        this.gender = gender;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.createdOn = createdOn;
    }

    private String uid;
    private Boolean deleted;
    private String nickName;
    private GenderEnum gender;
    private Integer age;
    private String userName;
    private String password;
    private String mobile;
    private String address;
    private Timestamp createdOn;
    private Timestamp updateOn;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Timestamp updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
