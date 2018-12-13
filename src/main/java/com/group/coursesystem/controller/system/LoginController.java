package com.group.coursesystem.controller.system;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group.coursesystem.service.MainService;

@Controller
public class LoginController {

    @Autowired
    private MainService mainSvc;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLoin(String role, String userName, String password, RedirectAttributes rAttributes,
            HttpSession session) {
        return mainSvc.doLoin(role, userName, password, rAttributes, session);
    }

}
