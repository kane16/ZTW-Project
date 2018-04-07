package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserType;
import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, User user, String repeatPassword) {
        modelAndView.addObject("user", user);
        modelAndView.addObject("repeatPassword",repeatPassword);
        modelAndView.setViewName("registerSite");
        return modelAndView;
    }


    @PostMapping("/register")
    public ModelAndView registerSubmit(ModelAndView modelAndView, @Valid User user, @ModelAttribute UserType userType){

        userService.createUser(user);

        modelAndView.setViewName("registerSite");

        return modelAndView;
    }

}
