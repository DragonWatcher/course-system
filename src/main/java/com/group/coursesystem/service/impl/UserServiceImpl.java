package com.group.coursesystem.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.coursesystem.dao.StudentRepository;
import com.group.coursesystem.dao.TeacherRepository;
import com.group.coursesystem.entity.Student;
import com.group.coursesystem.entity.SystemResult;
import com.group.coursesystem.entity.Teacher;
import com.group.coursesystem.enums.SysContents;
import com.group.coursesystem.service.CheckService;
import com.group.coursesystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CheckService checkSvc;

    @Autowired
    private TeacherRepository tchrRep;

    @Autowired
    private StudentRepository stuRep;

    @Override
    @SuppressWarnings("rawtypes")
    public SystemResult addOrUpdateUser(Object user) {
        Boolean isTeacher = checkSvc.checkTeacherByRole(user);
        if (isTeacher == null) {
            logger.error("传入的role不正确！");
            return new SystemResult(SysContents.FAIL, "传入的role不正确！", null);
        }

        boolean isStudent = !isTeacher;
        String userStr = null;
        Class clazz = null;
        if (isTeacher) {
            // 添加教师
            Teacher teacher = (Teacher) user;
            new Thread(() -> {
                // 新增用户的默认属性初始化
                if (teacher.getTeacherId() == null) {
                    teacher.setPassword(SysContents.INITIAL_PASSWORD);
                }
                tchrRep.save(teacher);
            }, "TH-savingTeacher").start();

            clazz = teacher.getClass();
            userStr = teacher.toString();
        } else if (isStudent) {
            // 添加学生
            Student student = (Student) user;
            new Thread(() -> {
                if (student.getStuId() == null)
                    student.setPassword(SysContents.INITIAL_PASSWORD);
                stuRep.save(student);
            }, "TH-savingStudent").start();

            clazz = student.getClass();
            userStr = student.toString();
        }
        logger.info("添加或更新<" + clazz.getSimpleName() + "> : " + userStr);
        String resultMessage = "添加" + (isTeacher ? "教师" : "学生") + "成功!";

        return new SystemResult(SysContents.SUCCESS, resultMessage, clazz);
    }
}
