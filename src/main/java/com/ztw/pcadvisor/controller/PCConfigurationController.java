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

/**
 * The PC configuration controller.
 */
@Controller
public class PCConfigurationController {

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * The Configuration repository.
     */
    @Autowired
    ConfigurationRepository configurationRepository;

    /**
     * Gets PCConfiguration site.
     *
     * @param model     the model
     * @param principal the principal
     * @param currency  the currency
     * @return the pc configuration site
     * @throws IOException the io exception
     */
    @GetMapping("/pcconfig")
    public String getPCConfigurationSite(Model model, Principal principal,
                                         @RequestParam(value = "currency", required = false) String currency) throws IOException {
        User user = userRepository.findByUserName(principal.getName());
        PCConfiguration pcConfiguration = user.getPcConfiguration();
        GraphicCard graphicCard = null;
        Processor processor = null;
        PowerSupply powerSupply = null;
        double total = 0;
        double ratingsSum = 0;
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
            if(user.getUserType().equals(UserType.Standardowy)){
                model.addAttribute("gcRating", String.format("%.1f", graphicCard.getRating()));
                ratingsSum += graphicCard.getRating();
            }else if(user.getUserType().equals(UserType.Gracz)){
                model.addAttribute("gcRating", String.format("%.1f", graphicCard.getRating()));
                ratingsSum += graphicCard.getRating()*4;
            }else{
                model.addAttribute("gcRating", String.format("%.1f", graphicCard.getRating()));
                ratingsSum += graphicCard.getRating()*3;
            }

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
            if(user.getUserType().equals(UserType.Standardowy)){
                ratingsSum += processor.getRating();
                model.addAttribute("processorRating", String.format("%.1f", processor.getRating()));
            }else if(user.getUserType().equals(UserType.Gracz)){
                ratingsSum += processor.getRating()*2;
                model.addAttribute("processorRating", String.format("%.1f", processor.getRating()));
            }else{
                model.addAttribute("processorRating", String.format("%.1f", processor.getRating()));
                ratingsSum += processor.getRating()*3;
            }
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
            model.addAttribute("powerSupplyRating", String.format("%.1f", powerSupply.getRating()));
            ratingsSum += powerSupply.getRating();
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
        if(graphicCard != null && processor != null && powerSupply != null){
            model.addAttribute("isAllComponents", true);
            if(user.getUserType().equals(UserType.Standardowy)){
                model.addAttribute("allRating", String.format("%.1f", ratingsSum/3));
            }else if(user.getUserType().equals(UserType.Gracz)){
                model.addAttribute("allRating", String.format("%.1f", ratingsSum/7));
            }else{
                model.addAttribute("allRating", String.format("%.1f", ratingsSum/7));
            }
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
