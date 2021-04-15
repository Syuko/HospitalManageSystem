package com.hospital.service.ifc;

import com.hospital.entity.Bed;
import com.hospital.entity.Build;
import com.hospital.entity.Home;

import java.util.List;

public interface RoomService {
    List<Build> allbuild();

    Integer buildTierNum(String buildName);


    List<Home> getHomeByBuildName(String buildName);

    Integer getHomeNum(String buildName);

    Boolean upBedMessage(Integer patientId, Integer oldBedId, Integer newBedId);

    List<Home> showAllHome();

    List<Build> showAllBuild();

    Boolean addBuild(String buildName, Integer buildTierNum, Integer buildTierNum1);

    Boolean isOut(String buildName,Integer homeTier);

    Boolean addHome(String buildName, String homeName, String homeType, Integer homeTier, Integer homeBedNum);

    Boolean deleteBuild(String buildName);

    List<Bed> showAllBed(Integer homeId);

    Boolean addBed(Integer homeId, String bedName);

    Boolean isHomeMax(Integer homeId);

    Boolean changeHomeMessage(Integer homeId, String homeName, String buildName, Integer homeTier, Integer homeBedNum, String homeType);

    Home selectHome(Integer homeId);

    Boolean delHome(Integer homeId);

    Boolean delBed(Integer bedId);
}
