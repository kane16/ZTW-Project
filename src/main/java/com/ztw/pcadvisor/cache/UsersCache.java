package com.ztw.pcadvisor.cache;

import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UsersCache {

    @Autowired
    UserRepository repository;

    @Cacheable(value = "userCache", key = "#username")
    public User getUser(String username){
        System.out.println("Caching user now!!!");
        return repository.findByUserName(username);
    }

}
