package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorRepository extends JpaRepository<Processor, Long> {

    Processor findByCpuID(long cpuID);

}
