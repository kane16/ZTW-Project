package com.ztw.pcadvisor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {

    @JsonProperty("USD")
    private double usd;
    @JsonProperty("PLN")
    private double pln;

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getPln() {
        return pln;
    }

    public void setPln(double pln) {
        this.pln = pln;
    }
}
