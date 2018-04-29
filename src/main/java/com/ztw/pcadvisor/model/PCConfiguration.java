package com.ztw.pcadvisor.model;

import javax.persistence.*;

@Entity
public class PCConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int pcconfigurationID;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userID")
    private User user;

}
