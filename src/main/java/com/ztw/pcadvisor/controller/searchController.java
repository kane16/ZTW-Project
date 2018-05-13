package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.*;
import com.ztw.pcadvisor.repository.ConfigurationRepository;
import com.ztw.pcadvisor.repository.GCRepository;
import com.ztw.pcadvisor.repository.PowerSupplyRepository;
import com.ztw.pcadvisor.repository.ProcessorRepository;
import com.ztw.pcadvisor.service.ProductService;
import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class searchController {

    @Autowired
    ProductService productService;

    @Autowired
    GCRepository gcRepository;

    @Autowired
    UserService userService;

    @Autowired
    ConfigurationRepository configurationRepository;

    @Autowired
    ProcessorRepository processorRepository;

    @Autowired
    PowerSupplyRepository powerSupplyRepository;


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

    @GetMapping("/search/add")
    public String addComponenentToSet(@RequestParam(value = "componentType") String componentType,
                                      @RequestParam(value = "id") int id,
                                      Principal principal){
        User user = userService.findByUserName(principal.getName());
        PCConfiguration pcConfiguration;
        if(user.getPcConfiguration() != null){
            pcConfiguration = user.getPcConfiguration();
        }else {
            pcConfiguration = new PCConfiguration();
            pcConfiguration.setUser(user);
        }
        if(componentType.equals("GraphicCard")){
            pcConfiguration.setGraphicCard(gcRepository.findByGpuID(id));
            configurationRepository.save(pcConfiguration);
        }
        if(componentType.equals("Processor")){
            pcConfiguration.setProcessor(processorRepository.findByCpuID(id));
            configurationRepository.save(pcConfiguration);
        }
        if(componentType.equals("PowerSupply")){
            pcConfiguration.setPowerSupply(powerSupplyRepository.findByPowerSupplyID(id));
            configurationRepository.save(pcConfiguration);
        }
        return "componentSearch";
    }

}
