package com.ztw.pcadvisor.repository;


import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by username and password.
     *
     * @param username the username
     * @param password the password
     * @return the user
     */
    User findByUserNameAndPassword(String username, String password);

    /**
     * Find user by username.
     *
     * @param username the username
     * @return the user
     */
    User findByUserName(String username);

    /**
     * Find user by confirmation token.
     *
     * @param confirmationToken the confirmation token
     * @return the user
     */
    User findByConfirmationToken(String confirmationToken);

    /**
     * Find list of users by user role.
     *
     * @param userRole the user role
     * @return the list
     */
    List<User> findByUserRole(UserRole userRole);

}
