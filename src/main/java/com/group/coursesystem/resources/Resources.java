package com.group.coursesystem.resources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.group.coursesystem.entity.Admin;
import com.group.coursesystem.entity.Student;
import com.group.coursesystem.entity.Teacher;

@Component
public class Resources {

    public static final String MENU_SYSTEM_MANAGE = "系统管理", MENU_TEACHER_MANAGE = "教师管理", MENU_COURSE_MANAGE = "课程管理",
            MENU_STUDENT_MANAGE = "学生管理", MENU_PERM_MANAGE = "权限管理";

    private static final Map<String, Set<String>> menuMap = new HashMap<>();

    static {
        // 管理员菜单列表
        Set<String> adminMenus = new HashSet<>(Arrays.asList(MENU_SYSTEM_MANAGE, MENU_TEACHER_MANAGE,
                MENU_COURSE_MANAGE, MENU_STUDENT_MANAGE, MENU_PERM_MANAGE));
        // 老师菜单列表
        Set<String> teacherMenus = new HashSet<>(Arrays.asList(MENU_COURSE_MANAGE));
        // 学生菜单列表
        Set<String> studentMenus = new HashSet<>(Arrays.asList(MENU_COURSE_MANAGE));

        menuMap.put(Admin.role, adminMenus);
        menuMap.put(Teacher.role, teacherMenus);
        menuMap.put(Student.role, studentMenus);
    }

    public static Set<String> getMenusByRole(String role) {
        if (role == null)
            return null;

        return menuMap.get(role);
    }
}
