package com.ztw.pcadvisor.repository;


import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassword(String username, String password);

    List<User> findByUserName(String username);

    User findByConfirmationToken(String confirmationToken);

    List<User> findByUserRole(UserRole userRole);

}
