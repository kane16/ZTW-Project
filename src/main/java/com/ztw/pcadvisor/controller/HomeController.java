package com.ztw.pcadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Home controller.
 */
@Controller
public class HomeController {

    /**
     * Gets index website.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
