package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.PCConfiguration;
import com.ztw.pcadvisor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Configuration repository.
 */
@Repository
public interface ConfigurationRepository extends JpaRepository<PCConfiguration, Long> {

    /**
     * Find by user PCConfiguration.
     *
     * @param user the user
     * @return the pc configuration
     */
    PCConfiguration findByUser(User user);

}
