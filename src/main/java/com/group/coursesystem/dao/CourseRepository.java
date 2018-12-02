package com.group.coursesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.coursesystem.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
