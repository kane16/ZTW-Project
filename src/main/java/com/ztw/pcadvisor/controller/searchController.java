package com.ztw.pcadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class searchController {

    @GetMapping("/search")
    public String searchComponent(){
        return "componentSearch";
    }

}
