package com.hospital.dao.impl;

import com.hospital.dao.ifc.DrugDao;
import com.hospital.entity.*;
import com.hospital.util.DBUtil_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDaoImpl implements DrugDao {

    private static Connection conn = DBUtil_pool.getConnection();
    private static PreparedStatement stat=null;
    private static ResultSet rs=null;

    //更新药品的sql
    private static final String UPDATE_DRUG="UPDATE drug SET drugName=?,drugType=?,drugPrice=?,drugRate=?,drugAdd=?,drugNum=? " +
            "WHERE drugId = ? ";
    //删除药品的sql
    private static final String INSERT_DRUG="INSERT INTO drug (drugId,drugName,drugType,drugPrice,drugRate,drugAdd,drugNum) " +
            "VALUES (?,?,?,?,?,?,?)";
    //删除药品的sql
    private static final String DELETE_DRUG="delete from drug where drugId = ?";
    //查询药品账单的sql
    private static final String QUERY_DRUG_ACCOUNT="SELECT drug.drugId,drug.drugName,drugType,drugPrice,drugRate,ndNum " +
            "FROM n_d " +
            "JOIN drug ON drug.drugId = n_d.drugId " +
            "WHERE patientId = ?";
    //查询药品的sql
    private static final String QUERY_ALL_DRUG="select * from drug ";
    //查询库存的sql
    private static final String QUERY_DRUGNUM="select * from drug where drugId = ?";
    //插入nd表信息的sql
    private static final String INSERT_ND_MESSAGE="INSERT INTO n_d (patientId, nurseId,drugId,ndNum,ndTime) VALUES (?,?,?,?,?)";
    //减少drug表的num
    private static final String UPDATE_DRUG_NUM_MESSAGE="UPDATE drug SET drugNum = drugNum -? WHERE drugId = ?;";
    //通过pid查询nd表信息的sql
    private static final String QUERY_ND_MESSAGE_BY_PID="SELECT nurse.nurseId,nurse.nurseName,drug.drugName,ndNum,ndTime " +
            "FROM n_d " +
            "JOIN nurse ON nurse.nurseId = n_d.nurseId " +
            "JOIN drug ON drug.drugId = n_d.drugId " +
            "WHERE patientId = ?";


    /**
     * 查询所有药品信息
     * @return
     */
    @Override
    public List<Drug> queryAllDrugs() {
        List<Drug> drugList = new ArrayList<>();
        Drug drug = null;

        try {
            stat = conn.prepareStatement(QUERY_ALL_DRUG);
            rs = stat.executeQuery();

            while (rs.next()){
                drug = new Drug();
                drug.setDrugId(rs.getInt("drugId"));
                drug.setDrugName(rs.getString("drugName"));
                drug.setDrugNum(rs.getInt("drugNum"));
                drug.setDrugPrice(rs.getDouble("drugPrice"));
                drug.setDrugAdd(rs.getString("drugAdd"));
                drug.setDrugType(rs.getString("drugType"));
                drug.setDrugRate(rs.getDouble("drugRate"));
                drugList.add(drug);

            }
            System.out.println("获取到的对象list"+drugList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return drugList;
    }

    @Override
    public Integer queryDrugNum(Integer drugId) {

        Integer drugNum = null;

        try {
            stat = conn.prepareStatement(QUERY_DRUGNUM);
            stat.setInt(1,drugId);
            rs = stat.executeQuery();

            if (rs.next()){
                drugNum = rs.getInt("drugNum");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return drugNum;
    }

    @Override
    public Boolean insertND(Integer patientId, Integer nurseId, Integer drugId, Integer dpNum, String insertTime) {
        Boolean exeInsert = false;
        try {
            stat = conn.prepareStatement(INSERT_ND_MESSAGE);
            stat.setInt(1,patientId);
            stat.setInt(2,nurseId);
            stat.setInt(3,drugId);
            stat.setInt(4,dpNum);
            stat.setString(5,insertTime);
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

    @Override
    public Boolean updateDrug(Integer dpNum, Integer drugId) {
        Boolean exeUpdate = false;
        try {
            stat = conn.prepareStatement(UPDATE_DRUG_NUM_MESSAGE);
            stat.setInt(1,dpNum);
            stat.setInt(2,drugId);
            int result = stat.executeUpdate();
            if(result > 0){
                System.out.println("updateDrugdao修改完成");
                exeUpdate = true;
            }else {
                exeUpdate = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdate;
    }

    @Override
    public List<Prescribe> showPrescribe(Integer patientId) {

        List<Prescribe> prescribeList = new ArrayList<>();
        Prescribe prescribe = null;
        Nurse nurse = null;
        Drug drug = null;

        try {
            stat = conn.prepareStatement(QUERY_ND_MESSAGE_BY_PID);
            stat.setInt(1,patientId);
            rs = stat.executeQuery();

            while (rs.next()){
                nurse = new Nurse();
                nurse.setNurseId(rs.getInt("nurseId"));
                nurse.setNurseName(rs.getString("nurseName"));

                drug = new Drug();
                drug.setDrugName(rs.getString("drugName"));

                prescribe = new Prescribe();
                prescribe.setNurse(nurse);
                prescribe.setDrug(drug);
                prescribe.setNdNum(rs.getInt("ndNum"));
                prescribe.setNdTime(rs.getString("ndTime"));

                prescribeList.add(prescribe);

            }
            System.out.println("获取到的对象list"+prescribeList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return prescribeList;
    }

    @Override
    public List<Prescribe> showAccount(Integer patientId) {

        List<Prescribe> prescribeList = new ArrayList<>();
        Prescribe prescribe = null;
        Drug drug = null;

        try {
            stat = conn.prepareStatement(QUERY_DRUG_ACCOUNT);
            stat.setInt(1,patientId);
            rs = stat.executeQuery();

            while (rs.next()){

                drug = new Drug();
                drug.setDrugId(rs.getInt("drugId"));
                drug.setDrugName(rs.getString("drugName"));
                drug.setDrugPrice(rs.getDouble("drugPrice"));
                drug.setDrugRate(rs.getDouble("drugRate"));
                drug.setDrugType(rs.getString("drugType"));

                prescribe = new Prescribe();
                prescribe.setDrug(drug);
                prescribe.setNdNum(rs.getInt("ndNum"));

                prescribeList.add(prescribe);

            }
            System.out.println("获取到的对象prescribeList"+prescribeList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return prescribeList;
    }

    @Override
    public Boolean deleteDrug(Integer drugId) {
        Boolean exeDelete = false;
        try {
            stat = conn.prepareStatement(DELETE_DRUG);
            stat.setInt(1,drugId);

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
    public Boolean insertDrug(Integer drugId, String drugName, String drugType, double drugPrice, double drugRate, String drugAdd, Integer drugNum) {
        Boolean exeInsert = false;
        try {
            stat = conn.prepareStatement(INSERT_DRUG);
            stat.setInt(1,drugId);
            stat.setString(2,drugName);
            stat.setString(3,drugType);
            stat.setDouble(4,drugPrice);
            stat.setDouble(5,drugRate);
            stat.setString(6,drugAdd);
            stat.setInt(7,drugNum);

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

    @Override
    public Boolean updateDrugById(Integer drugId, String drugName, String drugType, double drugPrice, double drugRate, String drugAdd, Integer drugNum) {
        Boolean exeUpdate = false;
        try {
            stat = conn.prepareStatement(UPDATE_DRUG);

            stat.setString(1,drugName);
            stat.setString(2,drugType);
            stat.setDouble(3,drugPrice);
            stat.setDouble(4,drugRate);
            stat.setString(5,drugAdd);
            stat.setInt(6,drugNum);
            stat.setInt(7,drugId);

            int result = stat.executeUpdate();
            if(result > 0){
                exeUpdate = true;
            }else {
                exeUpdate = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return exeUpdate;
    }
}
