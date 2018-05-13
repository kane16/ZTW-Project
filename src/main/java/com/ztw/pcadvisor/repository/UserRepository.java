package com.ztw.pcadvisor.repository;


import com.ztw.pcadvisor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassword(String username, String password);

    User findByUserName(String username);

    User findByConfirmationToken(String confirmationToken);

}
