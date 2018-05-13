package com.ztw.pcadvisor.model;

public class EuroBaseConversion{
    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private Rates rates;

    public boolean getSuccess(){
        return success;
    }
    public void setSuccess(boolean input){
        this.success = input;
    }
    public int getTimestamp(){
        return timestamp;
    }
    public void setTimestamp(int input){
        this.timestamp = input;
    }
    public String getBase(){
        return base;
    }
    public void setBase(String input){
        this.base = input;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String input){
        this.date = input;
    }
    public Rates getRates(){
        return rates;
    }
    public void setRates(Rates input){
        this.rates = input;
    }
}
