package com.group.coursesystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.group.coursesystem.enums.Gender;
import com.group.coursesystem.enums.Role;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "username")
    private String userName;

    @Column(name = "teacher_name")
    @NotNull
    private String teacherName;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    private Set<Course> cources = new HashSet<>();

    /** 教师角色 */
    public static final String role = Role.T;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Set<Course> getCources() {
        return cources;
    }

    public void setCources(Set<Course> cources) {
        this.cources = cources;
    }

    @Override
    public String toString() {
        return "{teacherId : " + teacherId + ", userName : " + userName + ", teacherName : " + teacherName
                + ", password : " + password + ", gender : " + gender + ", jobTitle : " + jobTitle + ", cources : "
                + cources + "}";
    }
}
