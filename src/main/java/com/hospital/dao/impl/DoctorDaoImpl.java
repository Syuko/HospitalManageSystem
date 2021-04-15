package com.hospital.dao.impl;

import com.hospital.dao.ifc.DoctorDao;
import com.hospital.entity.Advice;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.util.DBUtil_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {

    private static Connection conn = DBUtil_pool.getConnection();
    private static PreparedStatement stat=null;
    private static ResultSet rs=null;
    //登录的sql
    private static final String QUER_Doctor_BY_USERNAME_PASSWORD="select * from doctor where doctorId=? and doctorPassword=?";
    //新建病人的sql
    private static final String EXE_PATIENT_BY_PATIENT_MESSAGE="INSERT INTO patient (patientName, patientSex,patientAge,patientPhone,patientHistory,patientRank,patientBe) VALUES (?,?,?,?,?,?,?)";
    //新建医嘱的sql
    private static final String INSERT_D_P_BY_ADVICE_MESSAGE="INSERT INTO d_p (patientId,doctorId,dpTime,shortAdvice,longAdvice) VALUES (?,?,?,?,?)";
    //查询最大patintid的sql
    private static final String QUERY_MAX_ID_FROM_PATIENT="SELECT MAX(patientId) FROM patient";
    //查询病人信息与医嘱的sql
    private static final String QUERY_PATIENT_MESSAGE_AND_ADVICE_FROM_PATIENT_DP = "SELECT patient.patientId,dpId,patientName,patientAge,patientSex,patientHistory,patientPhone,patientBe,dpTime,shortAdvice,longAdvice FROM patient INNER JOIN d_p ON patient.patientId = d_p.patientId WHERE d_p.doctorId = ?";
    //修改医嘱的sql
    private static final String UPDATE_ADVICE_FROM_DP = "update d_p SET shortAdvice=?,longAdvice=?,dpTime=? WHERE dpId=?";



    @Override
    public Doctor queryDoctorByUsernameAndPassword(Integer username, String password) {
        Doctor doctor = null;
        try {
            stat = conn.prepareStatement(QUER_Doctor_BY_USERNAME_PASSWORD);
            stat.setInt(1, username);
            stat.setString(2, password);
            rs = stat.executeQuery();

            if (rs.next()){
                doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctorId"));
                doctor.setDoctorName(rs.getString("doctorName"));
                doctor.setDoctorAge(rs.getInt("doctorAge"));
                doctor.setDoctorDep(rs.getString("doctorDep"));
                doctor.setDoctorPhone(rs.getString("doctorPhone"));
                doctor.setDoctorSex(rs.getString("doctorSex"));
                doctor.setDoctorPosition(rs.getString("doctorPosition"));
                System.out.println("获取到的对象"+doctor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return doctor;
    }

    /**
     * 新建病人
     * @param patient
     * @return
     */
    @Override
    public boolean insertPatient(Patient patient) {
        Boolean exeInsertPatient = false;
        try {
            stat = conn.prepareStatement(EXE_PATIENT_BY_PATIENT_MESSAGE);
            stat.setString(1,patient.getPatientName());
            stat.setString(2,patient.getPatientSex());
            stat.setInt(3,patient.getPatientAge());
            stat.setString(4,patient.getPatientPhone());
            stat.setString(5,patient.getPatientHistory());
            stat.setInt(6,patient.getPatientRank());
            stat.setString(7,patient.getPatientBe());
            int result = stat.executeUpdate();
            if(result > 0){
                exeInsertPatient = true;
            }else {
                exeInsertPatient = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeInsertPatient;
    }


    /**
     * patient表最大id
     * @return
     */
    @Override
    public Integer queryMaxPatientId() {
        Integer maxPatientId = null;
        try {
            stat = conn.prepareStatement(QUERY_MAX_ID_FROM_PATIENT);
            rs = stat.executeQuery();
            if (rs.next()){
                maxPatientId = rs.getInt("MAX(patientId)");
                System.out.println("最大id"+maxPatientId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maxPatientId;
    }

    /**
     * 病人信息与医嘱--patient表与dp表
     * @param doctor
     * @return
     */
    @Override
    public List<Advice> findPatientMessage(Doctor doctor) {
        Patient patient = null;
        Advice advice = null;
        List<Advice> adviceList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(QUERY_PATIENT_MESSAGE_AND_ADVICE_FROM_PATIENT_DP);
            stat.setInt(1, doctor.getDoctorId());
            rs = stat.executeQuery();

            while (rs.next()){

                advice = new Advice();
                advice.setDpId(rs.getInt("dpId"));
                //获取病人信息
                patient = new Patient();
                patient.setPatientId(rs.getInt("patientId"));
                patient.setPatientName(rs.getString("patientName"));
                patient.setPatientAge(rs.getInt("patientAge"));
                patient.setPatientSex(rs.getString("patientSex"));
                patient.setPatientHistory(rs.getString("patientHistory"));
                patient.setPatientPhone(rs.getString("patientPhone"));
                patient.setPatientBe(rs.getString("patientBe"));
//                获取医嘱信息
                advice.setDoctor(doctor);
                advice.setPatient(patient);
                advice.setShortAdvice(rs.getString("shortAdvice"));
                advice.setLongAdvice(rs.getString("longAdvice"));
                advice.setTime(rs.getString("dpTime"));

                adviceList.add(advice);
            }
            System.out.println("这些是获取到的病人信息与医嘱："+adviceList);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }

        return adviceList;
    }

    /**
     * 修改dp表中医嘱
     * @param advice
     * @return
     */
    @Override
    public Boolean updateAdvice(Advice advice) {
        Boolean exeUpdateAdvice = false;
        try {
            stat = conn.prepareStatement(UPDATE_ADVICE_FROM_DP);
            stat.setString(1,advice.getShortAdvice());
            stat.setString(2,advice.getLongAdvice());
            stat.setString(3,advice.getTime());
            stat.setInt(4,advice.getDpId());
            int result = stat.executeUpdate();
            if(result > 0){
                System.out.println("dao修改完成");
                exeUpdateAdvice = true;
            }else {
                exeUpdateAdvice = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdateAdvice;
    }

    /**
     * 新建医嘱
     * @param doctorId
     * @param patientId
     * @param shortAdvice
     * @param longAdvice
     * @param insertTime
     * @return
     */
    @Override
    public boolean insertAdvice(Integer doctorId, Integer patientId, String shortAdvice, String longAdvice, String insertTime) {

        Boolean exeInsertAdvice = false;
        try {
            stat = conn.prepareStatement(INSERT_D_P_BY_ADVICE_MESSAGE);
            stat.setInt(1,patientId);
            stat.setInt(2,doctorId);
            stat.setString(3,insertTime);
            stat.setString(4,shortAdvice);
            stat.setString(5,longAdvice);

            int result = stat.executeUpdate();
            if(result > 0){
                exeInsertAdvice = true;
            }else {
                exeInsertAdvice = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeInsertAdvice;
    }


}
