package com.ztw.pcadvisor.model;

import javax.persistence.*;

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
    private String pictureUrl;

    @Column
    private int GDDRsize;

    @Column
    private int cudaCores;

    @Column
    private int clockFrequency;

    @Column
    private double rank;



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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
