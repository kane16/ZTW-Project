package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserRole;
import com.ztw.pcadvisor.repository.RoleRepository;
import com.ztw.pcadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean createAdmin(){
        User user = new User();
        user.setFirstName("Łukasz");
        user.setLastName("Gumiński");
        user.setUserName("admin");
        user.setPassword(bCryptPasswordEncoder.encode("guimis1"));
        UserRole userRole = new UserRole();
        userRole.setName("ROLE_ADMIN");
        Set<User> userSet = userRole.getUsers();
        userSet.add(user);
        roleRepository.save(userRole);
        user.setUserRole(userRole);
        userRepository.save(user);
        return true;
    }

}
