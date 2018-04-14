package com.ztw.pcadvisor.service;

import com.ztw.pcadvisor.model.GraphicCard;
import com.ztw.pcadvisor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<GraphicCard> findAllProductsLike(String name){
        List<GraphicCard> graphicCards = productRepository.findByNameContaining(name);
        return graphicCards;
    }

}
