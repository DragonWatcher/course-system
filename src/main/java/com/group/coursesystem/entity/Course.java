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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.group.coursesystem.enums.CourseType;
import com.group.coursesystem.enums.ExamType;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_type")
    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "class_room")
    private String classRoom;

    /** 使用 @ManyToOne 来映射多对一的关联关系,使用 @JoinColumn 来映射外键 */
    @JoinColumn(name = "teacher_id")
    @ManyToOne
    private Teacher teacher;

    @ManyToMany(mappedBy = "selectedCourses")
    private Set<Student> students = new HashSet<>();

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
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
        return "{courseId : " + courseId + ", courseType : " + courseType + ", courseName : " + courseName
                + ", classRoom : " + classRoom + ", teacher : " + teacher + ", students : " + students + ", period : "
                + period + ", startDate : " + startDate + ", endDate : " + endDate + ", credit : " + credit
                + ", examType : " + examType + ", remark : " + remark + "}";
    }
}
