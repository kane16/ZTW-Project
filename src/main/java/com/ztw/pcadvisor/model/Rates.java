package com.ztw.pcadvisor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Rates.
 */
public class Rates {

    @JsonProperty("USD")
    private double usd;
    @JsonProperty("PLN")
    private double pln;

    /**
     * Gets USD.
     *
     * @return the usd
     */
    public double getUsd() {
        return usd;
    }

    /**
     * Sets USD.
     *
     * @param usd the usd
     */
    public void setUsd(double usd) {
        this.usd = usd;
    }

    /**
     * Gets PLN.
     *
     * @return the pln
     */
    public double getPln() {
        return pln;
    }

    /**
     * Sets PLN.
     *
     * @param pln the pln
     */
    public void setPln(double pln) {
        this.pln = pln;
    }
}
