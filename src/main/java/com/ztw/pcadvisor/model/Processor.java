package com.ztw.pcadvisor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * The Processor.
 */
@Entity
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cpuID;
    @Column
    private String name;
    @Column
    private int TDP;
    @Column
    @NotNull
    private double clockStandardFrequency;
    @Column
    private double L3size;
    @Column
    private int boostClockFrequency;
    @Column
    @NotNull
    private double price;
    @Column
    @NotNull
    private double rank;
    @Column
    private int clockBoostFrequency;
    @Column
    private double L2size;
    @Column
    private double L1size;
    @Column
    @NotNull
    private String producer;
    @Column
    private String pictureURL;

    @Column
    private double rating;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "processor")
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
     * Gets cpu id.
     *
     * @return the cpu id
     */
    public long getCpuID() {
        return cpuID;
    }

    /**
     * Sets cpu id.
     *
     * @param cpuID the cpu id
     */
    public void setCpuID(long cpuID) {
        this.cpuID = cpuID;
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
     * Gets clock standard frequency.
     *
     * @return the clock standard frequency
     */
    public double getClockStandardFrequency() {
        return clockStandardFrequency;
    }

    /**
     * Sets clock standard frequency.
     *
     * @param clockStandardFrequency the clock standard frequency
     */
    public void setClockStandardFrequency(double clockStandardFrequency) {
        this.clockStandardFrequency = clockStandardFrequency;
    }

    /**
     * Gets l 3 size.
     *
     * @return the l 3 size
     */
    public double getL3size() {
        return L3size;
    }

    /**
     * Sets l 3 size.
     *
     * @param l3size the l 3 size
     */
    public void setL3size(double l3size) {
        L3size = l3size;
    }

    /**
     * Gets boost clock frequency.
     *
     * @return the boost clock frequency
     */
    public int getBoostClockFrequency() {
        return boostClockFrequency;
    }

    /**
     * Sets boost clock frequency.
     *
     * @param boostClockFrequency the boost clock frequency
     */
    public void setBoostClockFrequency(int boostClockFrequency) {
        this.boostClockFrequency = boostClockFrequency;
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
     * Gets L2 size.
     *
     * @return the l 2 size
     */
    public double getL2size() {
        return L2size;
    }

    /**
     * Sets L2 size.
     *
     * @param l2size the l 2 size
     */
    public void setL2size(double l2size) {
        L2size = l2size;
    }

    /**
     * Gets L1 size.
     *
     * @return the l 1 size
     */
    public double getL1size() {
        return L1size;
    }

    /**
     * Sets L1 size.
     *
     * @param l1size the l 1 size
     */
    public void setL1size(double l1size) {
        L1size = l1size;
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
