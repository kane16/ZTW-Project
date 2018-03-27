package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.repository.UserRepository;
import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @Autowired
    UserService service;

    @RequestMapping("/register")
    public String register(){
        return "registerSite";
    }

}
