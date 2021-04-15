package com.hospital.service.ifc;

import com.hospital.entity.Drug;
import com.hospital.entity.Prescribe;

import java.util.List;

public interface DrugService {
    public List<Drug> showAllDrugs();

    Integer getDrugNum(Integer drugId);

    Boolean addMessageND(Integer patientId, Integer nurseId, Integer drugId, Integer dpNum, String insertTime);

    Boolean exeUpdateDrug(Integer dpNum, Integer drugId);

    List<Prescribe> showPrescribe(Integer patientId);

    List<Prescribe> showAccount(Integer patientId);

    Boolean deleteDrug(Integer drugId);

    Boolean insertDrug(Integer drugId, String drugName, String drugType, double drugPrice, double drugRate, String drugAdd, Integer drugNum);

    Boolean updateDrug(Integer drugId, String drugName, String drugType, double drugPrice, double drugRate, String drugAdd, Integer drugNum);
}
