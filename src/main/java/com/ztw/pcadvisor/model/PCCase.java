package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The PC case.
 */
@Entity
public class PCCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int caseID;

    @Column
    private double height;

    @Column
    private double length;

    @Column
    private double width;

    @Column
    private double weight;

    @Column
    private double price;

    @Column
    private double rank;

    @Column
    private String producer;

    @Column
    private String pictureURL;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pcCase")
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
     * Gets case id.
     *
     * @return the case id
     */
    public int getCaseID() {
        return caseID;
    }

    /**
     * Sets case id.
     *
     * @param caseID the case id
     */
    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
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
