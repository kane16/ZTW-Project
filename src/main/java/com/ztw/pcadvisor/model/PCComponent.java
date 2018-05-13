package com.ztw.pcadvisor.model;


import org.springframework.stereotype.Component;

@Component
public class PCComponent {

    private long id;
    private ComponentType componentType;
    private String producer;
    private double price;
    private String name;
    private String pictureURL;

    public PCComponent(long id, ComponentType componentType, String producer, double price, String name, String pictureURL) {
        this.id = id;
        this.componentType = componentType;
        this.producer = producer;
        this.price = price;
        this.name = name;
        this.pictureURL = pictureURL;
    }

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

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
