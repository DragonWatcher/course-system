package com.group.coursesystem.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 主服务类
 * <br>类名：MainService<br>
 * 作者： mht<br>
 * 日期： 2018年12月13日-下午10:20:20<br>
 */
public interface MainService {
    
    public String doLoin(String role, String userName, String password, RedirectAttributes rAttributes, HttpSession session);
    
    public String logout(HttpSession session);

}
