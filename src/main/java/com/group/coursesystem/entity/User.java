package com.group.coursesystem.entity;

import com.group.coursesystem.enums.Gender;

/**
 * 与页面统一交互的用户实体类 <br>
 * 类名：User<br>
 * 作者： mht<br>
 * 日期： 2018年12月13日-下午11:10:30<br>
 * 
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class User {

    /** userId规则："成员的ID_姓名" */
    private String userId;

    private String userName;

    private String password;

    private String role;

    private Gender gender;

    /** 具体的类型对象 */

    private Class clazz;

    private Integer phoneNum;

    public User() {
    }

    public User(String userId, String userName, String role, Gender gender, Class clazz) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
        this.gender = gender;
        this.clazz = clazz;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "{userId : " + userId + ", userName : " + userName + ", password : " + password + ", role : " + role
                + ", gender : " + gender + ", clazz : " + clazz.getSimpleName() + ", phoneNum : " + phoneNum + "}";
    }
}
