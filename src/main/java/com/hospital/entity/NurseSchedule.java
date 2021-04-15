package com.hospital.entity;

import java.io.Serializable;

public class NurseSchedule implements Serializable {
    private static final long serialVersionUID = 5558452353953144051L;
    //mon,tue,wed,thu,fri,sat,sun,remark
    private Nurse nurse;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;
    private String remark;

    public NurseSchedule() {
    }

    public NurseSchedule(Nurse nurse, String mon, String tue, String wed, String thu, String fri, String sat, String sun, String remark) {
        this.nurse = nurse;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.remark = remark;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "NurseSchedule{" +
                "nurse=" + nurse +
                ", mon='" + mon + '\'' +
                ", tue='" + tue + '\'' +
                ", wed='" + wed + '\'' +
                ", thu='" + thu + '\'' +
                ", fri='" + fri + '\'' +
                ", sat='" + sat + '\'' +
                ", sun='" + sun + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
