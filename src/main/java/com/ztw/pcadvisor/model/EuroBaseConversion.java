package com.ztw.pcadvisor.model;

/**
 * The Euro base conversion.
 */
public class EuroBaseConversion{
    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private Rates rates;

    /**
     * Get success boolean.
     *
     * @return the boolean
     */
    public boolean getSuccess(){
        return success;
    }

    /**
     * Set success boolean.
     *
     * @param input the input
     */
    public void setSuccess(boolean input){
        this.success = input;
    }

    /**
     * Get timestamp.
     *
     * @return the int
     */
    public int getTimestamp(){
        return timestamp;
    }

    /**
     * Set timestamp.
     *
     * @param input the input
     */
    public void setTimestamp(int input){
        this.timestamp = input;
    }

    /**
     * Get base string.
     *
     * @return the string
     */
    public String getBase(){
        return base;
    }

    /**
     * Set base.
     *
     * @param input the input
     */
    public void setBase(String input){
        this.base = input;
    }

    /**
     * Get date string.
     *
     * @return the string
     */
    public String getDate(){
        return date;
    }

    /**
     * Set date.
     *
     * @param input the input
     */
    public void setDate(String input){
        this.date = input;
    }

    /**
     * Get rates rate.
     *
     * @return the rates
     */
    public Rates getRates(){
        return rates;
    }

    /**
     * Set rates.
     *
     * @param input the input
     */
    public void setRates(Rates input){
        this.rates = input;
    }
}
