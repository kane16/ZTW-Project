package com.ztw.pcadvisor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztw.pcadvisor.model.*;
import com.ztw.pcadvisor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URL;
import java.security.Principal;

@Controller
public class PCConfigurationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfigurationRepository configurationRepository;

    @GetMapping("/pcconfig")
    public String getPCConfigurationSite(Model model, Principal principal,
                                         @RequestParam(value = "currency", required = false) String currency) throws IOException {
        User user = userRepository.findByUserName(principal.getName());
        PCConfiguration pcConfiguration = user.getPcConfiguration();
        GraphicCard graphicCard = null;
        Processor processor = null;
        PowerSupply powerSupply = null;
        double total = 0;
        EuroBaseConversion euroBaseConversion = null;
        if(pcConfiguration!=null){
            graphicCard = pcConfiguration.getGraphicCard();
            processor = pcConfiguration.getProcessor();
            powerSupply = pcConfiguration.getPowerSupply();
        }
        model.addAttribute("user", "Witaj, "+user.getUserName()+", id: "+user.getUserId());
        if(graphicCard!=null){
            model.addAttribute("isGraphicCard", true);
            model.addAttribute("graphicCardName", graphicCard.getName());
            if(currency == null){
                model.addAttribute("graphicCardPrice", String.format("%.2f",graphicCard.getPrice())+" zł");
            }else if(currency.equals("euro")){
                euroBaseConversion = fetchConverted();
                model.addAttribute("graphicCardPrice", String.format("%.2f",graphicCard.getPrice()/euroBaseConversion.getRates().getPln())+" €");
            }else if(currency.equals("usd")){
                euroBaseConversion = fetchConverted();
                model.addAttribute("graphicCardPrice", String.format("%.2f",graphicCard.getPrice()/euroBaseConversion.getRates().getPln()*euroBaseConversion.getRates().getUsd())+" $");
            }
            total += graphicCard.getPrice();
        }else model.addAttribute("isGraphicCard", false);
        if(processor!=null) {
            model.addAttribute("isProcessor", true);
            model.addAttribute("processorsName", processor.getName());
            if(currency == null){
                model.addAttribute("processorPrice", String.format("%.2f",processor.getPrice())+" zł");
            }else if(currency.equals("euro")){
                euroBaseConversion = fetchConverted();
                model.addAttribute("processorPrice", String.format("%.2f",processor.getPrice()/euroBaseConversion.getRates().getPln())+" €");
            }else if(currency.equals("usd")){
                euroBaseConversion = fetchConverted();
                model.addAttribute("processorPrice", String.format("%.2f",processor.getPrice()/euroBaseConversion.getRates().getPln()*euroBaseConversion.getRates().getUsd())+" $");
            }
            total += processor.getPrice();
        }else model.addAttribute("isProcessor", false);
        if(powerSupply != null){
            model.addAttribute("isPowerSupply", true);
            model.addAttribute("powerSupplyName", powerSupply.getName());
            if(currency == null){
                model.addAttribute("powerSupplyPrice", String.format("%.2f",powerSupply.getPrice())+" zł");
            }else if(currency.equals("euro")){
                euroBaseConversion = fetchConverted();
                model.addAttribute("powerSupplyPrice", String.format("%.2f",powerSupply.getPrice()/euroBaseConversion.getRates().getPln())+" €");
            }else if(currency.equals("usd")){
                euroBaseConversion = fetchConverted();
                model.addAttribute("powerSupplyPrice", String.format("%.2f",powerSupply.getPrice()/euroBaseConversion.getRates().getPln()*euroBaseConversion.getRates().getUsd())+" $");
            }
            total += powerSupply.getPrice();
        }else model.addAttribute("isPowerSupply", false);
        if(currency == null){
            model.addAttribute("total", String.format("%.2f",total)+" zł");
        }else if(currency.equals("euro")){
            euroBaseConversion = fetchConverted();
            model.addAttribute("total", String.format("%.2f",total/euroBaseConversion.getRates().getPln())+" €");
        }else if(currency.equals("usd")){
            euroBaseConversion = fetchConverted();
            model.addAttribute("total", String.format("%.2f",total/euroBaseConversion.getRates().getPln()*euroBaseConversion.getRates().getUsd())+" $");
        }
        return "pcConfigurationSite";
    }

    private EuroBaseConversion fetchConverted() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new URL("http://data.fixer.io/api/latest?access_key=e60efcada05f873be404d3250b20019e&symbols=PLN,USD"),
                EuroBaseConversion.class);
    }

}
