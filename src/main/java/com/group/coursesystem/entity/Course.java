package com.group.coursesystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.group.coursesystem.entity.enums.CourseType;
import com.group.coursesystem.entity.enums.ExamType;

@Entity
@Table(name = "course")
public class Course extends BaseEntity {

    @Column(name = "course_type")
    private CourseType courseType;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "class_room")
    private String classRoom;

    @Column(name = "teacher_name")
    private String teacherName;

    /** 学时 */
    @Column(name = "period")
    private Integer period;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    /** 学分 */
    @Column(name = "credit")
    private Integer credit;

    @Column(name = "exam_type")
    private ExamType examType;

    @Column(name = "remark")
    private String remark;

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "{courseType : " + courseType + ", courseName : " + courseName + ", classRoom : " + classRoom
                + ", teacherName : " + teacherName + ", period : " + period + ", startDate : " + startDate
                + ", endDate : " + endDate + ", credit : " + credit + ", examType : " + examType + ", remark : "
                + remark + "}";
    }
}
