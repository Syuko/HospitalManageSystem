package com.hospital.service.ifc;

import com.hospital.entity.Advice;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;

import java.util.List;

public interface DoctorService {
    /**
     * 用户登录
     */
    public Doctor doctorLogin(Integer username, String userPwd);

    /**|
     * 建立新的病人
     * @param doctorId
     * @param patient
     * @param shortAdvice
     * @param longAdvice
     * @param insertTime
     * @return
     */
    public Boolean creatPatient(Integer doctorId, Patient patient, String shortAdvice, String longAdvice, String insertTime);


    /**
     * 寻找病人信息与医嘱
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
