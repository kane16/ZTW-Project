package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.GraphicCard;
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
    public String searchComponent(Model model, @RequestParam(value = "componentCode", required = false) String componentCode){
        if(componentCode!=null){
            List<GraphicCard> graphicCardsLikeCode = productService.findAllProductsLike(componentCode);
            model.addAttribute("productList", graphicCardsLikeCode);
            model.addAttribute("tableActive", true);
        }
        return "componentSearch";
    }

}
