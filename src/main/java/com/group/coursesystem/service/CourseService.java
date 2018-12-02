package com.group.coursesystem.service;

import java.util.List;

import com.group.coursesystem.entity.Course;
/**
 * 课程处理服务类
 * <br>类名：CourseService<br>
 * 作者： mht<br>
 * 日期： 2018年12月2日-下午9:30:00<br>
 */
public interface CourseService {
    public List<Course> findAllCourses();
}
