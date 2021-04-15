package com.hospital.entity;

import java.io.Serializable;

public class Bed implements Serializable {

    private static final long serialVersionUID = -987235396573769144L;
    private Integer bedId;
    private String bedName;
    private Home home;
    private Patient patient;

    public Bed() {
    }

    public Bed(Integer bedId, String bedName, Home home, Patient patient) {
        this.bedId = bedId;
        this.bedName = bedName;
        this.home = home;
        this.patient = patient;
    }


    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public String getBedName() {
        return bedName;
    }

    public void setBedName(String bedName) {
        this.bedName = bedName;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "bedId=" + bedId +
                ", bedName='" + bedName + '\'' +
                ", home=" + home +
                ", patient=" + patient +
                '}';
    }
}
