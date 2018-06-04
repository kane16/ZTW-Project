package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.cache.UsersCache;
import com.ztw.pcadvisor.model.CustomUserDetails;
import com.ztw.pcadvisor.model.PCConfiguration;
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

/**
 * The user service.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersCache userCache;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Encrypt password.
     *
     * @param password the password
     * @return the string
     */
    public String encryptPassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    /**
     * Verify password.
     *
     * @param user        the user
     * @param rawPassword the raw password
     * @return the boolean
     */
    public boolean VerifyPasword(User user, String rawPassword){
        return bCryptPasswordEncoder.matches(rawPassword, user.getPassword());
    }

    /**
     * Gets all users.
     *
     * @return the list
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Checks if password is correctly confirmed.
     *
     * @param password        the password
     * @param confirmPassword the confirm password
     * @return the boolean
     */
    public boolean isPasswordCorrectlyConfirmed(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

    /**
     * Checks if password is secure.
     *
     * @param password the password
     * @return the boolean
     */
    public boolean isPasswordSecure(String password){
        Pattern p = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])");
        Matcher m = p.matcher(password);
        return password.length()>3 && password.length()<30 && m.find();
    }

    /**
     * Creates user boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean createUser(User user){

        User newUser = userRepository.findByUserName(user.getUserName());

        if(newUser == null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setPcConfiguration(new PCConfiguration());
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

    /**
     * Updates user.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean updateUser(User user){

        User updatedUser = userRepository.findByUserName(user.getUserName());

        if(updatedUser != null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }

        return false;
    }


    /**
     * Deletes user.
     *
     * @param username the username
     */
    public void deleteUser(String username){
        User user = userRepository.findByUserName(username);
        if(user != null && !user.getUserRole().getName().equals("ROLE_ADMIN")){
            userRepository.delete(user);
        }
    }

    /**
     * Find user by username.
     *
     * @param userName the user name
     * @return the user
     */
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userCache.getUser(username);
        String userRole = user.getUserRole().getName();
        return new CustomUserDetails(user, userRole);
    }

    /**
     * Find all standard users.
     *
     * @return the list
     */
    public List<User> findAllStandardUsers(){
        return userRepository.findByUserRole(roleRepository.findByName("ROLE_USER"));
    }

}
