package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PowerSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int powerSupplyID;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private int powerSupplyPower;

    @Column
    private String producer;

    @Column
    private String model;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pcCase")
    private Set<PCConfiguration> configurations = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPowerSupplyID() {
        return powerSupplyID;
    }

    public void setPowerSupplyID(int powerSupplyID) {
        this.powerSupplyID = powerSupplyID;
    }

    public int getPowerSupplyPower() {
        return powerSupplyPower;
    }

    public void setPowerSupplyPower(int powerSupplyPower) {
        this.powerSupplyPower = powerSupplyPower;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<PCConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Set<PCConfiguration> configurations) {
        this.configurations = configurations;
    }

}
