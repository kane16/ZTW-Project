package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

    PowerSupply findByPowerSupplyID(int powerSupplyId);

    PowerSupply findByName(String name);

    List<PowerSupply> findByNameContaining(String name);

}
