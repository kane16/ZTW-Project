package com.ztw.pcadvisor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private double rank;

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

    public Set<PCConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Set<PCConfiguration> configurations) {
        this.configurations = configurations;
    }

    public int getGDDRsize() {
        return GDDRsize;
    }

    public void setGDDRsize(int GDDRsize) {
        this.GDDRsize = GDDRsize;
    }

    public int getCudaCores() {
        return cudaCores;
    }

    public void setCudaCores(int cudaCores) {
        this.cudaCores = cudaCores;
    }

    public int getClockFrequency() {
        return clockFrequency;
    }

    public void setClockFrequency(int clockFrequency) {
        this.clockFrequency = clockFrequency;
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

    public String getGDDRVersion() {
        return GDDRVersion;
    }

    public void setGDDRVersion(String GDDRVersion) {
        this.GDDRVersion = GDDRVersion;
    }

    public String getChipsetProducer() {
        return chipsetProducer;
    }

    public void setChipsetProducer(String chipsetProducer) {
        this.chipsetProducer = chipsetProducer;
    }

    public String getCardProducer() {
        return cardProducer;
    }

    public void setCardProducer(String cardProducer) {
        this.cardProducer = cardProducer;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getGpuID() {
        return gpuID;
    }

    public void setGpuID(long gpuID) {
        this.gpuID = gpuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
