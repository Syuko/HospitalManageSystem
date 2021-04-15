package com.hospital.dao.ifc;

import com.hospital.entity.Advice;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;

import java.util.List;

public interface DoctorDao {
    /**
     * 登录
     */
    public Doctor queryDoctorByUsernameAndPassword(Integer username, String password);

    /**
     * 新建病人
     * @param patient
     * @return
     */
    public boolean insertPatient(Patient patient);

    /**
     * 新建医嘱
     * @param doctorId
     * @param patientId
     * @param shortAdvice
     * @param longAdvice
     * @param insertTime
     * @return
     */
    public boolean insertAdvice(Integer doctorId, Integer patientId, String shortAdvice, String longAdvice, String insertTime);

    /**
     * 查询patient表最大id
     */
    public Integer queryMaxPatientId();

    /**
     * 查询patient的信息与医嘱
     * @return
     */
    public List<Advice> findPatientMessage(Doctor doctor);

    /**
     * 修改医嘱
     * @param advice
     * @return
     */
    public Boolean updateAdvice(Advice advice);
}
