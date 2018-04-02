package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserRole;
import com.ztw.pcadvisor.repository.RoleRepository;
import com.ztw.pcadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }


    public User findByUserNameAndPassword(String username, String password){
        return userRepository.findByUserNameAndPassword(username, password);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void saveUser(User user){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setActive(1);
        UserRole role = roleRepository.findByName("ADMIN");
        user.setRoles(new HashSet<UserRole>(Arrays.asList(role)));
        userRepository.save(user);
    }


}
