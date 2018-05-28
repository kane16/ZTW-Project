package com.ztw.pcadvisor.config;

import com.ztw.pcadvisor.model.*;
import com.ztw.pcadvisor.repository.*;
import com.ztw.pcadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    GCRepository gcRepository;

    @Autowired
    ProcessorRepository processorRepository;

    @Autowired
    PowerSupplyRepository powerSupplyRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createAllUsers();
        addComponents();
    }

    private void createAllUsers(){
        User user = new User();
        user.setUserName("kane16");
        user.setUserType(UserType.Standardowy);
        user.setPassword(userService.encryptPassword("guimis1"));
        UserRole userRoleAdmin = new UserRole();
        userRoleAdmin.setName("ROLE_ADMIN");
        user.setUserType(UserType.Standardowy);
        UserRole userRoleUser = new UserRole();
        userRoleUser.setName("ROLE_USER");
        roleRepository.save(userRoleUser);
        roleRepository.save(userRoleAdmin);
        user.setUserRole(userRoleAdmin);
        User secondUser = new User();
        secondUser.setUserType(UserType.Gracz);
        secondUser.setUserName("adam2222");
        secondUser.setPassword(userService.encryptPassword("Guimis111!"));
        secondUser.setUserRole(userRoleUser);
        userRepository.save(user);
        userRepository.save(secondUser);
    }

    private void addComponents(){
        GraphicCard graphicCard = new GraphicCard();
        graphicCard.setName("GeForce 1070");
        graphicCard.setPicture("https://images.morele.net/full/774260_0_f.png");
        graphicCard.setCardProducer("Gigabyte");
        graphicCard.setPrice(2169.00);
        graphicCard.setRating(9.0);
        Processor processor = new Processor();
        processor.setName("i7 8700");
        processor.setPrice(1249.00);
        processor.setProducer("Intel");
        processor.setPictureURL("https://images.morele.net/full/978218_1_f.jpg");
        processor.setRating(10.0);
        PowerSupply powerSupply = new PowerSupply();
        powerSupply.setName("Supremo Gold M2");
        powerSupply.setProducer("SilentiumPC");
        powerSupply.setPowerSupplyPower(550);
        powerSupply.setPrice(299.00);
        powerSupply.setRating(10.0);
        powerSupply.setPicture("https://images.morele.net/full/774137_10_f.jpeg");
        gcRepository.save(graphicCard);
        processorRepository.save(processor);
        powerSupplyRepository.save(powerSupply);
    }


}
