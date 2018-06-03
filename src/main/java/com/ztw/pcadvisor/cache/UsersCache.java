package com.ztw.pcadvisor.cache;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * The Users cache.
 */
@Component
public class UsersCache {

    /**
     * The Repository.
     */
    @Autowired
    UserRepository repository;

    /**
     * Get user user.
     *
     * @param username the username
     * @return the user
     */
    @Cacheable(value = "userCache", key = "#username")
    public User getUser(String username){
        System.out.println("Caching user now!!!");
        return repository.findByUserName(username);
    }

}
