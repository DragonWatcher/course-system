package com.group.coursesystem.service;

import com.group.coursesystem.entity.User;

/**
 * 校验服务 <br>
 * 类名：CheckService<br>
 * 作者： mht<br>
 * 日期： 2018年12月10日-下午10:42:24<br>
 */
public interface CheckService {

    /** 判断是否有此用户 */
    User checkUser(String role, String name, String password);

    /**
     * user 是一个必须含有role字符串的老师或学生类型<br>
     * 返回结果为true代表是老师，返回结果为false代表学生，为null代表类型未知
     */
    Boolean checkTeacherByRole(Object user);

    public static boolean isEmpty(String arg) {
        if (arg == null || arg.equals("")) {
            return true;
        }
        return false;
    }
}
