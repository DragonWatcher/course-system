package com.group.coursesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.coursesystem.entity.Course;

/**
 * 课程信息操作
 * <br>类名：CourseRepository<br>
 */
@Repository(value = "couseRep")
public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
