package com.ztw.pcadvisor.model;

import javax.persistence.*;

/**
 * The type Pc configuration.
 */
@Entity
public class PCConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pcconfigurationID;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cpuID")
    private Processor processor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gpuID")
    private GraphicCard graphicCard;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "caseID")
    private PCCase pcCase;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ramID")
    private RAM ram;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ssdID")
    private SSD ssd;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hddID")
    private HDD hdd;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "powerSupplyID")
    private PowerSupply powerSupply;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userID")
    private User user;

    /**
     * Gets PCConfiguration id.
     *
     * @return the pcconfiguration id
     */
    public int getPcconfigurationID() {
        return pcconfigurationID;
    }

    /**
     * Sets PCConfiguration id.
     *
     * @param pcconfigurationID the pcconfiguration id
     */
    public void setPcconfigurationID(int pcconfigurationID) {
        this.pcconfigurationID = pcconfigurationID;
    }

    /**
     * Gets processor.
     *
     * @return the processor
     */
    public Processor getProcessor() {
        return processor;
    }

    /**
     * Sets processor.
     *
     * @param processor the processor
     */
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    /**
     * Gets graphic card.
     *
     * @return the graphic card
     */
    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    /**
     * Sets graphic card.
     *
     * @param graphicCard the graphic card
     */
    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    /**
     * Gets pc case.
     *
     * @return the pc case
     */
    public PCCase getPcCase() {
        return pcCase;
    }

    /**
     * Sets pc case.
     *
     * @param pcCase the pc case
     */
    public void setPcCase(PCCase pcCase) {
        this.pcCase = pcCase;
    }

    /**
     * Gets ram.
     *
     * @return the ram
     */
    public RAM getRam() {
        return ram;
    }

    /**
     * Sets ram.
     *
     * @param ram the ram
     */
    public void setRam(RAM ram) {
        this.ram = ram;
    }

    /**
     * Gets ssd.
     *
     * @return the ssd
     */
    public SSD getSsd() {
        return ssd;
    }

    /**
     * Sets ssd.
     *
     * @param ssd the ssd
     */
    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    /**
     * Gets hdd.
     *
     * @return the hdd
     */
    public HDD getHdd() {
        return hdd;
    }

    /**
     * Sets hdd.
     *
     * @param hdd the hdd
     */
    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    /**
     * Gets power supply.
     *
     * @return the power supply
     */
    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    /**
     * Sets power supply.
     *
     * @param powerSupply the power supply
     */
    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
