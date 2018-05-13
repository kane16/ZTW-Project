package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);

}
