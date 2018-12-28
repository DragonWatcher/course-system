package com.group.coursesystem.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.coursesystem.entity.SystemResult;
import com.group.coursesystem.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userSvc;

    @ResponseBody
    @RequestMapping(value = { "/teachers/add", "/teachers/update" }, method = RequestMethod.POST)
    public SystemResult addOneTeacher(@RequestBody Object user) {
        logger.info("请求添加或更新成员...");
        return userSvc.addOrUpdateUser(user);
    }

}
