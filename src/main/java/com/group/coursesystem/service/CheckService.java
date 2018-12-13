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

    public static boolean isEmpty(String arg) {
        if (arg == null || arg.equals("")) {
            return true;
        }
        return false;
    }
}
