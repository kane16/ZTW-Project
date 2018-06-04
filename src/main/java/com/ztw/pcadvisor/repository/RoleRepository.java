package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Role repository.
 */
@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    /**
     * Find user role by name.
     *
     * @param name the name
     * @return the user role
     */
    UserRole findByName(String name);

}
