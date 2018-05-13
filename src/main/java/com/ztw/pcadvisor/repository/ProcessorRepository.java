package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Long> {

    Processor findByCpuID(long cpuID);

    Processor findByName(String name);

    List<Processor> findByNameContaining(String name);

}
