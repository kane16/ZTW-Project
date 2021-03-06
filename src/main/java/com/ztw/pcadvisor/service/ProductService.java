package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.*;
import com.ztw.pcadvisor.repository.GCRepository;
import com.ztw.pcadvisor.repository.PowerSupplyRepository;
import com.ztw.pcadvisor.repository.ProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The product service.
 */
@Service
public class ProductService {

    /**
     * The graphic card repository.
     */
    @Autowired
    GCRepository GCRepository;

    /**
     * The Processor repository.
     */
    @Autowired
    ProcessorRepository processorRepository;

    /**
     * The Power supply repository.
     */
    @Autowired
    PowerSupplyRepository powerSupplyRepository;

    private List<PCComponent> producersAndPCComponents;

    /**
     * Instantiates a new Product service.
     */
    public ProductService() {
        producersAndPCComponents = new ArrayList<>();
        producersAndPCComponents.add(new PCComponent(1,ComponentType.Processor, "AMD"));
        producersAndPCComponents.add(new PCComponent(2,ComponentType.Processor, "Intel"));
        producersAndPCComponents.add(new PCComponent(3,ComponentType.GraphicCard, "Radeon"));
        producersAndPCComponents.add(new PCComponent(4,ComponentType.GraphicCard, "Nvidia"));
        producersAndPCComponents.add(new PCComponent(5,ComponentType.GraphicCard, "Gigabyte"));
        producersAndPCComponents.add(new PCComponent(6, ComponentType.GraphicCard, "Asus"));
        producersAndPCComponents.add(new PCComponent(7, ComponentType.PowerSupply, "Chieftec"));
        producersAndPCComponents.add(new PCComponent(8, ComponentType.PowerSupply, "Corsair"));
    }

    /**
     * Get producers and pc components list.
     *
     * @return the list
     */
    public List<PCComponent> getProducersAndPCComponents(){
        return producersAndPCComponents;
    }

    /**
     * Find all products with name like parameter.
     *
     * @param name the name
     * @return the list
     */
    public List<PCComponent> findAllProductsLike(String name){
        List<GraphicCard> graphicCards = GCRepository.findByNameContaining(name);
        List<Processor> processors = processorRepository.findByNameContaining(name);
        List<PowerSupply> powerSupplies = powerSupplyRepository.findByNameContaining(name);
        List<PCComponent> PCComponents = new ArrayList<>();
        for(GraphicCard graphicCard: graphicCards){
            PCComponents.add(new PCComponent(graphicCard.getGpuID(), ComponentType.GraphicCard, graphicCard.getCardProducer(),
                    graphicCard.getPrice(), graphicCard.getName(), graphicCard.getPicture()));
        }
        for(Processor processor: processors){
            PCComponents.add(new PCComponent(processor.getCpuID(), ComponentType.Processor, processor.getProducer(),
                    processor.getPrice(), processor.getName(), processor.getPictureURL()));
        }
        for(PowerSupply powerSupply: powerSupplies){
            PCComponents.add(new PCComponent(powerSupply.getPowerSupplyID(), ComponentType.PowerSupply, powerSupply.getProducer(),
                    powerSupply.getPrice(), powerSupply.getName(), powerSupply.getPicture()));
        }
        return PCComponents;
    }

    /**
     * Find all components by component type.
     *
     * @param type the type
     * @return the list
     */
    public List<PCComponent> findAllComponents(ComponentType type){
        List<PCComponent> PCComponents = new ArrayList<>();
        if(type.equals(ComponentType.valueOf("GraphicCard"))){
            List<GraphicCard> graphicCards = GCRepository.findAll();
            for(GraphicCard graphicCard: graphicCards){
                PCComponents.add(new PCComponent(graphicCard.getGpuID(), ComponentType.GraphicCard, graphicCard.getCardProducer(),
                        graphicCard.getPrice(), graphicCard.getName(), graphicCard.getPicture()));
            }
        }
        if(type.equals(ComponentType.valueOf("Processor"))){
            List<Processor> processors = processorRepository.findAll();
            for(Processor processor: processors){
                PCComponents.add(new PCComponent(processor.getCpuID(), ComponentType.Processor, processor.getProducer(),
                        processor.getPrice(), processor.getName(), processor.getPictureURL()));
            }
        }
        if(type.equals(ComponentType.valueOf("PowerSupply"))){
            List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
            for(PowerSupply powerSupply: powerSupplies){
                PCComponents.add(new PCComponent(powerSupply.getPowerSupplyID(), ComponentType.PowerSupply, powerSupply.getProducer(),
                        powerSupply.getPrice(), powerSupply.getName(), powerSupply.getPicture()));
            }
        }
        return PCComponents;
    }

}
