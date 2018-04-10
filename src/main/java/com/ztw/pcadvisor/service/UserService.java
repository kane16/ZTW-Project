package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public boolean isPasswordCorrectlyConfirmed(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

    public boolean isPasswordSecure(String password){
        Pattern p = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])");
        Matcher m = p.matcher(password);
        return password.length()>3 && password.length()<30 && m.find();
    }

    public boolean createUser(User user){

        User newUser = userRepository.findByUserName(user.getUserName());

        if(newUser == null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }

        return false;

    }

    public boolean updateUser(User user){

        User updatedUser = userRepository.findByUserName(user.getUserName());

        if(updatedUser != null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }

        return false;
    }


    public User findByConfirmationToken(String confirmationToken){
        return userRepository.findByConfirmationToken(confirmationToken);
    }



}
