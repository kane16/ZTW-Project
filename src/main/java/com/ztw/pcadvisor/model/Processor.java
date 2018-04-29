package com.ztw.pcadvisor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cpuID;
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

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "processor")
    private Set<PCConfiguration> configurations = new HashSet<>();

    public Set<PCConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Set<PCConfiguration> configurations) {
        this.configurations = configurations;
    }

    public long getCpuID() {
        return cpuID;
    }

    public void setCpuID(long cpuID) {
        this.cpuID = cpuID;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public double getClockStandardFrequency() {
        return clockStandardFrequency;
    }

    public void setClockStandardFrequency(double clockStandardFrequency) {
        this.clockStandardFrequency = clockStandardFrequency;
    }

    public double getL3size() {
        return L3size;
    }

    public void setL3size(double l3size) {
        L3size = l3size;
    }

    public int getBoostClockFrequency() {
        return boostClockFrequency;
    }

    public void setBoostClockFrequency(int boostClockFrequency) {
        this.boostClockFrequency = boostClockFrequency;
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

    public int getClockBoostFrequency() {
        return clockBoostFrequency;
    }

    public void setClockBoostFrequency(int clockBoostFrequency) {
        this.clockBoostFrequency = clockBoostFrequency;
    }

    public double getL2size() {
        return L2size;
    }

    public void setL2size(double l2size) {
        L2size = l2size;
    }

    public double getL1size() {
        return L1size;
    }

    public void setL1size(double l1size) {
        L1size = l1size;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
