package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The Graphic card.
 */
@Entity
public class GraphicCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gpuID;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private int GDDRsize;

    @Column
    private int cudaCores;

    @Column
    private int clockFrequency;

    @Column
    private double rankOfGC;

    @Column
    private int clockBoostFrequency;

    @Column
    private String GDDRVersion;

    @Column
    private String chipsetProducer;

    @Column
    private String cardProducer;

    @Column
    private int TDP;

    @Column
    private String picture;

    @Column
    private double rating;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "graphicCard")
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
     * Gets gddr size.
     *
     * @return the gdd rsize
     */
    public int getGDDRsize() {
        return GDDRsize;
    }

    /**
     * Sets gddr size.
     *
     * @param GDDRsize the gddr size
     */
    public void setGDDRsize(int GDDRsize) {
        this.GDDRsize = GDDRsize;
    }

    /**
     * Gets cuda cores.
     *
     * @return the cuda cores
     */
    public int getCudaCores() {
        return cudaCores;
    }

    /**
     * Sets cuda cores.
     *
     * @param cudaCores the cuda cores
     */
    public void setCudaCores(int cudaCores) {
        this.cudaCores = cudaCores;
    }

    /**
     * Gets clock frequency.
     *
     * @return the clock frequency
     */
    public int getClockFrequency() {
        return clockFrequency;
    }

    /**
     * Sets clock frequency.
     *
     * @param clockFrequency the clock frequency
     */
    public void setClockFrequency(int clockFrequency) {
        this.clockFrequency = clockFrequency;
    }

    /**
     * Gets rankOfGC.
     *
     * @return the rankOfGC
     */
    public double getRankOfGC() {
        return rankOfGC;
    }

    /**
     * Sets rankOfGC.
     *
     * @param rankOfGC the rankOfGC
     */
    public void setRankOfGC(double rankOfGC) {
        this.rankOfGC = rankOfGC;
    }

    /**
     * Gets clock boost frequency.
     *
     * @return the clock boost frequency
     */
    public int getClockBoostFrequency() {
        return clockBoostFrequency;
    }

    /**
     * Sets clock boost frequency.
     *
     * @param clockBoostFrequency the clock boost frequency
     */
    public void setClockBoostFrequency(int clockBoostFrequency) {
        this.clockBoostFrequency = clockBoostFrequency;
    }

    /**
     * Gets gddr version.
     *
     * @return the gddr version
     */
    public String getGDDRVersion() {
        return GDDRVersion;
    }

    /**
     * Sets gddr version.
     *
     * @param GDDRVersion the gddr version
     */
    public void setGDDRVersion(String GDDRVersion) {
        this.GDDRVersion = GDDRVersion;
    }

    /**
     * Gets chipset producer.
     *
     * @return the chipset producer
     */
    public String getChipsetProducer() {
        return chipsetProducer;
    }

    /**
     * Sets chipset producer.
     *
     * @param chipsetProducer the chipset producer
     */
    public void setChipsetProducer(String chipsetProducer) {
        this.chipsetProducer = chipsetProducer;
    }

    /**
     * Gets card producer.
     *
     * @return the card producer
     */
    public String getCardProducer() {
        return cardProducer;
    }

    /**
     * Sets card producer.
     *
     * @param cardProducer the card producer
     */
    public void setCardProducer(String cardProducer) {
        this.cardProducer = cardProducer;
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
     * Gets gpu id.
     *
     * @return the gpu id
     */
    public long getGpuID() {
        return gpuID;
    }

    /**
     * Sets gpu id.
     *
     * @param gpuID the gpu id
     */
    public void setGpuID(long gpuID) {
        this.gpuID = gpuID;
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
