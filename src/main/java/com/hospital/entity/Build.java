package com.hospital.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Build implements Serializable {
    private static final long serialVersionUID = -4594471375457487444L;
    private String buildName;
    private Integer buildTierNum;
    private Integer buildHomeNum;
    private int[] tier;

    public int[] getTier() {
        int y = 0;
        int[] buildtier = new int[buildTierNum];
        for(int i = 0; i < buildTierNum; i++){
            y = y + 1;
            buildtier[i] = y;
//            System.out.println(buildtier[i]);
        }
        this.tier = buildtier;
        return buildtier;
    }

    public void setTier(int[] tier) {
        this.tier = tier;
    }

    public Build() {
    }

    public Build(String buildName, Integer buildTierNum, Integer buildHomeNum) {
        this.buildName = buildName;
        this.buildTierNum = buildTierNum;
        this.buildHomeNum = buildHomeNum;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Integer getBuildTierNum() {
        return buildTierNum;
    }

    public void setBuildTierNum(Integer buildTierNum) {
        this.buildTierNum = buildTierNum;
    }

    public Integer getBuildHomeNum() {
        return buildHomeNum;
    }

    public void setBuildHomeNum(Integer buildHomeNum) {
        this.buildHomeNum = buildHomeNum;
    }


    @Override
    public String toString() {
        return "Build{" +
                "buildName='" + buildName + '\'' +
                ", buildTierNum=" + buildTierNum +
                ", buildHomeNum=" + buildHomeNum +
                ", tier=" + Arrays.toString(tier) +
                '}';
    }
}
