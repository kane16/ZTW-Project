package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    public Set<PCConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Set<PCConfiguration> configurations) {
        this.configurations = configurations;
    }

    public int getSsdID() {
        return ssdID;
    }

    public void setSsdID(int ssdID) {
        this.ssdID = ssdID;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
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
}
