package com.group.coursesystem.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.group.coursesystem.entity.Admin;
import com.group.coursesystem.entity.Student;
import com.group.coursesystem.entity.Teacher;

/**
 * 菜单枚举类 <br>
 * 类名：Menu<br>
 * 作者： mht<br>
 * 日期： 2018年12月27日-下午5:43:55<br>
 */
public enum Menu {
    MENU_SYSTEM_MANAGE("系统管理", "", new HashSet<>(Arrays.asList(Admin.role))),
    MENU_TEACHER_MANAGE("教师管理", "", new HashSet<>(Arrays.asList(Admin.role))),
    MENU_PERM_MANAGE("权限管理", "", new HashSet<>(Arrays.asList(Admin.role))),
    MENU_STUDENT_MANAGE("学生管理", "", new HashSet<>(Arrays.asList(Admin.role, Teacher.role))),
    MENU_COURSE_MANAGE("课程管理", "", new HashSet<>(Arrays.asList(Admin.role, Teacher.role, Student.role)));

    private String menuName;

    private String url;

    private Set<String> roles;

    private Menu(String menuName, String url, Set<String> roles) {
        this.menuName = menuName;
        this.url = url;
        this.roles = roles;
    }

    public static Set<Menu> getAllMenus() {
        return new HashSet<>(Arrays.asList(MENU_SYSTEM_MANAGE, MENU_TEACHER_MANAGE, MENU_PERM_MANAGE,
                MENU_STUDENT_MANAGE, MENU_COURSE_MANAGE));
    }

    public static Set<Menu> getTeacherMenus() {
        return new HashSet<>(Arrays.asList(MENU_COURSE_MANAGE, MENU_STUDENT_MANAGE));
    }

    public static Set<Menu> getStudentMenus() {
        return new HashSet<>(Arrays.asList(MENU_STUDENT_MANAGE));
    }

    public String getMenuName() {
        return menuName;
    }

    public String getUrl() {
        return url;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
