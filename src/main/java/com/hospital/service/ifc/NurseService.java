package com.hospital.service.ifc;

import com.hospital.entity.*;

import java.util.List;

public interface NurseService {

    public Nurse nurseLogin(Integer username, String userPwd);

    public List<Patient> showPatientBe();

    public List<Bed> showNotOccupyBed();

    public Boolean allotBed(Integer patientId,Integer bedId);

    public List<Bed> showPatientBed(String buildName);


    public List<Advice> showPatientAdvice(Integer patientId);

    List<NurseSchedule> showSchedule();

    List<Patient> showPatient();

    Boolean changeSchedule(Integer nurseId, String mon, String tue, String wed, String thu, String fri, String sat, String sun, String remark);
}
