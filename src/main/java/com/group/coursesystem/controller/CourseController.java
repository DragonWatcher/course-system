package com.group.coursesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.coursesystem.entity.Course;
import com.group.coursesystem.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseSvc;

    @GetMapping()
    public List<Course> findAll() {
        return courseSvc.findAllCourses();
    }
}
