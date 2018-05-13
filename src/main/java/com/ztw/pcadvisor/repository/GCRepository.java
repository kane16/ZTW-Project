package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.GraphicCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GCRepository extends JpaRepository<GraphicCard, Long> {

    List<GraphicCard> findByNameContaining(String name);

    GraphicCard findByGpuID(long gpuID);

    List<GraphicCard> findAll();

}
