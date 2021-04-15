package com.hospital.entity;

import java.io.Serializable;

public class Advice implements Serializable {
    private static final long serialVersionUID = 3187914163746225947L;
    private Integer dpId;
    private Patient patient;
    private String time;
    private String shortAdvice;
    private String longAdvice;
    private Doctor doctor;

    public Advice() {
    }

    public Advice(Integer dpId, Patient patient, String time, String shortAdvice, String longAdvice, Doctor doctor) {
        this.dpId = dpId;
        this.patient = patient;
        this.time = time;
        this.shortAdvice = shortAdvice;
        this.longAdvice = longAdvice;
        this.doctor = doctor;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShortAdvice() {
        return shortAdvice;
    }

    public void setShortAdvice(String shortAdvice) {
        this.shortAdvice = shortAdvice;
    }

    public String getLongAdvice() {
        return longAdvice;
    }

    public void setLongAdvice(String longAdvice) {
        this.longAdvice = longAdvice;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "dpId=" + dpId +
                ", patient=" + patient +
                ", time='" + time + '\'' +
                ", shortAdvice='" + shortAdvice + '\'' +
                ", longAdvice='" + longAdvice + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
