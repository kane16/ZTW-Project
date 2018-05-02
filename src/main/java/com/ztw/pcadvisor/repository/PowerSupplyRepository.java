package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

    PowerSupply findByPowerSupplyID(int powerSupplyId);

}
