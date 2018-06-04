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

/**
 * The type Admin controller.
 */
@Controller
public class AdminController {

    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * The Resource loader.
     */
    @Autowired
    ResourceLoader resourceLoader;

    /**
     * The Graphic Card repository.
     */
    @Autowired
    GCRepository gcRepository;

    /**
     * The Processor repository.
     */
    @Autowired
    ProcessorRepository processorRepository;

    /**
     * The Power supply repository.
     */
    @Autowired
    PowerSupplyRepository powerSupplyRepository;


    /**
     * Admin string.
     *
     * @return the string
     */
    @RequestMapping("/admin")
    public String admin(){
        return "adminSite";
    }

    /**
     * Admin change password string.
     *
     * @param username             the username
     * @param password             the password
     * @param passwordConfirmation the password confirmation
     * @return the string
     */
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

    /**
     * Admin delete user string.
     *
     * @param usernameToDelete the username to delete
     * @return the string
     */
    @PostMapping("/admin/deleteUser")
    public String adminDeleteUser(
            @ModelAttribute("usernameToDelete") String usernameToDelete
    ){
        userService.deleteUser(usernameToDelete);
        return "adminSite";
    }

    /**
     * Adding part in admin panel.
     *
     * @param partName      the part name
     * @param componentType the component type
     * @param componentName the component name
     * @return the string
     * @throws IOException the io exception
     */
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
            ComponentType type = ComponentType.valueOf(sc.next());
            double rating = sc.nextDouble();
            boolean isPartName = name.contains(partName);
            boolean isCorrectComponentType = type.equals(ComponentType.valueOf(componentType));
            if(isPartName && isCorrectComponentType){
                if(componentType.equals(ComponentType.GraphicCard.toString())){
                    GraphicCard gc = new GraphicCard();
                    gc.setName(name);
                    gc.setPicture(url);
                    gc.setPrice(price);
                    gc.setCardProducer(producer);
                    gc.setRating(rating);
                    gcRepository.save(gc);
                }else if(componentName.equals(ComponentType.Processor.toString())){
                    Processor processor = new Processor();
                    processor.setName(name);
                    processor.setPictureURL(url);
                    processor.setPrice(price);
                    processor.setProducer(producer);
                    processor.setRating(rating);
                    processorRepository.save(processor);
                }else if(componentName.equals(ComponentType.PowerSupply.toString())){
                    PowerSupply powerSupply = new PowerSupply();
                    powerSupply.setName(name);
                    powerSupply.setPicture(url);
                    powerSupply.setPrice(price);
                    powerSupply.setProducer(producer);
                    powerSupply.setRating(rating);
                    powerSupplyRepository.save(powerSupply);
                }
            }
            sc.nextLine();
        }
        return "adminSite";
    }



}
