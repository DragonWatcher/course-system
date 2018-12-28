package com.group.coursesystem.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.group.coursesystem.enums.Degree;
import com.group.coursesystem.enums.Gender;
import com.group.coursesystem.enums.Role;

/**
 * 学生信息实体类 <br>
 * 类名：Student<br>
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private Long stuId;

    @Column(name = "stu_no")
    private Integer stuNo;

    @Column(name = "stu_name")
    private String stuName;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    /** 角色固定为student */
    public static final String role = Role.S;

    @Column(name = "phone_num")
    private Integer phoneNum;

    public static final String academy = "计算机学院";

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "class_num")
    private Integer classNum;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(name = "stu_course", joinColumns = { @JoinColumn(name = "stu_id") }, inverseJoinColumns = {
            @JoinColumn(name = "course_id") })
    private Set<Course> selectedCourses = new HashSet<>();

    @Column(name = "birthday")
    private Date birthday;

    public Student() {
        super();
    }

    public Student(String stuName, Gender gender, Integer grade, Integer classNum) {
        this.stuName = stuName;
        this.gender = gender;
        this.grade = grade;
        this.classNum = classNum;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Set<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(Set<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{stuId : " + stuId + ", stuNo : " + stuNo + ", stuName : " + stuName + ", password : " + password
                + ", gender : " + gender + ", degree : " + degree + ", phoneNum : " + phoneNum + ", grade : " + grade
                + ", classNum : " + classNum + ", selectedCourses : " + selectedCourses + ", birthday : " + birthday
                + "}";
    }

}
