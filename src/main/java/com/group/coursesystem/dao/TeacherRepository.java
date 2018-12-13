package com.group.coursesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.coursesystem.entity.Teacher;

@Repository("teacherRep")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByTeacherNameAndPassword(String TeacherName, String password);
}
