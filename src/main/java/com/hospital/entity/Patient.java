package com.hospital.entity;

/**
 * 病人类
 */
public class Patient {
    private Integer patientId; //编号
    private String patientName; //姓名
    private String patientSex; //性别
    private Integer patientAge; //年龄
    private String patientPhone; //联系方式
    private String patientHistory; //病历
    private Integer patientRank; //医保等级
    private String patientBe; //是否需要住院

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, String patientSex, Integer patientAge, String patientPhone, String patientHistory, Integer patientRank, String patientBe) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientAge = patientAge;
        this.patientPhone = patientPhone;
        this.patientHistory = patientHistory;
        this.patientRank = patientRank;
        this.patientBe = patientBe;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(String patientHistory) {
        this.patientHistory = patientHistory;
    }

    public Integer getPatientRank() {
        return patientRank;
    }

    public void setPatientRank(Integer patientRank) {
        this.patientRank = patientRank;
    }

    public String getPatientBe() {
        return patientBe;
    }

    public void setPatientBe(String patientBe) {
        this.patientBe = patientBe;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientSex='" + patientSex + '\'' +
                ", patientAge=" + patientAge +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientHistory='" + patientHistory + '\'' +
                ", patientRank=" + patientRank +
                ", patientBe='" + patientBe + '\'' +
                '}';
    }
}
