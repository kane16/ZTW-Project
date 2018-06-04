package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The power supply.
 */
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

    @Column
    private String picture;

    @Column
    private double rating;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pcCase")
    private Set<PCConfiguration> configurations = new HashSet<>();

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
     * Gets power supply id.
     *
     * @return the power supply id
     */
    public int getPowerSupplyID() {
        return powerSupplyID;
    }

    /**
     * Sets power supply id.
     *
     * @param powerSupplyID the power supply id
     */
    public void setPowerSupplyID(int powerSupplyID) {
        this.powerSupplyID = powerSupplyID;
    }

    /**
     * Gets power supply power.
     *
     * @return the power supply power
     */
    public int getPowerSupplyPower() {
        return powerSupplyPower;
    }

    /**
     * Sets power supply power.
     *
     * @param powerSupplyPower the power supply power
     */
    public void setPowerSupplyPower(int powerSupplyPower) {
        this.powerSupplyPower = powerSupplyPower;
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
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets configurations.
     *
     * @return the configurations
     */
    public Set<PCConfiguration> getConfigurations() {
        return configurations;
    }

    /**
     * Sets configurations.
     *
     * @param configurations the configurations
     */
    public void setConfigurations(Set<PCConfiguration> configurations) {
        this.configurations = configurations;
    }

    /**
     * Gets picture.
     *
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets picture.
     *
     * @param picture the picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
}
