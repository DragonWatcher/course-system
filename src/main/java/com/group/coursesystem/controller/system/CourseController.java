package com.group.coursesystem.controller.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.coursesystem.entity.Course;
import com.group.coursesystem.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseSvc;

    @ResponseBody
    @GetMapping("/json-data")
    public List<Course> findAll() {
        logger.info("收到查询全部课程请求，开始查询全部课程...");
        return courseSvc.findAllCourses();
    }

    @GetMapping()
    public String returnWebPage() {
        return "course/courses";
    }
}
