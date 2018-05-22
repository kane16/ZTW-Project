package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.*;
import com.ztw.pcadvisor.repository.GCRepository;
import com.ztw.pcadvisor.repository.PowerSupplyRepository;
import com.ztw.pcadvisor.repository.ProcessorRepository;
import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    GCRepository gcRepository;

    @Autowired
    ProcessorRepository processorRepository;

    @Autowired
    PowerSupplyRepository powerSupplyRepository;


    @RequestMapping("/admin")
    public String admin(){
        return "adminSite";
    }

    @PostMapping("/admin/changePassword")
    public String adminChangePassword(
            @ModelAttribute("usernameToChange") String username,
            @ModelAttribute("passwordToChange") String password,
            @ModelAttribute("repeatPasswordToChange") String passwordConfirmation
    ){
        User user = userService.findByUserName(username);
        if(password.equals(passwordConfirmation) && user != null){
            user.setPassword(password);
            userService.updateUser(user);
        }
        return "adminSite";
    }

    @PostMapping("/admin/deleteUser")
    public String adminDeleteUser(
            @ModelAttribute("usernameToDelete") String usernameToDelete
    ){
        userService.deleteUser(usernameToDelete);
        return "adminSite";
    }

    @PostMapping("/admin/addPart")
    public String adminAddPart(
            @ModelAttribute("partName") String partName,
            @ModelAttribute("componentType") String componentType,
            @ModelAttribute("componentName") String componentName
    ) throws IOException {
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:/Components.txt");
        File file = resource.getFile();
        Scanner sc = new Scanner(file);
        sc.useDelimiter(";");
        while(sc.hasNext()){
            String name = sc.next();
            String url = sc.next();
            double price = Double.parseDouble(sc.next());
            String producer = sc.next();
            boolean isPartName = name.contains(partName);
            if(isPartName){
                if(componentType.equals(ComponentType.GraphicCard.toString())){
                    GraphicCard gc = new GraphicCard();
                    gc.setName(name);
                    gc.setPicture(url);
                    gc.setPrice(price);
                    gc.setCardProducer(producer);
                    gcRepository.save(gc);
                }else if(componentName.equals(ComponentType.Processor.toString())){
                    Processor processor = new Processor();
                    processor.setName(name);
                    processor.setPictureURL(url);
                    processor.setPrice(price);
                    processor.setProducer(producer);
                    processorRepository.save(processor);
                }else if(componentName.equals(ComponentType.PowerSupply.toString())){
                    PowerSupply powerSupply = new PowerSupply();
                    powerSupply.setName(name);
                    powerSupply.setPicture(url);
                    powerSupply.setPrice(price);
                    powerSupply.setProducer(producer);
                    powerSupplyRepository.save(powerSupply);
                }
            }
            sc.nextLine();
        }
        return "adminSite";
    }



}
