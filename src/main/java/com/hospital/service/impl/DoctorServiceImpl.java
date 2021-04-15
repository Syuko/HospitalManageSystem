package com.hospital.service.impl;

import com.hospital.dao.ifc.DoctorDao;
import com.hospital.dao.impl.DoctorDaoImpl;
import com.hospital.entity.Advice;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.service.ifc.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    /**
     * 医生登录
     */
    private DoctorDao doctorDao = new DoctorDaoImpl();
    @Override
    public Doctor doctorLogin(Integer username, String userPwd) {
        return doctorDao.queryDoctorByUsernameAndPassword(username,userPwd);
    }

    /**
     * 建立新病人与医嘱
     * @param doctorId
     * @param patient
     * @param shortAdvice
     * @param longAdvice
     * @param insertTime
     * @return
     */
    @Override
    public synchronized Boolean creatPatient(Integer doctorId, Patient patient, String shortAdvice, String longAdvice, String insertTime) {
        Boolean exeCreatPatientAndAdvice = false;
        Boolean exeCreatPatient = doctorDao.insertPatient(patient);
        Integer maxPatientId = doctorDao.queryMaxPatientId();
        Boolean exeInsertAdvice = doctorDao.insertAdvice(doctorId,maxPatientId,shortAdvice,longAdvice,insertTime);
        if (exeCreatPatient && exeInsertAdvice){
            System.out.println("插入病人与医嘱成功");
            exeCreatPatientAndAdvice = true;
        } else {
            System.out.println("插入病人与医嘱失败");
            exeCreatPatientAndAdvice = false;
        }
        return exeCreatPatientAndAdvice;
    }

    @Override
    public List<Advice> findPatientMessage(Doctor doctor) {

        List<Advice> patientMessage = doctorDao.findPatientMessage(doctor);

        return patientMessage;
    }

    @Override
    public Boolean updateAdvice(Advice advice) {
        return doctorDao.updateAdvice(advice);
    }
}
