package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.GraphicCard;
import com.ztw.pcadvisor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    private Set<String> processorProducers = new HashSet<>();
    private Set<String> graphicCardsProducers = new HashSet<>();

    private Map<String, Set<String>> producersAndComponents;

    public Map<String, Set<String>> getGetProducersAndComponents(){
        processorProducers.add("AMD");
        processorProducers.add("Intel");
        graphicCardsProducers.add("Radeon");
        graphicCardsProducers.add("Nvidia");
        producersAndComponents.put("Procesory", processorProducers);
        producersAndComponents.put("Karta graficzna", graphicCardsProducers);
        return producersAndComponents;
    }

    public List<GraphicCard> findAllProductsLike(String name){
        List<GraphicCard> graphicCards = productRepository.findByNameContaining(name);
        return graphicCards;
    }

}
