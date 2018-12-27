package com.group.coursesystem.resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.group.coursesystem.entity.Admin;
import com.group.coursesystem.entity.Student;
import com.group.coursesystem.entity.Teacher;
import com.group.coursesystem.enums.Menu;

@Component
public class Resources {
    
    private static final Map<String, Set<Menu>> menuMap = new HashMap<>();

    static {
        menuMap.put(Admin.role, Menu.getAllMenus());
        menuMap.put(Teacher.role, Menu.getTeacherMenus());
        menuMap.put(Student.role, Menu.getStudentMenus());
    }

    public static Set<Menu> getMenusByRole(String role) {
        return menuMap.get(role);
    }
}
