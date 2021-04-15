package com.hospital.service.impl;

import com.hospital.dao.ifc.DoctorDao;
import com.hospital.dao.ifc.NurseDao;
import com.hospital.dao.ifc.RoomDao;
import com.hospital.dao.impl.DoctorDaoImpl;
import com.hospital.dao.impl.NurseDaoImpl;
import com.hospital.dao.impl.RoomDaoImpl;
import com.hospital.entity.*;
import com.hospital.service.ifc.NurseService;

import java.util.Iterator;
import java.util.List;

public class NurseServiceImpl implements NurseService {


    private NurseDao nurseDao = new NurseDaoImpl();
    private RoomDao roomDao = new RoomDaoImpl();
    /**
     * 护士登录
     */
    @Override
    public Nurse nurseLogin(Integer username, String userPwd) {
        return nurseDao.queryNurseByUsernameAndPassword(username,userPwd);
    }

    /**
     * 寻找需要住院的病人
     * @return list
     */
    @Override
    public List<Patient> showPatientBe() {
        return nurseDao.quertPatientBe();
    }

    /**
     * 展示所有空病房
     * @return list
     */
    @Override
    public List<Bed> showNotOccupyBed() {
        return nurseDao.queryEmptyBed();
    }

    /**
     * 分配病房
     * @return list
     */
    @Override
    public Boolean allotBed(Integer patientId, Integer bedId) {
        Boolean exeAllot = false;
        if (nurseDao.updateBed(patientId,bedId) && nurseDao.updatePatientBed(patientId)){
            exeAllot = true;
        }
        return exeAllot;
    }

    /**
     * 住院信息
     * @param buildName
     * @return
     */
    @Override
    public List<Bed> showPatientBed(String buildName) {
        return roomDao.queryPatientAndBed(buildName);
    }

    /**
     * 根据id查询医嘱
     * @param patientId
     * @return
     */
    @Override
    public List<Advice> showPatientAdvice(Integer patientId) {
        return nurseDao.queryPatientAdviceBypId(patientId);
    }

    @Override
    public List<NurseSchedule> showSchedule() {
        return nurseDao.querySchedule();
    }

    @Override
    public List<Patient> showPatient() {
        return nurseDao.queryPatient();
    }

    @Override
    public Boolean changeSchedule(Integer nurseId, String mon, String tue, String wed, String thu, String fri, String sat, String sun, String remark) {
        return nurseDao.updateSchedule(nurseId,mon,tue,wed,thu,fri,sat,sun,remark);
    }


}
