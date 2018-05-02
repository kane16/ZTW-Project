package com.ztw.pcadvisor.model;


import org.springframework.stereotype.Component;

@Component
public class PCComponent {

    private long id;
    private ComponentType componentType;
    private String producer;
    private double price;
    private String name;

    public PCComponent(long id, ComponentType componentType, String producer) {
        this.id = id;
        this.componentType = componentType;
        this.producer = producer;
    }

    public PCComponent(){

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
