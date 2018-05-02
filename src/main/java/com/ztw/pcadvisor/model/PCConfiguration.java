package com.ztw.pcadvisor.model;

import javax.persistence.*;

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

    public int getPcconfigurationID() {
        return pcconfigurationID;
    }

    public void setPcconfigurationID(int pcconfigurationID) {
        this.pcconfigurationID = pcconfigurationID;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public PCCase getPcCase() {
        return pcCase;
    }

    public void setPcCase(PCCase pcCase) {
        this.pcCase = pcCase;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public SSD getSsd() {
        return ssd;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
