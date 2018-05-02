package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    UserService userService;



    @RequestMapping("/admin")
    public String admin(){
        return "adminSite";
    }

    @PostMapping("/admin/changePassword")
    public String adminChangePassword(
            @ModelAttribute("usernameToChange") String username,
            @ModelAttribute("passwordToChange") String password,
            @ModelAttribute("repeatPasswordToChange") String passwordConfirmation
    ){
        User user = userService.findByUserName(username);
        if(password.equals(passwordConfirmation) && user != null){
            user.setPassword(password);
            userService.updateUser(user);
        }
        return "adminSite";
    }

    @PostMapping("/admin/deleteUser")
    public String adminDeleteUser(
            @ModelAttribute("usernameToDelete") String usernameToDelete
    ){
        userService.deleteUser(usernameToDelete);
        return "adminSite";
    }



}
