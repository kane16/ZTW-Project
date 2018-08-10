package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The RAM.
 */
@Entity
public class RAM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ramID;

    @Column
    private int size;

    @Column
    private int memoryFrequency;

    @Column
    private double price;

    @Column
    private double rankOfRAM;

    @Column
    private String producer;

    @Column
    private String pictureURL;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "ram")
    private Set<PCConfiguration> configurations = new HashSet<>();

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
     * Gets RAM id.
     *
     * @return the ram id
     */
    public int getRamID() {
        return ramID;
    }

    /**
     * Sets RAM id.
     *
     * @param ramID the ram id
     */
    public void setRamID(int ramID) {
        this.ramID = ramID;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets memory frequency.
     *
     * @return the memory frequency
     */
    public int getMemoryFrequency() {
        return memoryFrequency;
    }

    /**
     * Sets memory frequency.
     *
     * @param memoryFrequency the memory frequency
     */
    public void setMemoryFrequency(int memoryFrequency) {
        this.memoryFrequency = memoryFrequency;
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
     * Gets rankOfRAM.
     *
     * @return the rankOfRAM
     */
    public double getRankOfRAM() {
        return rankOfRAM;
    }

    /**
     * Sets rankOfRAM.
     *
     * @param rankOfRAM the rankOfRAM
     */
    public void setRankOfRAM(double rankOfRAM) {
        this.rankOfRAM = rankOfRAM;
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
     * Gets picture URL.
     *
     * @return the picture url
     */
    public String getPictureURL() {
        return pictureURL;
    }

    /**
     * Sets picture URL.
     *
     * @param pictureURL the picture url
     */
    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
