package com.hospital.service.impl;

import com.hospital.dao.ifc.DrugDao;
import com.hospital.dao.impl.DrugDaoImpl;
import com.hospital.entity.Drug;
import com.hospital.entity.Prescribe;
import com.hospital.service.ifc.DrugService;

import java.util.List;

public class DrugServiceImpl implements DrugService {
    DrugDao drugDao = new DrugDaoImpl();

    @Override
    public List<Drug> showAllDrugs() {
        return drugDao.queryAllDrugs();
    }

    @Override
    public Integer getDrugNum(Integer drugId) {
        return drugDao.queryDrugNum(drugId);
    }

    @Override
    public Boolean addMessageND(Integer patientId, Integer nurseId, Integer drugId, Integer dpNum, String insertTime) {
        return drugDao.insertND(patientId,nurseId,drugId,dpNum,insertTime);
    }

    @Override
    public Boolean exeUpdateDrug(Integer dpNum, Integer drugId) {
        return drugDao.updateDrug(dpNum,drugId);
    }

    @Override
    public List<Prescribe> showPrescribe(Integer patientId) {
        return drugDao.showPrescribe(patientId);
    }

    @Override
    public List<Prescribe> showAccount(Integer patientId) {
        return drugDao.showAccount(patientId);
    }

    @Override
    public Boolean deleteDrug(Integer drugId) {
        return drugDao.deleteDrug(drugId);
    }

    @Override
    public Boolean insertDrug(Integer drugId, String drugName, String drugType, double drugPrice, double drugRate, String drugAdd, Integer drugNum) {
        return drugDao.insertDrug(drugId,drugName,drugType,drugPrice,drugRate,drugAdd,drugNum);
    }

    @Override
    public Boolean updateDrug(Integer drugId, String drugName, String drugType, double drugPrice, double drugRate, String drugAdd, Integer drugNum) {
        return drugDao.updateDrugById(drugId,drugName,drugType,drugPrice,drugRate,drugAdd,drugNum);
    }
}
