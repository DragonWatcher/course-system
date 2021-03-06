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
import com.group.coursesystem.service.CheckService;
import com.group.coursesystem.service.MainService;
import com.group.coursesystem.service.MenuStore;

@Service("mainSvc")
public class MainServiceProcessor implements MainService {

    private static final Logger logger = LoggerFactory.getLogger(MainServiceProcessor.class);

    public static final String REDIRECT_TOLOGIN = "redirect:/login";

    public static final String REDIRECT_INDEX_PAGE = "redirect:/";

    @Autowired
    private CheckService checkService;

    @Autowired
    private MenuStore resources;

    @Override
    public String doLoin(String role, String userName, String password, RedirectAttributes rAttributes,
            HttpSession session) {
        // 参数校验
        if (CheckService.isEmpty(userName) || CheckService.isEmpty(password)) {
            rAttributes.addFlashAttribute("error", "参数错误！");
            return REDIRECT_TOLOGIN;
        }

        User user = checkService.checkUser(role, userName, password);

        if (user == null) {
            logger.info("用户名、密码或所选角色错误...");
            rAttributes.addFlashAttribute("error", "用户名、密码或所选角色错误！");
            return REDIRECT_TOLOGIN;
        }
        logger.info("用户登录成功 : " + user + "");

        session.setAttribute(SysContents.SESSION_MEMBER_KEY, user);
        // 将用户可用菜单和权限存入session
        session.setAttribute("menus", resources.getMenusByRole(user.getRole()));
        session.setAttribute("isAdmin", Role.A.equals(user.getRole()));

        return REDIRECT_INDEX_PAGE;
    }

    @Override
    public String logout(HttpSession session) {
        logger.info("用户注销..." + session.getAttribute(SysContents.SESSION_MEMBER_KEY));
        session.invalidate();
        return REDIRECT_TOLOGIN;
    }

}
