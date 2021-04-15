package com.hospital.dao.ifc;

import com.hospital.entity.Bed;
import com.hospital.entity.Build;
import com.hospital.entity.Home;

import java.util.List;

public interface RoomDao {
    public List<Build> queryAllBuild();

    public List<Bed> queryPatientAndBed(String buildName);

    public Integer buildTierNum(String buildName);//住院楼楼层

    List<Home> queryHomeByBuildName(String buildName);

    Integer queryHomeNum(String buildName);

    Boolean exeUpdateNewBedPatientId(Integer newBedId, Integer patientId);

    Boolean exeUpdateOldBed(Integer oldBedId);

    List<Home> queryAllHome();

    Boolean insertBuild(String buildName, Integer buildTierNum, Integer buildHomeNum);

    Integer queryMaxHomeNum(String buildName);

    Integer countHomeNum(String buildName, Integer homeTier);

    Boolean insertHome(String buildName, String homeName, String homeType, Integer homeTier, Integer homeBedNum);

    Boolean deleteBuild(String buildName);

    List<Bed> queryAllBed(Integer homeId);

    Boolean insertBed(Integer homeId, String bedName);

    Integer countBed(Integer homeId);

    Integer queryMaxBed(Integer homeId);

    Boolean updateHome(Integer homeId, String homeName, String buildName, Integer homeTier, Integer homeBedNum, String homeType);

    Home selectHome(Integer homeId);

    Boolean deleteHome(Integer homeId);

    Boolean deleteBed(Integer bedId);
}
