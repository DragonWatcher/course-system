package com.group.coursesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.coursesystem.entity.Student;

@Repository("stuRep")
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStuNameAndPassword(String stuName, String password);
}
