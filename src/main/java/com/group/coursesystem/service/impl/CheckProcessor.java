package com.group.coursesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.coursesystem.dao.StudentRepository;
import com.group.coursesystem.dao.TeacherRepository;
import com.group.coursesystem.entity.Admin;
import com.group.coursesystem.entity.Student;
import com.group.coursesystem.entity.Teacher;
import com.group.coursesystem.entity.User;
import com.group.coursesystem.service.CheckService;

@Service
public class CheckProcessor implements CheckService {

    @Autowired
    private Admin admin;

    @Autowired
    private StudentRepository stuRep;

    @Autowired
    private TeacherRepository teacherRep;

    @SuppressWarnings("unchecked")
    @Override
    public User checkUser(String role, String name, String password) {
        // 判断是否是管理员
        if (Admin.role.equals(role)) {
            if (admin.getName().equals(name)
                    && admin.getPassword().equals(password)) {
                return new User(0000 + "_admin", admin.getName(), Admin.role, null, admin.getClass());
            }
        } else if (Teacher.role.equals(role)) {
            Teacher thr = teacherRep.findByTeacherNameAndPassword(name, password);
            if (thr != null) {
                return new User(thr.getTeacherId() + "_" + thr.getTeacherName(), thr.getTeacherName(), Teacher.role,
                        thr.getGender(), thr.getClass());
            }
        } else if (Student.role.equals(role)) {
            Student stu = stuRep.findByStuNameAndPassword(name, password);
            if (stu != null) {
                return new User(stu.getStuId() + "_" + stu.getStuName(), stu.getStuName(), Student.role,
                        stu.getGender(), stu.getClass());
            }
        }

        return null;
    }

}
