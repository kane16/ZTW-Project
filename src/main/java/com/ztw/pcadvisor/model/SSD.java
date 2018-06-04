package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The SSD.
 */
@Entity
public class SSD {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ssdID;

    @Column
    private int writeSpeed;

    @Column
    private int readSpeed;

    @Column
    private int capacity;

    @Column
    private int TDP;

    @Column
    private double price;

    @Column
    private double rank;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "ssd")
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
     * Gets SSD id.
     *
     * @return the ssd id
     */
    public int getSsdID() {
        return ssdID;
    }

    /**
     * Sets SSD id.
     *
     * @param ssdID the ssd id
     */
    public void setSsdID(int ssdID) {
        this.ssdID = ssdID;
    }

    /**
     * Gets write speed.
     *
     * @return the write speed
     */
    public int getWriteSpeed() {
        return writeSpeed;
    }

    /**
     * Sets write speed.
     *
     * @param writeSpeed the write speed
     */
    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    /**
     * Gets read speed.
     *
     * @return the read speed
     */
    public int getReadSpeed() {
        return readSpeed;
    }

    /**
     * Sets read speed.
     *
     * @param readSpeed the read speed
     */
    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets TDP.
     *
     * @return the tdp
     */
    public int getTDP() {
        return TDP;
    }

    /**
     * Sets TDP.
     *
     * @param TDP the tdp
     */
    public void setTDP(int TDP) {
        this.TDP = TDP;
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
     * Gets rank.
     *
     * @return the rank
     */
    public double getRank() {
        return rank;
    }

    /**
     * Sets rank.
     *
     * @param rank the rank
     */
    public void setRank(double rank) {
        this.rank = rank;
    }
}
