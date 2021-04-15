package com.hospital.dao.impl;

import com.hospital.dao.ifc.RoomDao;
import com.hospital.entity.*;
import com.hospital.util.DBUtil_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private static Connection conn = DBUtil_pool.getConnection();
    private static PreparedStatement stat=null;
    private static ResultSet rs = null;

    //删除病床的sql
    private static final String DELETE_BED="delete from bed where bedId = ?";
    //删除病房的sql
    private static final String DELETE_HOME="delete from home where homeId = ?";
    //新建病房的sql
    private static final String Insert_BED="insert into bed (bedName,homeId) values (?,?)";
    //修改病房的sql
    private static final String UPDATE_HOME_BYID="UPDATE home SET " +
            "homeName = ?,buildName=?,homeTier= ? ,homeBedNum= ?,homeType= ? " +
            "WHERE homeId = ?";
    //删除住院楼的sql
    private static final String DELETE_BUILD="DELETE from build WHERE buildName = ?";
    //根据id查询床位的sql
    private static final String QUERY_BED_BY_HID="SELECT bed.bedId,bedName,bed.homeId,homeName " +
            "FROM bed " +
            "JOIN home ON home.homeId = bed.homeId " +
            "WHERE bed.homeId = ?";
    //查询住院楼名字的sql
    private static final String QUERY_BUILD="select * from build";
    //查询每层病房最大数的sql
    private static final String QUERY_MAX_BUILD_IN_BUILD="select * from build WHERE buildName = ?";
    //查询住院楼病房病人信息的sql
    private static final String QUERY_PATIENT_AND_BED="SELECT home.homeName,bed.bedId,bedName,patient.patientId,patientName,patientAge,patientSex,homeType,homeTier,home.homeId " +
            "FROM bed " +
            "JOIN home ON home.homeId = bed.homeId " +
            "JOIN patient ON bed.patientId = patient.patientId " +
            "WHERE home.buildName = ?;";
    //查询楼层数
    private static final String QUERY_MAX_TIER= "SELECT buildTierNum FROM build WHERE buildName = ?";

    private static final String QUERY_HOME_BY_BUILDID= "SELECT * FROM home WHERE buildName = ?";
    private static final String QUERY_HOME_BY_HomeID= "SELECT * FROM home WHERE homeId = ?";

    private static final String QUERY_COUNT_BUILDID= "SELECT COUNT(*) FROM home WHERE buildName = ?";
    //统计住院楼id下某层的病床数量
    private static final String QUERY_COUNT_HOME_NUM= "SELECT COUNT(*) FROM home WHERE buildName = ? and homeTier = ?";

    //统计病房id下病床数量
    private static final String QUERY_COUNT_BED_NUM= "SELECT COUNT(*) FROM bed WHERE homeId = ?";
    //统计病房id下最大病床数量
    private static final String Query_HomeBedNum = "SELECT homeBedNum FROM home WHERE homeId = ?";

    //设置病床的pId
    private static final String UPDATE_PATIENTID_FROM_BED= "UPDATE bed SET patientId = ? WHERE bedId = ?";
    //设置病床的pId为空
    private static final String UPDATE_PATIENTID_NULL_FROM_BED= "UPDATE bed SET patientId = NULL WHERE bedId = ?";
    //链接build表查询病床信息
    private static final String QUERY_HOME_AND_BUILD= "SELECT homeId,home.homeName,home.buildName,homeTier,buildTierNum,buildHomeNum " +
            "FROM home " +
            "JOIN build WHERE home.buildName = build.buildName ";
    //插入病房楼
    private static final String INSERT_BUILD= "INSERT INTO build (buildName,buildTierNum,buildHomeNum) " +
            "VALUES (?,?,?)";
    //插入病房
    private static final String INSERT_HOME= "INSERT INTO home (homeName,buildName,homeTier,homeType,homeBedNum) " +
            "VALUES (?,?,?,?,?)";




    /**
     * 查询病楼
     * @return
     */
    @Override
    public List<Build> queryAllBuild() {
        Build build = null;
        List<Build> builds = new ArrayList<>();
        try {
            stat = conn.prepareStatement(QUERY_BUILD);
            rs = stat.executeQuery();

            while (rs.next()){
                build = new Build();
                build.setBuildName(rs.getString("buildName"));
                build.setBuildTierNum(rs.getInt("buildTierNum"));
                build.setBuildHomeNum(rs.getInt("buildHomeNum"));
                builds.add(build);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return builds;
    }

    /**
     * 根据住院楼号查询信息
     * @return
     */
    @Override
    public List<Bed> queryPatientAndBed(String buildName) {

        List<Bed> bedList = new ArrayList<>();
        Bed bed = null;
        Home home = null;
        Patient patient = null;
        try {
            stat = conn.prepareStatement(QUERY_PATIENT_AND_BED);
            stat.setString(1,buildName);
            rs = stat.executeQuery();

            while (rs.next()){
                bed = new Bed();
                home = new Home();
                patient = new Patient();

                home.setHomeName(rs.getString("homeName"));
                home.setHomeTier(rs.getInt("homeTier"));
                home.setHomeType(rs.getString("homeType"));
                home.setHomeId(rs.getInt("homeId"));

                patient.setPatientId(rs.getInt("patientId"));
                patient.setPatientName(rs.getString("patientName"));
                patient.setPatientAge(rs.getInt("patientAge"));
                patient.setPatientSex(rs.getString("patientSex"));

                bed.setBedId(rs.getInt("bedId"));
                bed.setBedName(rs.getString("bedName"));
                bed.setPatient(patient);
                bed.setHome(home);
                bedList.add(bed);
            }
            System.out.println("获取到的对象list"+bedList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return bedList;
    }

    /**
     * 住院楼楼层
     * @param buildName
     * @return
     */
    @Override
    public Integer buildTierNum(String buildName) {
        Integer buildTierNum = null;
        try {
            stat = conn.prepareStatement(QUERY_MAX_TIER);
            stat.setString(1,buildName);
            rs = stat.executeQuery();

            if (rs.next()){
                buildTierNum = rs.getInt("buildTierNum");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return buildTierNum;
    }

    @Override
    public List<Home> queryHomeByBuildName(String buildName) {
        Home home = null;
        List<Home> homeList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(QUERY_HOME_BY_BUILDID);
            stat.setString(1,buildName);
            rs = stat.executeQuery();

            while (rs.next()){
                home = new Home();
                home.setHomeName(rs.getString("homeName"));
                home.setHomeTier(rs.getInt("homeTier"));
                home.setHomeType(rs.getString("homeType"));
                home.setHomeId(rs.getInt("homeId"));

                homeList.add(home);
                System.out.println("这是获取到的home信息"+home);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return homeList;
    }

    @Override
    public Integer queryHomeNum(String buildName) {
        Integer homeNum = null;
        try {
            stat = conn.prepareStatement(QUERY_COUNT_BUILDID);
            stat.setString(1,buildName);
            rs = stat.executeQuery();

            if (rs.next()){
                homeNum = rs.getInt("COUNT(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return homeNum;
    }

    /**
     * 将新病床加入patientId
     * @param newBedId
     * @param patientId
     * @return
     */
    @Override
    public Boolean exeUpdateNewBedPatientId(Integer newBedId, Integer patientId) {
        Boolean exeUpdateBed = false;
        try {
            stat = conn.prepareStatement(UPDATE_PATIENTID_FROM_BED);
            stat.setInt(1,patientId);
            stat.setInt(2,newBedId);
            int result = stat.executeUpdate();
            if(result > 0){
                System.out.println("bed的pID修改完成");
                exeUpdateBed = true;
            }else {
                exeUpdateBed = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdateBed;
    }

    /**
     * 清除旧病床的patientId
     * @param oldBedId
     * @return
     */
    @Override
    public Boolean exeUpdateOldBed(Integer oldBedId) {
        Boolean exeUpdateBed = false;
        try {
            stat = conn.prepareStatement(UPDATE_PATIENTID_NULL_FROM_BED);
            stat.setInt(1,oldBedId);
            int result = stat.executeUpdate();
            if(result > 0){
                System.out.println("bed的pID修改完成");
                exeUpdateBed = true;
            }else {
                exeUpdateBed = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdateBed;
    }

    /**
     * 链接build表查询home
     * @return
     */
    @Override
    public List<Home> queryAllHome() {
        Home home = null;
        Build build = null;
        List<Home> homeList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(QUERY_HOME_AND_BUILD);
            rs = stat.executeQuery();

            while (rs.next()){
                home = new Home();
                build = new Build();

                build.setBuildName(rs.getString("buildName"));
                build.setBuildHomeNum(rs.getInt("buildHomeNum"));

                home.setBuild(build);
                home.setHomeName(rs.getString("homeName"));
                home.setHomeTier(rs.getInt("homeTier"));
                home.setHomeId(rs.getInt("homeId"));

                homeList.add(home);
//                System.out.println("这是获取到的home信息"+home);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return homeList;
    }

    @Override
    public Boolean insertBuild(String buildName, Integer buildTierNum, Integer buildHomeNum) {
        Boolean exeInsert = false;
        try {
            stat = conn.prepareStatement(INSERT_BUILD);
            stat.setString(1,buildName);
            stat.setInt(2,buildTierNum);
            stat.setInt(3,buildHomeNum);
            int result = stat.executeUpdate();
            if(result > 0){
                exeInsert = true;
            }else {
                exeInsert = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeInsert;
    }

    /**
     * 每层最大病房数量
     * @param buildName
     * @return
     */
    @Override
    public Integer queryMaxHomeNum(String buildName) {
        Integer maxNum = null;
        try {
            stat = conn.prepareStatement(QUERY_MAX_BUILD_IN_BUILD);
            stat.setString(1,buildName);
            rs = stat.executeQuery();

            if (rs.next()){
                maxNum = rs.getInt("buildHomeNum");
                System.out.println("病房每层最大容纳："+maxNum);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return maxNum;
    }



    /**
     * 统计住院楼某层的病房数量
     * @param buildName
     * @return
     */
    @Override
    public Integer countHomeNum(String buildName, Integer homeTier) {
        Integer homeNum = null;
        try {
            stat = conn.prepareStatement(QUERY_COUNT_HOME_NUM);
            stat.setString(1,buildName);
            stat.setInt(2,homeTier);
            rs = stat.executeQuery();

            if (rs.next()){
                homeNum = rs.getInt("COUNT(*)");
                System.out.println("该层已有"+homeNum+"间病房");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return homeNum;
    }

    /**
     * 插入home病房
     * @param buildName
     * @param homeName
     * @param homeType
     * @param homeTier
     * @param homeBedNum
     * @return
     */
    @Override
    public Boolean insertHome(String buildName, String homeName, String homeType, Integer homeTier, Integer homeBedNum) {
        Boolean exeInsert = false;
        try {
            stat = conn.prepareStatement(INSERT_HOME);
            stat.setString(1,homeName);
            stat.setString(2,buildName);
            stat.setInt(3,homeTier);
            stat.setString(4,homeType);
            stat.setInt(5,homeBedNum);

            int result = stat.executeUpdate();
            if(result > 0){
                exeInsert = true;
            }else {
                exeInsert = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeInsert;
    }

    /**
     * 删除住院楼
     * @param buildName
     * @return
     */
    @Override
    public Boolean deleteBuild(String buildName) {

        Boolean exeDelete = false;
        try {
            stat = conn.prepareStatement(DELETE_BUILD);
            stat.setString(1,buildName);

            int result = stat.executeUpdate();
            if(result != 0){
                exeDelete = true;
            }else {
                exeDelete = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        System.out.println(exeDelete);
        return exeDelete;
    }

    /**
     * 根据id查询所有床位
     * @param homeId
     * @return
     */
    @Override
    public List<Bed> queryAllBed(Integer homeId) {
        Home home = null;
        Bed bed = null;
        List<Bed> bedList = new ArrayList<>();
        try {
            stat = conn.prepareStatement(QUERY_BED_BY_HID);
            stat.setInt(1,homeId);
            rs = stat.executeQuery();

            while (rs.next()){
                home = new Home();
                bed = new Bed();

                home.setHomeName(rs.getString("homeName"));
//                home.setHomeTier(rs.getInt("homeTier"));
                home.setHomeId(rs.getInt("homeId"));
                bed.setHome(home);
                bed.setBedId(rs.getInt("bedId"));
                bed.setBedName(rs.getString("bedName"));

                bedList.add(bed);
//                System.out.println("这是获取到的home信息"+home);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return bedList;
    }

    @Override
    public Boolean insertBed(Integer homeId, String bedName) {

        Boolean exeInsert = false;
        try {
            stat = conn.prepareStatement(Insert_BED);
            stat.setString(1,bedName);
            stat.setInt(2,homeId);

            int result = stat.executeUpdate();
            if(result > 0){
                exeInsert = true;
            }else {
                exeInsert = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeInsert;
    }

    /**
     * 房间已有病床数
     * @param homeId
     * @return
     */
    @Override
    public Integer countBed(Integer homeId) {
        Integer bedNum = null;
        try {
            stat = conn.prepareStatement(QUERY_COUNT_BED_NUM);
            stat.setInt(1,homeId);
            rs = stat.executeQuery();

            if (rs.next()){
                bedNum = rs.getInt("COUNT(*)");
                System.out.println("该房已有"+bedNum+"间病床");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return bedNum;
    }

    /**
     * 最大病床数
     * @param homeId
     * @return
     */
    @Override
    public Integer queryMaxBed(Integer homeId) {

        Integer maxNum = null;
        try {
            stat = conn.prepareStatement(Query_HomeBedNum);
            stat.setInt(1,homeId);
            rs = stat.executeQuery();

            if (rs.next()){
                maxNum = rs.getInt("homeBedNum");
                System.out.println("最大病床为："+maxNum);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return maxNum;
    }

    @Override
    public Boolean updateHome(Integer homeId, String homeName, String buildName, Integer homeTier, Integer homeBedNum, String homeType) {
        Boolean exeUpdateHome = false;
        try {
            stat = conn.prepareStatement(UPDATE_HOME_BYID);
            stat.setString(1,homeName);
            stat.setString(2,buildName);
            stat.setInt(3,homeTier);
            stat.setInt(4,homeBedNum);
            stat.setString(5,homeType);
            stat.setInt(6,homeId);


            int result = stat.executeUpdate();
            if(result > 0){
                System.out.println("home修改完成");
                exeUpdateHome = true;
            }else {
                exeUpdateHome = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdateHome;
    }

    @Override
    public Home selectHome(Integer homeId) {
        Home home = null;
        Build build = null;
        try {
            stat = conn.prepareStatement(QUERY_HOME_BY_HomeID);
            stat.setInt(1, homeId);
            rs = stat.executeQuery();

            if (rs.next()){
                home = new Home();
                build = new Build();
                build.setBuildName(rs.getString("buildName"));
                home.setHomeName(rs.getString("homeName"));
                home.setHomeTier(rs.getInt("homeTier"));
                home.setHomeBedNum(rs.getInt("homeBedNum"));
                home.setBuild(build);
                home.setHomeId(homeId);
                home.setHomeType(rs.getString("homeType"));
                System.out.println("获取到的对象"+home);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return home;
    }

    @Override
    public Boolean deleteHome(Integer homeId) {
        Boolean exeDelete = false;
        try {
            stat = conn.prepareStatement(DELETE_HOME);
            stat.setInt(1,homeId);

            int result = stat.executeUpdate();
            if(result != 0){
                exeDelete = true;
            }else {
                exeDelete = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        System.out.println(exeDelete);
        return exeDelete;
    }

    @Override
    public Boolean deleteBed(Integer bedId) {
        Boolean exeDelete = false;
        try {
            stat = conn.prepareStatement(DELETE_BED);
            stat.setInt(1,bedId);

            int result = stat.executeUpdate();
            if(result != 0){
                exeDelete = true;
            }else {
                exeDelete = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        System.out.println(exeDelete);
        return exeDelete;
    }

}
