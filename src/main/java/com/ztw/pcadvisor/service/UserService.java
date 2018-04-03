package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserRole;
import com.ztw.pcadvisor.repository.RoleRepository;
import com.ztw.pcadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public boolean passwordConfirmed(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

    public boolean isPasswordSecure(String password){
        if(password.length()<3 || password.length()>30)
            return false;
        return true;
    }

    public void createUser(User user, Set<UserRole> userRoles){
        User newUser = userRepository.findByUserName(user.getUserName());

        if(newUser != null){

        }


    }


}
