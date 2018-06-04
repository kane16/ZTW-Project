package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.GraphicCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Graphic Card repository.
 */
@Repository
public interface GCRepository extends JpaRepository<GraphicCard, Long> {

    /**
     * Find by name containing Graphic Card with name.
     *
     * @param name the name
     * @return the list
     */
    List<GraphicCard> findByNameContaining(String name);

    /**
     * Find by gpu id graphic card.
     *
     * @param gpuID the gpu id
     * @return the graphic card
     */
    GraphicCard findByGpuID(long gpuID);

    List<GraphicCard> findAll();

}
