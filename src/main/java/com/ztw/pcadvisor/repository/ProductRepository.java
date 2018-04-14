package com.ztw.pcadvisor.repository;

import com.ztw.pcadvisor.model.GraphicCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<GraphicCard, Long> {

    List<GraphicCard> findByNameContaining(String name);

}
