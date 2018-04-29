package com.ztw.pcadvisor.model;



public class Component {

    private long id;
    private ComponentType componentType;
    private String producer;

    public Component(long id, ComponentType componentType, String producer) {
        this.id = id;
        this.componentType = componentType;
        this.producer = producer;
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
