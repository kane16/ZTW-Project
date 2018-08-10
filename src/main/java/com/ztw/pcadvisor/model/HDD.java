package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type HDD.
 */
@Entity
public class HDD {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hddID;

    @Column
    private int capacity;

    @Column
    private int writeSpeed;

    @Column
    private int readSpeed;

    @Column
    private int RPM;

    @Column
    private double price;

    @Column
    private double rankOfHDD;

    @Column
    private int TDP;

    @Column
    private String pictureURL;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "hdd")
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
     * Gets hdd id.
     *
     * @return the hdd id
     */
    public int getHddID() {
        return hddID;
    }

    /**
     * Sets hdd id.
     *
     * @param hddID the hdd id
     */
    public void setHddID(int hddID) {
        this.hddID = hddID;
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
     * Gets rpm.
     *
     * @return the rpm
     */
    public int getRPM() {
        return RPM;
    }

    /**
     * Sets rpm.
     *
     * @param RPM the rpm
     */
    public void setRPM(int RPM) {
        this.RPM = RPM;
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
     * Gets rankOfHDD.
     *
     * @return the rankOfHDD
     */
    public double getRankOfHDD() {
        return rankOfHDD;
    }

    /**
     * Sets rankOfHDD.
     *
     * @param rankOfHDD the rankOfHDD
     */
    public void setRankOfHDD(double rankOfHDD) {
        this.rankOfHDD = rankOfHDD;
    }

    /**
     * Gets tdp.
     *
     * @return the tdp
     */
    public int getTDP() {
        return TDP;
    }

    /**
     * Sets tdp.
     *
     * @param TDP the tdp
     */
    public void setTDP(int TDP) {
        this.TDP = TDP;
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
