package com.hospital.entity;

import java.io.Serializable;

public class Prescribe implements Serializable {
    private static final long serialVersionUID = -2699121346659718121L;
    private Integer ndId;
    private Nurse nurse;
    private Drug drug;
    private Patient patient;
    private String ndTime;
    private Integer ndNum;
    private double total;

    public Prescribe() {
    }

    public Prescribe(Integer ndId, Nurse nurse, Drug drug, Patient patient, String ndTime, Integer ndNum) {
        this.ndId = ndId;
        this.nurse = nurse;
        this.drug = drug;
        this.patient = patient;
        this.ndTime = ndTime;
        this.ndNum = ndNum;
    }

    public double getTotal() {
        double drugTotalPrice ;
        drugTotalPrice = drug.getDrugPrice() * drug.getDrugRate() * ndNum;
        return drugTotalPrice;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getNdId() {
        return ndId;
    }

    public void setNdId(Integer ndId) {
        this.ndId = ndId;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getNdTime() {
        return ndTime;
    }

    public void setNdTime(String ndTime) {
        this.ndTime = ndTime;
    }

    public Integer getNdNum() {
        return ndNum;
    }

    public void setNdNum(Integer ndNum) {
        this.ndNum = ndNum;
    }

    @Override
    public String toString() {
        return "Prescribe{" +
                "ndId=" + ndId +
                ", nurse=" + nurse +
                ", drug=" + drug +
                ", patient=" + patient +
                ", ndTime='" + ndTime + '\'' +
                ", ndNum=" + ndNum +
                '}';
    }
}
