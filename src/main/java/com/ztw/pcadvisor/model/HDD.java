package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private double rank;

    @Column
    private int TDP;

    @Column
    private String pictureURL;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "hdd")
    private Set<PCConfiguration> configurations = new HashSet<>();

    public Set<PCConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Set<PCConfiguration> configurations) {
        this.configurations = configurations;
    }

    public int getHddID() {
        return hddID;
    }

    public void setHddID(int hddID) {
        this.hddID = hddID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public int getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        this.RPM = RPM;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
