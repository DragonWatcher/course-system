package com.group.coursesystem.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.coursesystem.service.CheckService;

@Controller
public class LoginController {

    @Autowired
    private CheckService checkService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(String name, String password, String role) {
        boolean isExist = checkService.checkUser(role, name, password);
        if (!isExist) {
            return "redirect:/login";
        }

        return "redirect:/";
    }

}
