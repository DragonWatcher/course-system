package com.group.coursesystem.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.coursesystem.enums.SysContents;
import com.group.coursesystem.service.impl.MainServiceProcessor;

/**
 * 系统的入口控制器，入口控制器里面的请求，理论上都受权限控制
 */
@Controller
@Transactional(readOnly = true)
public class AppController {

    private final static Logger logger = LoggerFactory.getLogger(AppController.class);

    @RequestMapping("/")
    public String index() {
        logger.info("返回首页...");
        return "index";
    }

    /**
     * 返回登录首页
     * <br>作者： mht<br> 
     * 时间：2018年12月28日-上午11:22:16<br>
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        if (session.getAttribute(SysContents.SESSION_MEMBER_KEY) != null) {
            return MainServiceProcessor.REDIRECT_INDEX_PAGE;
        }
        return "login";
    }

}
