package com.hospital.dao.impl;

import com.hospital.dao.ifc.NurseDao;
import com.hospital.entity.*;
import com.hospital.util.DBUtil_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NurseDaoImpl implements NurseDao {

    private static Connection conn = DBUtil_pool.getConnection();
    private static PreparedStatement stat=null;
    private static ResultSet rs=null;
    //更新排班表sql
    private static final String UPDATE_SCHEDULE="UPDATE nurseSchedule SET mon=?,tue=?,wed=?,thu=?,fri=?,sat=?,sun=?,remark=? " +
            "WHERE nurseId = ?";

    //登录sql
    private static final String QUER_Nurse_BY_USERNAME_PASSWORD="select * from nurse where nurseId=? and nursePassword=?";
    //查询需要住院且未分配病床的病人的sql
    private static final String QUERY_PATIENT_BY_PATIENTBE_FROM_PATIENT="select * from patient where patientBe = 'y' AND patientHadBed IS NULL";
    //查询病人的sql
    private static final String QUERY_PATIENT="select * from patient";

    //查询空病房的sql
    private static final String QUERY_EMPTY_BED_FROM_BED="SELECT bed.bedId,build.buildName,home.homeName,bedName,homeType " +
            "FROM bed INNER JOIN home ON home.homeId = bed.homeId " +
            "JOIN build ON build.buildName = home.buildName " +
            "WHERE bed.patientId is NULL;";
    //分配病床的sql
    private static final String UPDATE_BED_FROM_PATIENT_BY_BEDID="update bed SET patientId=? WHERE bedId=?";
    //设置已占有分配病床的sql
    private static final String UPDATE_PATIENTHADBED_FROM_PATIENT_BY_PATIENTID="update patient SET patientHadBed= 1 WHERE patientId=?";
    //通过id查找医嘱的sql
    private static final String QUERY_ADVICE_BY_PID="select doctor.doctorId,d_p.patientId,shortAdvice,longAdvice,doctorPhone,doctorName,dpTime,doctorPosition from d_p " +
            "JOIN doctor ON doctor.doctorId = d_p.doctorId " +
            "where patientId = ?";
    //查询排班表的sql
    private static final String QUERY_SCHEDULE="SELECT nurseSchedule.nurseId,nurse.nurseName,mon,tue,wed,thu,fri,sat,sun,remark " +
            "FROM nurseSchedule " +
            "JOIN nurse ON nurse.nurseId = nurseSchedule.nurseId ";


    /**
     * 登录dao
     * @param username
     * @param userPwd
     * @return nurse
     */
    @Override
    public Nurse queryNurseByUsernameAndPassword(Integer username, String userPwd) {
        Nurse nurse = null;
        try {
            stat = conn.prepareStatement(QUER_Nurse_BY_USERNAME_PASSWORD);
            stat.setInt(1, username);
            stat.setString(2, userPwd);
            rs = stat.executeQuery();

            if (rs.next()){
                nurse = new Nurse();
                nurse.setNurseId(rs.getInt("nurseId"));
                nurse.setNurseName(rs.getString("nurseName"));
                nurse.setNurseAge(rs.getInt("nurseAge"));
                nurse.setNurseDep(rs.getString("nurseDep"));
                nurse.setNursePhone(rs.getString("nursePhone"));
                nurse.setNurseSex(rs.getString("nurseSex"));
                nurse.setNursePosition(rs.getString("nursePosition"));
                System.out.println("获取到的对象"+nurse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return nurse;
    }

    /**
     * 寻找需要住院的病人
     * @return list
     */
    @Override
    public List<Patient> quertPatientBe() {
        List<Patient> patientList = new ArrayList<>();
        Patient patient = null;
        try {
            stat = conn.prepareStatement(QUERY_PATIENT_BY_PATIENTBE_FROM_PATIENT);
            rs = stat.executeQuery();

            while (rs.next()){
                patient = new Patient();
                patient.setPatientId(rs.getInt("patientId"));
                patient.setPatientPhone(rs.getString("patientPhone"));
                patient.setPatientHistory(rs.getString("patientHistory"));
                patient.setPatientSex(rs.getString("patientSex"));
                patient.setPatientName(rs.getString("patientName"));
                patient.setPatientAge(rs.getInt("patientAge"));
                patientList.add(patient);

            }
            System.out.println("获取到的对象list"+patientList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return patientList;

    }

    /**
     * 获取病床
     * @return
     */
    @Override
    public List<Bed> queryEmptyBed() {
        List<Bed> bedList = new ArrayList<>();
        Bed bed = null;
        Home home = null;
        Build build = null;
        try {
            stat = conn.prepareStatement(QUERY_EMPTY_BED_FROM_BED);
            rs = stat.executeQuery();

            while (rs.next()){
                bed = new Bed();
                home = new Home();
                build = new Build();

                build.setBuildName(rs.getString("buildName"));
                home.setBuild(build);
                home.setHomeName(rs.getString("homeName"));
                home.setHomeType(rs.getString("homeType"));
                bed.setHome(home);
                bed.setBedId(rs.getInt("bedId"));
                bed.setBedName(rs.getString("bedName"));
                bedList.add(bed);
            }
            System.out.println("获取到的对象list"+bedList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return bedList;
    }


    /**
     * 向bed表写入病人id
     * @param patientId
     * @param bedId
     * @return
     */
    @Override
    public Boolean updateBed(Integer patientId, Integer bedId) {
        Boolean exeUpdateBed = false;
        try {
            stat = conn.prepareStatement(UPDATE_BED_FROM_PATIENT_BY_BEDID);
            stat.setInt(1,patientId);
            stat.setInt(2,bedId);
            int result = stat.executeUpdate();
            if(result > 0){
                System.out.println("bed修改完成");
                exeUpdateBed = true;
            }else {
                exeUpdateBed = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdateBed;
    }

    /**
     * 将病人hadBed改为已占有（1）
     * @param patientId
     * @return
     */
    @Override
    public boolean updatePatientBed(Integer patientId) {
        Boolean updatePatientBed = false;
        try {
            stat = conn.prepareStatement(UPDATE_PATIENTHADBED_FROM_PATIENT_BY_PATIENTID);
            stat.setInt(1,patientId);
            int result = stat.executeUpdate();
            if(result > 0){
                System.out.println("patientHadBed修改完成");
                updatePatientBed = true;
            }else {
                updatePatientBed = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return updatePatientBed;
    }

    @Override
    public Patient queryPatientByPatientId() {
        return null;
    }

    /**
     * 根据id查询医嘱
     * @param patientId
     * @return
     */
    @Override
    public List<Advice> queryPatientAdviceBypId(Integer patientId) {
        List<Advice> adviceList = new ArrayList<>();
        Advice advice = null;
        Doctor doctor = null;

        try {
            stat = conn.prepareStatement(QUERY_ADVICE_BY_PID);
            stat.setInt(1,patientId);
            rs = stat.executeQuery();

            while (rs.next()){
                advice = new Advice();
                doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctorId"));
                doctor.setDoctorName(rs.getString("doctorName"));
                doctor.setDoctorPhone(rs.getString("doctorPhone"));
                doctor.setDoctorPosition(rs.getString("doctorPosition"));

                advice.setDoctor(doctor);
                advice.setTime(rs.getString("dpTime"));
                advice.setShortAdvice(rs.getString("shortAdvice"));
                advice.setLongAdvice(rs.getString("longAdvice"));

                adviceList.add(advice);

            }
            System.out.println("获取到的对象list"+adviceList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return adviceList;
    }

    /**
     * 查询排班表
     * @return
     */
    @Override
    public List<NurseSchedule> querySchedule() {
        List<NurseSchedule> nurseScheduleList = new ArrayList<>();
        Nurse nurse = null;
        NurseSchedule nurseSchedule = null;
        try {
            stat = conn.prepareStatement(QUERY_SCHEDULE);
            rs = stat.executeQuery();

            while (rs.next()){
                nurse = new Nurse();
                nurseSchedule = new NurseSchedule();

                nurse.setNurseId(rs.getInt("nurseId"));
                nurse.setNurseName(rs.getString("nurseName"));

                nurseSchedule.setNurse(nurse);
                nurseSchedule.setMon(rs.getString("mon"));
                nurseSchedule.setTue(rs.getString("tue"));
                nurseSchedule.setWed(rs.getString("wed"));
                nurseSchedule.setThu(rs.getString("thu"));
                nurseSchedule.setFri(rs.getString("fri"));
                nurseSchedule.setSat(rs.getString("sat"));
                nurseSchedule.setSun(rs.getString("sun"));
                nurseSchedule.setRemark(rs.getString("remark"));

                nurseScheduleList.add(nurseSchedule);
            }
            System.out.println("获取到的对象list"+nurseScheduleList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return nurseScheduleList;
    }

    /**
     * 查找所有病人
     * @return
     */
    @Override
    public List<Patient> queryPatient() {
        List<Patient> patientList = new ArrayList<>();
        Patient patient = null;
        try {
            stat = conn.prepareStatement(QUERY_PATIENT);
            rs = stat.executeQuery();

            while (rs.next()){
                patient = new Patient();
                patient.setPatientId(rs.getInt("patientId"));
                patient.setPatientPhone(rs.getString("patientPhone"));
                patient.setPatientHistory(rs.getString("patientHistory"));
                patient.setPatientSex(rs.getString("patientSex"));
                patient.setPatientName(rs.getString("patientName"));
                patient.setPatientAge(rs.getInt("patientAge"));
                patient.setPatientBe(rs.getString("patientBe"));
                patient.setPatientRank(rs.getInt("patientRank"));

                patientList.add(patient);

            }
            System.out.println("获取到的对象list"+patientList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return patientList;

    }

    @Override
    public Boolean updateSchedule(Integer nurseId, String mon, String tue, String wed, String thu, String fri, String sat, String sun, String remark) {


        Boolean exeUpdate = false;
        try {
            stat = conn.prepareStatement(UPDATE_SCHEDULE);
            stat.setString(1,mon);
            stat.setString(2,tue);
            stat.setString(3,wed);
            stat.setString(4,thu);
            stat.setString(5,fri);
            stat.setString(6,sat);
            stat.setString(7,sun);
            stat.setString(8,remark);

            stat.setInt(9,nurseId);


            int result = stat.executeUpdate();
            if(result > 0){
                exeUpdate = true;
            }else {
                exeUpdate = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdate;
    }


}
