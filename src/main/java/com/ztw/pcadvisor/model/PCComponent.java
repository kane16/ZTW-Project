package com.ztw.pcadvisor.model;


import org.springframework.stereotype.Component;

/**
 * The PC component.
 */
@Component
public class PCComponent {

    private long id;
    private ComponentType componentType;
    private String producer;
    private double price;
    private String name;
    private String pictureURL;

    /**
     * Instantiates a new PCComponent.
     *
     * @param id            the id
     * @param componentType the component type
     * @param producer      the producer
     * @param price         the price
     * @param name          the name
     * @param pictureURL    the picture url
     */
    public PCComponent(long id, ComponentType componentType, String producer, double price, String name, String pictureURL) {
        this.id = id;
        this.componentType = componentType;
        this.producer = producer;
        this.price = price;
        this.name = name;
        this.pictureURL = pictureURL;
    }

    /**
     * Instantiates a new PCComponent.
     *
     * @param id            the id
     * @param componentType the component type
     * @param producer      the producer
     */
    public PCComponent(long id, ComponentType componentType, String producer) {
        this.id = id;
        this.componentType = componentType;
        this.producer = producer;
    }

    /**
     * Instantiates a new PCComponent.
     */
    public PCComponent(){

    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets component type.
     *
     * @return the component type
     */
    public ComponentType getComponentType() {
        return componentType;
    }

    /**
     * Sets component type.
     *
     * @param componentType the component type
     */
    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    /**
     * Gets producer.
     *
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Sets producer.
     *
     * @param producer the producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * Gets picture url.
     *
     * @return the picture url
     */
    public String getPictureURL() {
        return pictureURL;
    }

    /**
     * Sets picture url.
     *
     * @param pictureURL the picture url
     */
    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
