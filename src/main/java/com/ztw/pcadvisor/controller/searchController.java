package com.ztw.pcadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class searchController {

    @GetMapping("/search")
    public String searchComponent(Model model, @RequestParam(value = "componentCode", required = false) String componentCode){
        if(componentCode!=null){
            model.addAttribute("code", true);
        }
        return "componentSearch";
    }

}
