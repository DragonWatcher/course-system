package com.group.coursesystem.service;

/**
 * 校验服务 <br>
 * 类名：CheckService<br>
 * 作者： mht<br>
 * 日期： 2018年12月10日-下午10:42:24<br>
 */
public interface CheckService {

    /** 判断是否有此用户 */
    boolean checkUser(String role, String name, String password);
}
