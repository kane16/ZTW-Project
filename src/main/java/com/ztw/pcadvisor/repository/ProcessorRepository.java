package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Processor repository.
 */
@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Long> {

    /**
     * Find processor by cpu id.
     *
     * @param cpuID the cpu id
     * @return the processor
     */
    Processor findByCpuID(long cpuID);

    /**
     * Find processor by processor name.
     *
     * @param name the name
     * @return the processor
     */
    Processor findByName(String name);

    /**
     * Find processors list by name containing processor name.
     *
     * @param name the name
     * @return the list
     */
    List<Processor> findByNameContaining(String name);

}
