package com.ztw.pcadvisor.controller;

import com.ztw.pcadvisor.model.Component;
import com.ztw.pcadvisor.model.ComponentType;
import com.ztw.pcadvisor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class APIController {


    @Autowired
    ProductService productService;

    @GetMapping(value = "/all")
    public List<Map<String, String>> findAll(@RequestParam(value = "componentType", required = false) String componentType){
        List<Component> allItems = productService.getProducersAndComponents();

        ArrayList<Map<String, String>> allItemsProducers = new ArrayList<>();

        for (Component component: allItems){
            HashMap<String, String> map = new HashMap<>();
            map.put(component.getComponentType().toString(),component.getProducer());
            allItemsProducers.add(map);
        }

        if(componentType != null){
            List<Map<String, String>> toShow = new ArrayList<>();
            Iterator it = allItems.iterator();
            while(it.hasNext()){
                Component component = (Component) it.next();
                if(component.getComponentType().equals(ComponentType.valueOf(componentType))){
                    HashMap<String, String> map = new HashMap<>();
                    map.put(component.getComponentType().toString(),component.getProducer());
                    toShow.add(map);
                }
            }
            return toShow;
        }

        return allItemsProducers;
    }


}
