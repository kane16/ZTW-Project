package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.PCComponent;
import com.ztw.pcadvisor.model.ComponentType;
import com.ztw.pcadvisor.model.GraphicCard;
import com.ztw.pcadvisor.repository.GCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    GCRepository GCRepository;

    private List<PCComponent> producersAndPCComponents;

    public ProductService() {
        producersAndPCComponents = new ArrayList<>();
        producersAndPCComponents.add(new PCComponent(1,ComponentType.Processor, "AMD"));
        producersAndPCComponents.add(new PCComponent(2,ComponentType.Processor, "Intel"));
        producersAndPCComponents.add(new PCComponent(3,ComponentType.GraphicCard, "Radeon"));
        producersAndPCComponents.add(new PCComponent(4,ComponentType.GraphicCard, "Nvidia"));
        producersAndPCComponents.add(new PCComponent(5,ComponentType.GraphicCard, "Gigabyte"));
        producersAndPCComponents.add(new PCComponent(6,ComponentType.GraphicCard, "Arez"));
    }

    public List<PCComponent> getProducersAndPCComponents(){
        return producersAndPCComponents;
    }

    public List<PCComponent> findAllProductsLike(String name){
        List<GraphicCard> graphicCards = GCRepository.findByNameContaining(name);
        List<PCComponent> PCComponents = new ArrayList<>();
        for(GraphicCard graphicCard: graphicCards){
            PCComponents.add(new PCComponent(graphicCard.getGpuID(), ComponentType.GraphicCard, graphicCard.getCardProducer()));
        }
        return PCComponents;
    }

    public List<PCComponent> findAllComponentType(ComponentType type){
        List<GraphicCard> graphicCards = GCRepository.findAll();
        List<PCComponent> PCComponents = new ArrayList<>();
        for(GraphicCard graphicCard: graphicCards){
            PCComponents.add(new PCComponent(graphicCard.getGpuID(), ComponentType.GraphicCard, graphicCard.getCardProducer()));
        }
        return PCComponents;
    }

}
