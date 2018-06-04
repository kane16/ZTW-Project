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

import javax.validation.Valid;

/**
 * The Register controller.
 */
@Controller
public class RegisterController {

    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * Register string.
     *
     * @return the string
     */
    @GetMapping("/register")
    public String register() {
        return "registerSite";
    }


    /**
     * Gest register submit site.
     *
     * @param firstName      the first name
     * @param lastName       the last name
     * @param userName       the user name
     * @param password       the password
     * @param repeatPassword the repeat password
     * @param userType       the user type
     * @param model          the model
     * @return the string
     */
    @PostMapping("/register")
    public String registerSubmit(
            @ModelAttribute("firstName") String firstName,
            @ModelAttribute("lastName") String lastName,
            @ModelAttribute("userName") String userName,
            @ModelAttribute("password") String password,
            @ModelAttribute("repeatPassword") String repeatPassword,
            @ModelAttribute("userType") String userType,
            Model model
    ){

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(password);
        user.setUserType(UserType.valueOf(userType));

        boolean correct = true;

        if(userService.findByUserName(user.getUserName())!=null){
            correct=false;
            model.addAttribute("userExists", true);
        }

        if(!userService.isPasswordSecure(user.getPassword()) && correct){
            correct=false;
            model.addAttribute("unsecurePassword", true);
        }

        if(!userService.isPasswordCorrectlyConfirmed(user.getPassword(), repeatPassword) && correct){
            correct=false;
            model.addAttribute("wrongPasswordConfirmed", true);
        }

        if(correct) {
            userService.createUser(user);
            return "confirm";
        }
        return "registerSite";
    }

}
