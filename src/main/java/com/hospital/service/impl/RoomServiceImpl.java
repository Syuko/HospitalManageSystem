package com.hospital.service.impl;

import com.hospital.dao.ifc.RoomDao;
import com.hospital.dao.impl.RoomDaoImpl;
import com.hospital.entity.Bed;
import com.hospital.entity.Build;
import com.hospital.entity.Home;
import com.hospital.service.ifc.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    RoomDao roomDao = new RoomDaoImpl();

    @Override
    public List<Build> allbuild() {
        return roomDao.queryAllBuild();
    }

    @Override
    public Integer buildTierNum(String buildName) {
        Integer num = roomDao.buildTierNum(buildName);
        return num;
    }

    @Override
    public List<Home> getHomeByBuildName(String buildName) {
        return roomDao.queryHomeByBuildName(buildName);
    }

    @Override
    public Integer getHomeNum(String buildName) {
        return roomDao.queryHomeNum(buildName);
    }

    @Override
    public Boolean upBedMessage(Integer patientId, Integer oldBedId, Integer newBedId) {
        Boolean exeUpdateBed = false;
        Boolean exeUpdateNewBedPatientId = false;
        exeUpdateNewBedPatientId = roomDao.exeUpdateNewBedPatientId(newBedId,patientId);
        Boolean exeUpdateOldBed = false;
        exeUpdateOldBed = roomDao.exeUpdateOldBed(oldBedId);
        if (exeUpdateNewBedPatientId && exeUpdateOldBed){
            exeUpdateBed = true;
        }
        return exeUpdateBed;
    }

    @Override
    public List<Home> showAllHome() {
        return roomDao.queryAllHome();
    }

    @Override
    public List<Build> showAllBuild() {
        return roomDao.queryAllBuild();
    }

    @Override
    public Boolean addBuild(String buildName, Integer buildTierNum, Integer buildHomeNum) {
        return roomDao.insertBuild(buildName,buildTierNum,buildHomeNum);
    }

    @Override
    public Boolean isOut(String buildName ,Integer homeTier) {
        Boolean isOut = true;
        Integer buildHomeNum = roomDao.queryMaxHomeNum(buildName);
        Integer countHomeNum = roomDao.countHomeNum(buildName,homeTier);
        if (countHomeNum < buildHomeNum){
            isOut = false;
        }
        return isOut;
    }

    @Override
    public Boolean addHome(String buildName, String homeName, String homeType, Integer homeTier, Integer homeBedNum) {
        return roomDao.insertHome(buildName,homeName,homeType,homeTier,homeBedNum);
    }

    @Override
    public Boolean deleteBuild(String buildName) {
        return roomDao.deleteBuild(buildName);
    }

    @Override
    public List<Bed> showAllBed(Integer homeId) {
        return roomDao.queryAllBed(homeId);
    }

    @Override
    public Boolean addBed(Integer homeId, String bedName) {
        return roomDao.insertBed(homeId,bedName);
    }

    @Override
    public Boolean isHomeMax(Integer homeId) {
        Boolean isMax = true;
        Integer countBed = roomDao.countBed(homeId);
        Integer maxBed = roomDao.queryMaxBed(homeId);
        if (countBed < maxBed){
            isMax = false;
        }
        return isMax;
    }

    @Override
    public Boolean changeHomeMessage(Integer homeId, String homeName, String buildName, Integer homeTier, Integer homeBedNum, String homeType) {
        return roomDao.updateHome(homeId,homeName,buildName, homeTier,homeBedNum,homeType);
    }

    @Override
    public Home selectHome(Integer homeId) {
        return roomDao.selectHome(homeId);
    }

    @Override
    public Boolean delHome(Integer homeId) {
        return roomDao.deleteHome(homeId);
    }

    @Override
    public Boolean delBed(Integer bedId) {
        return roomDao.deleteBed(bedId);
    }
}
