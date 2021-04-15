package com.hospital.dao.ifc;

import com.hospital.entity.*;

import java.util.List;

public interface NurseDao {

    /**
     * 护士登录
     * @param username
     * @param userPwd
     * @return nurse
     */
    public Nurse queryNurseByUsernameAndPassword(Integer username, String userPwd);

    /**
     * 寻找需要住院的病人
     * @return list
     */
    public List<Patient> quertPatientBe();

    /**
     * 寻找空病房
     * @return list
     */
    public List<Bed> queryEmptyBed();

    /**
     * 更新病房信息
     * @param patientId
     * @param bedId
     * @return
     */
    public Boolean updateBed(Integer patientId, Integer bedId);
    /**
     * 更新病人病房状态信息
     * @param patientId
     * @param
     * @return
     */
    public boolean updatePatientBed(Integer patientId);

    /**
     * 根据patientId查询病人所有信息
     */
    public Patient queryPatientByPatientId();

    public List<Advice> queryPatientAdviceBypId(Integer patientId);

    List<NurseSchedule> querySchedule();

    List<Patient> queryPatient();

    Boolean updateSchedule(Integer nurseId, String mon, String tue, String wed, String thu, String fri, String sat, String sun, String remark);
}
