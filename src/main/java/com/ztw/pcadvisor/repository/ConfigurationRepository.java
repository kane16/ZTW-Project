package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.PCConfiguration;
import com.ztw.pcadvisor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<PCConfiguration, Long> {

    PCConfiguration findByUser(User user);

}
