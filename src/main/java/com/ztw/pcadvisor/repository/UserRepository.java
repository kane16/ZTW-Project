package com.ztw.pcadvisor.repository;


import com.ztw.pcadvisor.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
