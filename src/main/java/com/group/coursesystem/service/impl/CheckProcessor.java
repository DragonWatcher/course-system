package com.group.coursesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.coursesystem.dao.StudentRepository;
import com.group.coursesystem.dao.TeacherRepository;
import com.group.coursesystem.entity.Admin;
import com.group.coursesystem.entity.Student;
import com.group.coursesystem.entity.Teacher;
import com.group.coursesystem.service.CheckService;

@Service
public class CheckProcessor implements CheckService {

    @Autowired
    private Admin admin;

    @Autowired
    private StudentRepository stuRep;

    @Autowired
    private TeacherRepository teacherRep;

    @Override
    public boolean checkUser(String role, String name, String password) {
        // 判断是否是管理员
        if (Admin.role.equals(role)) {
            if (admin.getName()
                     .equals(name)
                    && admin.getPassword()
                            .equals(password)) {
                return Boolean.TRUE;
            }
        } else if (Teacher.role.equals(role)) {
            if (teacherRep.findByTeacherNameAndPassword(name, password) != null) {
                return Boolean.TRUE;
            }
        } else if (Student.role.equals(role)) {
            if (stuRep.findByStuNameAndPassword(name, password) != null) {
                return Boolean.TRUE;
            }
        }
        return false;
    }

}
