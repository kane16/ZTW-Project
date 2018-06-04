package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Power supply repository.
 */
@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

    /**
     * Find Power supply by power supply id.
     *
     * @param powerSupplyId the power supply id
     * @return the power supply
     */
    PowerSupply findByPowerSupplyID(int powerSupplyId);

    /**
     * Find Power supply by power supply name.
     *
     * @param name the name
     * @return the power supply
     */
    PowerSupply findByName(String name);

    /**
     * Find list of Power supplies by name containing list.
     *
     * @param name the name
     * @return the list
     */
    List<PowerSupply> findByNameContaining(String name);

}
