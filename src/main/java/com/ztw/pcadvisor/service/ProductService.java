package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.Component;
import com.ztw.pcadvisor.model.ComponentType;
import com.ztw.pcadvisor.model.GraphicCard;
import com.ztw.pcadvisor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    private List<Component> producersAndComponents;

    public ProductService() {
        producersAndComponents = new ArrayList<>();
        producersAndComponents.add(new Component(1,ComponentType.Processor, "AMD"));
        producersAndComponents.add(new Component(2,ComponentType.Processor, "Intel"));
        producersAndComponents.add(new Component(3,ComponentType.GraphicCard, "Radeon"));
        producersAndComponents.add(new Component(4,ComponentType.GraphicCard, "Nvidia"));
        producersAndComponents.add(new Component(5,ComponentType.GraphicCard, "Gigabyte"));
        producersAndComponents.add(new Component(6,ComponentType.GraphicCard, "Arez"));
    }

    public List<Component> getProducersAndComponents(){
        return producersAndComponents;
    }

    public List<GraphicCard> findAllProductsLike(String name){
        List<GraphicCard> graphicCards = productRepository.findByNameContaining(name);
        return graphicCards;
    }

}
