package com.group.coursesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.coursesystem.dao.CourseRepository;
import com.group.coursesystem.entity.Course;
import com.group.coursesystem.service.CourseService;

@Service(value = "courseSvc")
public class CourseServiceImpl implements CourseService{
    
    @Autowired
    private CourseRepository couseRep;

    @Override
    public List<Course> findAllCourses() {
        return couseRep.findAll();
    }

}
