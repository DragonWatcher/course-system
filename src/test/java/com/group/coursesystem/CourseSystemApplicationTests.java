package com.group.coursesystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.group.coursesystem.entity.Student;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CourseSystemApplicationTests {

    @Test
    public void contextLoads() {
        Student studnet = new Student();
        System.out.println(studnet.role);
        
    }
    
    

}
