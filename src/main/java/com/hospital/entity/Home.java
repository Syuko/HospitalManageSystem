package com.hospital.entity;

import java.io.Serializable;

public class Home implements Serializable {

    private static final long serialVersionUID = -7760634431136607887L;
    private Integer homeId;
    private String homeName;
    private Integer homeTier;
    private String homeType;
    private Integer homeBedNum;
    private Build build;

    public Home() {
    }

    public Home(Integer homeId, String homeName, Integer homeTier, String homeType, Integer homeBedNum, Build build) {
        this.homeId = homeId;
        this.homeName = homeName;
        this.homeTier = homeTier;
        this.homeType = homeType;
        this.homeBedNum = homeBedNum;
        this.build = build;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }


    public Integer getHomeTier() {
        return homeTier;
    }

    public void setHomeTier(Integer homeTier) {
        this.homeTier = homeTier;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public Integer getHomeBedNum() {
        return homeBedNum;
    }

    public void setHomeBedNum(Integer homeBedNum) {
        this.homeBedNum = homeBedNum;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeId=" + homeId +
                ", homeName='" + homeName + '\'' +
                ", homeTier=" + homeTier +
                ", homeType='" + homeType + '\'' +
                ", homeBedNum=" + homeBedNum +
                ", build=" + build +
                '}';
    }
}
