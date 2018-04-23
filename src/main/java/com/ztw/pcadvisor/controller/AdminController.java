package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    ProductService productService;


    @RequestMapping("/admin")
    public String admin(){
        return "adminSite";
    }

}
