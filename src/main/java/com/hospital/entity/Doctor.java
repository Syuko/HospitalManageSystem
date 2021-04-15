package com.hospital.entity;

import java.io.Serializable;

public class Doctor implements Serializable {
    private static final long serialVersionUID = 6546383922573436315L;
    private Integer doctorId; //工号
    private String doctorName; //姓名
    private String doctorPassword; //密码
    private String doctorSex; //性别
    private Integer doctorAge; //年龄
    private String doctorPhone; //手机
    private String doctorDep; //科室
    private String doctorPosition; //职位

    public String getDoctorPosition() {
        return doctorPosition;
    }

    public void setDoctorPosition(String doctorPosition) {
        this.doctorPosition = doctorPosition;
    }

    public Doctor() {
    }

    public Doctor(Integer doctorId, String doctorName, String doctorPassword, String doctorSex, Integer doctorAge, String doctorPhone, String doctorDep, String doctorPosition) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorPassword = doctorPassword;
        this.doctorSex = doctorSex;
        this.doctorAge = doctorAge;
        this.doctorPhone = doctorPhone;
        this.doctorDep = doctorDep;
        this.doctorPosition = doctorPosition;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }

    public Integer getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorDep() {
        return doctorDep;
    }

    public void setDoctorDep(String doctorDep) {
        this.doctorDep = doctorDep;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", doctorSex='" + doctorSex + '\'' +
                ", doctorAge=" + doctorAge +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", doctorDep='" + doctorDep + '\'' +
                ", doctorPosition='" + doctorPosition + '\'' +
                '}';
    }
}
