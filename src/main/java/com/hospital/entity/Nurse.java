package com.hospital.entity;

import java.io.Serializable;

public class Nurse implements Serializable {

    private static final long serialVersionUID = -4235489918885936363L;
    private Integer nurseId; //工号
    private String nurseName; //姓名
    private String nursePassword; //密码
    private String nurseSex; //性别
    private Integer nurseAge; //年龄
    private String nursePhone; //联系方式
    private String nursePosition; //职位
    private String nurseDep; //科室

    public Nurse() {
    }

    public Nurse(Integer nurseId, String nurseName, String nursePassword, String nurseSex, Integer nurseAge, String nursePhone, String nursePosition, String nurseDep) {
        this.nurseId = nurseId;
        this.nurseName = nurseName;
        this.nursePassword = nursePassword;
        this.nurseSex = nurseSex;
        this.nurseAge = nurseAge;
        this.nursePhone = nursePhone;
        this.nursePosition = nursePosition;
        this.nurseDep = nurseDep;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getNursePassword() {
        return nursePassword;
    }

    public void setNursePassword(String nursePassword) {
        this.nursePassword = nursePassword;
    }

    public String getNurseSex() {
        return nurseSex;
    }

    public void setNurseSex(String nurseSex) {
        this.nurseSex = nurseSex;
    }

    public Integer getNurseAge() {
        return nurseAge;
    }

    public void setNurseAge(Integer nurseAge) {
        this.nurseAge = nurseAge;
    }

    public String getNursePhone() {
        return nursePhone;
    }

    public void setNursePhone(String nursePhone) {
        this.nursePhone = nursePhone;
    }

    public String getNursePosition() {
        return nursePosition;
    }

    public void setNursePosition(String nursePosition) {
        this.nursePosition = nursePosition;
    }

    public String getNurseDep() {
        return nurseDep;
    }

    public void setNurseDep(String nurseDep) {
        this.nurseDep = nurseDep;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId=" + nurseId +
                ", nurseName='" + nurseName + '\'' +
                ", nursePassword='" + nursePassword + '\'' +
                ", nurseSex='" + nurseSex + '\'' +
                ", nurseAge=" + nurseAge +
                ", nursePhone='" + nursePhone + '\'' +
                ", nursePosition='" + nursePosition + '\'' +
                ", nurseDep='" + nurseDep + '\'' +
                '}';
    }
}
