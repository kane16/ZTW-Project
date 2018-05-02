package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.PCComponent;
import com.ztw.pcadvisor.model.ComponentType;
import com.ztw.pcadvisor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class searchController {

    @Autowired
    ProductService productService;

    @GetMapping("/search")
    public String searchComponent(Model model,
                                  @RequestParam(value = "componentCode", required = false) String componentCode,
                                  @RequestParam(value = "componentType", required = false) String componentType){
        if(componentCode!=null){
            List<PCComponent> PCComponents = productService.findAllProductsLike(componentCode);
            model.addAttribute("productList", PCComponents);
            model.addAttribute("tableActive", true);
        }
        else if(componentType!=null){
            List<PCComponent> PCComponents = productService.findAllComponentType(ComponentType.valueOf(componentType));
            model.addAttribute("productList", PCComponents);
            model.addAttribute("tableActive", true);
        }
        return "componentSearch";
    }

}
