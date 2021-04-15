package com.hospital.entity;

import java.io.Serializable;

public class Drug implements Serializable {

    private static final long serialVersionUID = -5488777973684087089L;
    private Integer drugId;
    private String drugName;
    private Integer drugNum;
    private double drugPrice;
    private String drugAdd;
    private String drugType;
    private double drugRate;


    public Drug() {
    }

    public Drug(Integer drugId, String drugName, Integer drugNum, double drugPrice, String drugAdd, String drugType, double drugRate) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugNum = drugNum;
        this.drugPrice = drugPrice;
        this.drugAdd = drugAdd;
        this.drugType = drugType;
        this.drugRate = drugRate;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugNum=" + drugNum +
                ", drugPrice=" + drugPrice +
                ", drugAdd='" + drugAdd + '\'' +
                ", drugType='" + drugType + '\'' +
                ", drugRate=" + drugRate +
                '}';
    }

    public double getDrugRate() {
        return drugRate;
    }

    public void setDrugRate(double drugRate) {
        this.drugRate = drugRate;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(Integer drugNum) {
        this.drugNum = drugNum;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public String getDrugAdd() {
        return drugAdd;
    }

    public void setDrugAdd(String drugAdd) {
        this.drugAdd = drugAdd;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

}
