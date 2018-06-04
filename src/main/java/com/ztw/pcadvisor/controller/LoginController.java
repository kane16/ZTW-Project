package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Login controller.
 */
@Controller
public class LoginController {

    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * Gets login website.
     *
     * @return the string
     */
    @RequestMapping("/login")
    public String login(){
        return "loginSite";
    }

}
