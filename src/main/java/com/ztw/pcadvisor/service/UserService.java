package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.CustomUserDetails;
import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserRole;
import com.ztw.pcadvisor.repository.RoleRepository;
import com.ztw.pcadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean VerifyPasword(User user, String rawPassword){
        return bCryptPasswordEncoder.matches(rawPassword, user.getPassword());
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
            UserRole userRole = roleRepository.findByName("ROLE_USER");
            if(roleRepository.findByName("ROLE_USER")!=null){

            }else{
                userRole = new UserRole();
                userRole.setName("ROLE_USER");
                Set<User> userSet = userRole.getUsers();
                userSet.add(user);
                roleRepository.save(userRole);
            }
            user.setUserRole(userRole);
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

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        String userRole = user.getUserRole().getName();
        return new CustomUserDetails(user, userRole);
    }
}
