package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.*;
import com.ztw.pcadvisor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class PCConfigurationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfigurationRepository configurationRepository;

    @RequestMapping("/pcconfig")
    public String getPCConfigurationSite(Model model, Principal principal){
        User user = userRepository.findByUserName(principal.getName());
        PCConfiguration pcConfiguration = user.getPcConfiguration();
        GraphicCard graphicCard = null;
        Processor processor = null;
        PowerSupply powerSupply = null;
        if(pcConfiguration!=null){
            graphicCard = pcConfiguration.getGraphicCard();
            processor = pcConfiguration.getProcessor();
            powerSupply = pcConfiguration.getPowerSupply();
        }
        model.addAttribute("user", "Witaj, "+user.getUserName()+", id: "+user.getUserId());
        if(graphicCard!=null){
            model.addAttribute("isGraphicCard", true);
            model.addAttribute("graphicCardName", graphicCard.getName());
            model.addAttribute("graphicCardPrice",graphicCard.getPrice()+" zł");
        }else model.addAttribute("isGraphicCard", false);
        if(processor!=null) {
            model.addAttribute("isProcessor", true);
            model.addAttribute("processorsName", processor.getName());
            model.addAttribute("processorPrice", processor.getPrice()+" zł");
        }else model.addAttribute("isProcessor", false);
        if(powerSupply != null){
            model.addAttribute("isPowerSupply", true);
            model.addAttribute("powerSupplyName", powerSupply.getName());
            model.addAttribute("powerSupplyPrice", powerSupply.getPrice()+" zł");
        }model.addAttribute("isPowerSupply", false);
        return "pcConfigurationSite";
    }

}
