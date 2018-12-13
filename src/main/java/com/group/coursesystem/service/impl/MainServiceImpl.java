package com.group.coursesystem.service.impl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group.coursesystem.entity.User;
import com.group.coursesystem.enums.Role;
import com.group.coursesystem.enums.SysContents;
import com.group.coursesystem.resources.Resources;
import com.group.coursesystem.service.CheckService;
import com.group.coursesystem.service.MainService;

@Service("mainSvc")
public class MainServiceImpl implements MainService {

    private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);

    public static final String REDIRECT_LOGIN = "redirect:/login";

    public static final String INDEX_PAGE = "redirect:/";

    @Autowired
    private CheckService checkService;

    @Autowired
    private Resources resources;

    @Override
    public String doLoin(String role, String userName, String password, RedirectAttributes rAttributes,
            HttpSession session) {
        // 参数校验
        if (CheckService.isEmpty(userName) || CheckService.isEmpty(password)) {
            rAttributes.addFlashAttribute("error", "参数错误！");
            return REDIRECT_LOGIN;
        }

        User user = checkService.checkUser(role, userName, password);

        if (user == null) {
            rAttributes.addFlashAttribute("error", "用户名或密码错误！");
            return REDIRECT_LOGIN;
        }
        logger.info("用户登录成功 : " + user + "");

        // 将用户可用菜单和权限存入session
        session.setAttribute("menus", resources.getMenusByRole(user.getRole()));
        session.setAttribute("session_user", user);
        // 是否是管理员
        session.setAttribute(SysContents.SESSION_MEMBER_KEY, Role.A.equals(user.getRole()));

        return INDEX_PAGE;
    }

}
