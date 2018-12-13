package com.group.coursesystem.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.group.coursesystem.enums.Role;

@Component
@ConfigurationProperties(prefix = "admin")
public class Admin {

    public static final String role = Role.A;

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
