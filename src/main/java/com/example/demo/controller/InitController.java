package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * InitController
 *
 * @author mawengang
 * @date 2019/12/10 10:44
 */
@Controller
public class InitController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/initIdentity")
    public String initIdentity(){
        userService.initUsersAndGroups();
        return "ok";
    }
}
