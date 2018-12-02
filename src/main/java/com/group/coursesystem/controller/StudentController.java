package com.group.coursesystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stus")
public class StudentController {
    
    @GetMapping("/echo")
    public String echo(String something) {
        return "你好，" + something;
    }

}
