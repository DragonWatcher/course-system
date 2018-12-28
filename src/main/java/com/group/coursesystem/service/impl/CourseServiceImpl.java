package com.group.coursesystem.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.coursesystem.dao.CourseRepository;
import com.group.coursesystem.entity.Course;
import com.group.coursesystem.entity.SystemResult;
import com.group.coursesystem.enums.SysContents;
import com.group.coursesystem.service.CourseService;

@Service(value = "courseSvc")
public class CourseServiceImpl implements CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository couseRep;

    @Override
    public List<Course> findAllCourses() {
        List<Course> allCourses = couseRep.findAll();
        logger.info("查询全部课程 : " + allCourses);
        return allCourses;
    }

    @Override
    public SystemResult addOneCourse(Course course) {
        Course savedCourse = couseRep.save(course);
        return new SystemResult(SysContents.SUCCESS, "添加课程成功！", savedCourse);
    }

}
