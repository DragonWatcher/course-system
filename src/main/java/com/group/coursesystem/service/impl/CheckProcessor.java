package com.group.coursesystem.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.group.coursesystem.dao.StudentRepository;
import com.group.coursesystem.dao.TeacherRepository;
import com.group.coursesystem.entity.Admin;
import com.group.coursesystem.entity.Student;
import com.group.coursesystem.entity.Teacher;
import com.group.coursesystem.entity.User;
import com.group.coursesystem.service.CheckService;

@Service
public class CheckProcessor implements CheckService {

    private static final Logger logger = LoggerFactory.getLogger(CheckProcessor.class);

    @Autowired
    private Admin admin;

    @Autowired
    private StudentRepository stuRep;

    @Autowired
    private TeacherRepository teacherRep;

    @SuppressWarnings("unchecked")
    @Override
    public User checkUser(String role, String name, String password) {
        logger.info("开始校验请求用户...");
        // 判断是否是管理员
        if (Admin.role.equals(role)) {
            if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
                return new User(0000 + "_admin", admin.getName(), Admin.role, null, admin.getClass());
            }
        }
        // 教师和学生是分表存储的，根据role = tableName的规则，分表查询
        else if (Teacher.role.equals(role)) {
            Teacher thr = teacherRep.findByUsernameAndPassword(name, password);
            if (thr != null) {
                return new User(thr.getTeacherId() + "_" + thr.getUsername(), thr.getTeacherName(), Teacher.role,
                        thr.getGender(), thr.getClass());
            }
        } else if (Student.role.equals(role)) {
            Student stu = stuRep.findByUsernameAndPassword(name, password);
            if (stu != null) {
                return new User(stu.getStuId() + "_" + stu.getUsername(), stu.getStuName(), Student.role,
                        stu.getGender(), stu.getClass());
            }
        }

        return null;
    }

    @Override
    public Boolean checkTeacherByRole(Object user) {
        // 先判断新加用户是教师还是学生
        String role = JSONObject.parseObject(JSONObject.toJSONString(user))
                                .getString("role");
        if (role == null || role.equals(""))
            return null;
        if (role.equals(Teacher.role))
            return true;
        if (role.equals(Student.role))
            return false;
        return null;
    }
    
}
