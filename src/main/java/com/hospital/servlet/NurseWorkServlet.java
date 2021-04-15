package com.hospital.servlet;


import com.hospital.entity.*;
import com.hospital.service.ifc.DrugService;
import com.hospital.service.ifc.NurseService;
import com.hospital.service.ifc.RoomService;
import com.hospital.service.impl.DrugServiceImpl;
import com.hospital.service.impl.NurseServiceImpl;
import com.hospital.service.impl.RoomServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/NurseWorkServlet")
public class NurseWorkServlet extends HttpServlet {

    private static final long serialVersionUID = 4367226326078782504L;
    NurseService nurseService = new NurseServiceImpl();
    RoomService roomService = new RoomServiceImpl();
    DrugService drugService = new DrugServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String option = request.getParameter("option");
        if ("showPatientBe".equals(option)){
            showPatientBe(request,response);
        } else if ("showEmptyBed".equals(option)){
            showEmptyBed(request,response);
        } else if ("allotPatientBed".equals(option)){
            allotPatientBed(request,response);
        } else if ("showRoomMessage".equals(option)){
            showRoomMessage(request,response);
        } else if ("showPatientAdvice".equals(option)){
            showPatientAdvice(request,response);
        } else if ("choicePatientBed".equals(option)){
            choicePatientBed(request,response);
        } else if ("resetPatientBed".equals(option)){
            resetPatientBed(request,response);
        } else if ("showNurseSchedule".equals(option)){
            showNurseSchedule(request,response);
        } else if ("nurseChoiceDrug".equals(option)){
            nurseChoiceDrug(request,response);
        } else if ("nurseChoiceDrugHadPid".equals(option)){
            nurseChoiceDrugHadPid(request,response);
        } else if ("addPrescribeList".equals(option)){
            addPrescribeList(request,response);
        } else if ("queryPrescribeList".equals(option)){
            queryPrescribeList(request,response);
        } else if ("nurseShowBuildAndHome".equals(option)){
            nurseShowBuildAndHome(request,response);
        } else if ("addBuild".equals(option)){
            addBuild(request,response);
        } else if ("addHome".equals(option)){
            addHome(request,response);
        } else if ("deleteBuild".equals(option)){
            deleteBuild(request,response);
        } else if ("showHomeMessage".equals(option)){
            showHomeMessage(request,response);
        } else if ("addBed".equals(option)){
            addBed(request,response);
        } else if ("changeHome".equals(option)){
            changeHome(request,response);
        } else if ("deleteHome".equals(option)){
            deleteHome(request,response);
        } else if ("deleteBed".equals(option)){
            deleteBed(request,response);
        } else if ("nursePatientAccount".equals(option)){
            nursePatientAccount(request,response);
        } else if ("showPatientAccount".equals(option)){
            showPatientAccount(request,response);
        } else if ("editSchedule".equals(option)){
            editSchedule(request,response);
        } else if ("updateSchedule".equals(option)){
            updateSchedule(request,response);
        } else if ("nurseManageDrug".equals(option)){
            nurseManageDrug(request,response);
        } else if ("deleteDrug".equals(option)){
            deleteDrug(request,response);
        } else if ("insertDrug".equals(option)){
            insertDrug(request,response);
        } else if ("updateDrug".equals(option)){
            updateDrug(request,response);
        }








    }

    /**
     * 删除楼房
     * @param request
     * @param response
     */
    protected void deleteBuild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildName = request.getParameter("buildName");
        System.out.println(buildName);

        Boolean deleteBuild = roomService.deleteBuild(buildName);
        System.out.println("deleteBuild:" + deleteBuild);
        if (deleteBuild){
            request.setAttribute("errorMessage","删除住院楼成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseShowBuildAndHome").forward(request,response);
        } else {
            request.setAttribute("errorMessage","删除失败");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseShowBuildAndHome").forward(request,response);
        }
    }

    /**
     * 展示需要住院的病人
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showPatientBe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Patient> patientList = nurseService.showPatientBe();
        request.setAttribute("patientList",patientList);
        System.out.println("回到了showPatientBe");
        request.getRequestDispatcher("nurseWork.jsp").forward(request,response);

    }

    /**
     * 展示所有空病房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showEmptyBed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));

        //展示所有空床位
        List<Bed> bedList = nurseService.showNotOccupyBed();
        System.out.println("回到了allotPatientBed");
        request.setAttribute("bedList",bedList);
        request.setAttribute("patientId",patientId);

        request.getRequestDispatcher("nurseSetBed.jsp").forward(request,response);

    }

    /**
     * 分配床位
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void allotPatientBed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));
        Integer bedId = Integer.valueOf(request.getParameter("bedId"));
        System.out.println(patientId+":"+bedId);

        //为病人分配床位
        Boolean exeAllot = nurseService.allotBed(patientId,bedId);
        //回到病人页
        if (exeAllot){
            System.out.println("分配成功");
            request.setAttribute("exeMessage","插入成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=showPatientBe").forward(request,response);
        } else {
            request.setAttribute("exeMessage","插入失败");
        }

    }

    /**
     * 显示住院信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showRoomMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildName = request.getParameter("buildName");
        List<Bed> bedList = nurseService.showPatientBed(buildName);
        Integer buildTierNum = roomService.buildTierNum(buildName);
        List<Home> homeList = roomService.getHomeByBuildName(buildName);


        int tier[] = new int[buildTierNum]; /*开辟了一个长度为3的数组*/
        int y = 1;
        for(int x = 0; x < tier.length; x++) {
            tier[x] = y; // 第y个元素
            y = y + 1;
            System.out.println("数组tier"+tier[x]);
            System.out.println(y);
        }


        System.out.println(homeList);
        request.setAttribute("tier",tier);
        request.setAttribute("homeList",homeList);
        request.setAttribute("bedList",bedList);
        request.setAttribute("buildTierNum",buildTierNum);
        request.setAttribute("buildName",buildName);
        request.getRequestDispatcher("nurseHomeControl.jsp").forward(request,response);


    }

    /**
     * 查看病人医嘱
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showPatientAdvice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));
//        System.out.println("到达servlet：showPatientAdvice id"+patientId);
        List<Advice> adviceList = nurseService.showPatientAdvice(patientId);
        request.setAttribute("adviceList",adviceList);
        request.setAttribute("patientId",patientId);
        request.getRequestDispatcher("nursePatientAdvice.jsp").forward(request,response);
    }


    /**
     * 转到病人住房转移页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void choicePatientBed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));
        Integer oldBedId = Integer.valueOf(request.getParameter("bedId"));

        //展示所有空床位
        List<Bed> bedList = nurseService.showNotOccupyBed();
        System.out.println("回到了choicePatientBed");
        request.setAttribute("bedList",bedList);
        request.setAttribute("patientId",patientId);
        request.setAttribute("oldBedId",oldBedId);

        request.getRequestDispatcher("nurseChoiceBed.jsp").forward(request,response);

    }

    /**
     * 转移病房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void resetPatientBed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));
        Integer oldBedId = Integer.valueOf(request.getParameter("oldBedId"));
        Integer newBedId = Integer.valueOf(request.getParameter("bedId"));
        String buildName = request.getParameter("buildName");

        System.out.println(patientId);
        System.out.println(oldBedId);
        System.out.println(newBedId);

        Boolean exeUpdateBed = roomService.upBedMessage(patientId,oldBedId,newBedId);

        if (exeUpdateBed){
            List<Bed> bedList = nurseService.showPatientBed(buildName);
            Integer buildTierNum = roomService.buildTierNum(buildName);
            List<Home> homeList = roomService.getHomeByBuildName(buildName);


            int tier[] = new int[buildTierNum]; /*开辟了一个长度为3的数组*/
            int y = 1;
            for(int x = 0; x < tier.length; x++) {
                tier[x] = y; // 第y个元素
                y = y + 1;
                System.out.println("数组tier"+tier[x]);
                System.out.println(y);
            }


            System.out.println(homeList);
            request.setAttribute("tier",tier);
            request.setAttribute("homeList",homeList);
            request.setAttribute("bedList",bedList);
            request.setAttribute("buildTierNum",buildTierNum);
            request.setAttribute("buildName",buildName);
            request.getRequestDispatcher("nurseHomeControl.jsp").forward(request,response);
        }
    }

    protected void showNurseSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NurseSchedule> nurseScheduleList = nurseService.showSchedule();
        request.setAttribute("nurseScheduleList",nurseScheduleList);
        request.getRequestDispatcher("nurseSchedule.jsp").forward(request,response);

    }

    /**
     * 选择药物
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void nurseChoiceDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Drug> drugList = drugService.showAllDrugs();
        request.setAttribute("drugList",drugList);
        request.getRequestDispatcher("nursePrescribe.jsp").forward(request,response);

    }

    /**
     * 选择药物 有pID
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void nurseChoiceDrugHadPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));
        System.out.println("这是patientId"+patientId);

        List<Drug> drugList = drugService.showAllDrugs();
        request.setAttribute("drugList",drugList);
        request.setAttribute("patientId",patientId);
        request.getRequestDispatcher("nursePrescribe.jsp").forward(request,response);

    }

    /**
     * 添加药物配置信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addPrescribeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));
        Integer drugId = Integer.valueOf(request.getParameter("drugId"));
        Integer dpNum = Integer.valueOf(request.getParameter("pickNum"));
        Integer nurseId = Integer.valueOf(request.getParameter("nurseId"));

        //获取当前时间
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        String insertTime = ft.format(dNow);
//        System.out.println("Current Date: " + ft.format(dNow));
//        System.out.println(patientId+":"+drugId+":"+dpNum+":"+nurseId);
        //判断取得数量是否小于库存
        Integer getDrugNum = drugService.getDrugNum(drugId);
        if (dpNum < getDrugNum){
            //减少drug的num
            Boolean exeUpdateDrug = drugService.exeUpdateDrug(dpNum,drugId);
            //添加信息到nd表
            Boolean exeAddMessageND = drugService.addMessageND(patientId,nurseId,drugId,dpNum,insertTime);

            if (exeUpdateDrug && exeAddMessageND){
                //通过pid查询nd表信息
                List<Prescribe> prescribeList = drugService.showPrescribe(patientId);

                request.setAttribute("prescribeList",prescribeList);
                request.getRequestDispatcher("nursePrescribeList.jsp").forward(request,response);

            } else {
                request.setAttribute("errorMessage","失败");
                request.getRequestDispatcher("nursePrescribeList.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("errorMessage","库存不足，请重新选取数量");
            request.setAttribute("patientId",patientId);
            request.getRequestDispatcher("nursePrescribe.jsp").forward(request,response);

        }




    }


    /**
     * 查询药物配置信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void queryPrescribeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));

                //通过pid查询nd表信息
                List<Prescribe> prescribeList = drugService.showPrescribe(patientId);
                request.setAttribute("prescribeList",prescribeList);
                request.getRequestDispatcher("nursePrescribeList.jsp").forward(request,response);
    }

    /**
     * 展示楼与病房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void nurseShowBuildAndHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Home> homeList = roomService.showAllHome();
        List<Build> buildList = roomService.showAllBuild();


        request.setAttribute("buildList",buildList);
        request.setAttribute("homeList",homeList);
        request.getRequestDispatcher("nurseEditBuild.jsp").forward(request,response);


    }

    /**
     * 添加楼
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addBuild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildName = request.getParameter("buildName");
        Integer buildTierNum = Integer.valueOf(request.getParameter("buildTierNum"));
        Integer buildHomeNum = Integer.valueOf(request.getParameter("buildHomeNum"));

        Boolean exeAdd = roomService.addBuild(buildName,buildTierNum,buildHomeNum);

        if (exeAdd){
            request.setAttribute("errorMessage","添加成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseShowBuildAndHome").forward(request,response);
        } else {
            request.setAttribute("errorMessage","添加失败，住院楼命名重复");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseShowBuildAndHome").forward(request,response);
        }

    }

    /**
     * 添加病房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String homeName = request.getParameter("homeName");
        String buildName = request.getParameter("oldBuildName");
        String homeType = request.getParameter("homeType");
        Integer homeTier = Integer.valueOf(request.getParameter("homeTier"));
        Integer homeBedNum = Integer.valueOf(request.getParameter("homeBedNum"));

        //判断是否到达上限
        Boolean isOut = roomService.isOut(buildName,homeTier);
        if (!isOut){
            //未到上限
            //判断插入是否成功
            Boolean exeAdd = roomService.addHome(buildName,homeName,homeType,homeTier,homeBedNum);
            if (exeAdd){
                request.setAttribute("errorMessage","添加成功");
                request.getRequestDispatcher("/NurseWorkServlet?option=nurseShowBuildAndHome").forward(request,response);
            }


        } else {
            request.setAttribute("errorMessage","添加失败，请确认病房是否到达上限");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseShowBuildAndHome").forward(request,response);
        }

    }

    /**
     * 添加病房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showHomeMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer homeId = Integer.valueOf(request.getParameter("homeId"));
        Home home = roomService.selectHome(homeId);
        List<Bed> bedList = roomService.showAllBed(homeId);

        request.setAttribute("bedList",bedList);
        request.setAttribute("home",home);
        request.getRequestDispatcher("nurseEditHome.jsp").forward(request,response);


    }


    /**
     * 添加病床
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addBed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer homeId = Integer.valueOf(request.getParameter("homeId"));
        String bedName = request.getParameter("bedName");
        //判断是否到达病房上限
        Boolean isOut = roomService.isHomeMax(homeId);
        if(!isOut){
            Boolean exeAddBed = roomService.addBed(homeId,bedName);
            if(exeAddBed){
                request.getRequestDispatcher("/NurseWorkServlet?option=showHomeMessage&homeId="+homeId).forward(request,response);
            }
        }else {
            request.setAttribute("errorMessage","超出所设定的病床上限");
            request.getRequestDispatcher("/NurseWorkServlet?option=showHomeMessage&homeId="+homeId).forward(request,response);
        }

    }
    /**
     * 修改病房信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void changeHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer homeId = Integer.valueOf(request.getParameter("homeId"));
        String homeName = request.getParameter("homeName");
        String buildName = request.getParameter("buildName");
        Integer homeTier = Integer.valueOf(request.getParameter("homeTier"));
        Integer homeBedNum = Integer.valueOf(request.getParameter("homeBedNum"));
        String homeType = request.getParameter("homeType");

        //判断输入的该层是否到达上限
        Boolean isOut = roomService.isOut(buildName,homeTier);
        if (!isOut){
            //未到上限 更新数据
            Boolean updateHome = roomService.changeHomeMessage(homeId,homeName,buildName,homeTier,homeBedNum,homeType);
            if (updateHome){
                System.out.println("home信息修改成功");
//                request.setAttribute("errorMessage","修改成功");
                request.getRequestDispatcher("/NurseWorkServlet?option=showHomeMessage&homeId="+homeId).forward(request,response);
            }
        }else {
            request.setAttribute("errorMessage","修改失败,修改的楼层病房已到达上限");
            request.getRequestDispatcher("/NurseWorkServlet?option=showHomeMessage&homeId="+homeId).forward(request,response);
        }

    }

    /**
     * 删除病房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer homeId = Integer.valueOf(request.getParameter("homeId"));
        System.out.println("到达了deleteHome"+homeId);
            Boolean exeDelHome = roomService.delHome(homeId);
            if (exeDelHome){
                request.setAttribute("errorMessage","删除成功");
                request.getRequestDispatcher("/NurseWorkServlet?option=nurseShowBuildAndHome").forward(request,response);
            } else {
                request.setAttribute("errorMessage","删除失败");
                request.getRequestDispatcher("/NurseWorkServlet?option=showHomeMessage&homeId="+homeId).forward(request,response);

            }
    }
    /**
     * 删除病房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteBed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer bedId = Integer.valueOf(request.getParameter("bedId"));
        Integer homeId = Integer.valueOf(request.getParameter("homeId"));

//        System.out.println("到达了deleteHome"+homeId);
        Boolean exeDelBed = roomService.delBed(bedId);
        if (exeDelBed){
            request.setAttribute("errorMessage","删除成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=showHomeMessage&homeId="+homeId).forward(request,response);
        } else {
            request.setAttribute("errorMessage","删除失败");
            request.getRequestDispatcher("/NurseWorkServlet?option=showHomeMessage&homeId="+homeId).forward(request,response);

        }
    }

    /**
     * 展示所有病人
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void nursePatientAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Patient> patientList = nurseService.showPatient();
        request.setAttribute("patientList",patientList);
        request.getRequestDispatcher("nurseAccount.jsp").forward(request,response);

    }

    /**
     * 展示药物金额列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showPatientAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer patientId = Integer.valueOf(request.getParameter("patientId"));
        System.out.println("这是showPatientAccount："+ patientId);
        List<Prescribe> prescribeList = drugService.showAccount(patientId);

        request.setAttribute("prescribeList",prescribeList);
        request.getRequestDispatcher("nurseAccountDetail.jsp").forward(request,response);

    }
    /**
     * 展示排班表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void editSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NurseSchedule> nurseScheduleList = nurseService.showSchedule();
        request.setAttribute("nurseScheduleList",nurseScheduleList);
        request.getRequestDispatcher("nurseMasterSche.jsp").forward(request,response);

    }

    /**
     * 修改排班表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer nurseId = Integer.valueOf(request.getParameter("nurseId"));
        String mon = request.getParameter("mon");
        String tue = request.getParameter("tue");
        String wed = request.getParameter("wed");
        String thu = request.getParameter("thu");
        String fri = request.getParameter("fri");
        String sat = request.getParameter("sat");
        String sun = request.getParameter("sun");
        String remark = request.getParameter("backM");

        Boolean exeChangeSchedule = nurseService.changeSchedule(nurseId,mon,tue,wed,thu,fri,sat,sun,remark);
        if (exeChangeSchedule){
            request.setAttribute("errorMessage","修改成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=editSchedule").forward(request,response);
        }

    }

    /**
     * 所有药物
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void nurseManageDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Drug> drugList = drugService.showAllDrugs();
        request.setAttribute("drugList",drugList);
        request.getRequestDispatcher("nurseManageDrug.jsp").forward(request,response);

    }

    /**
     * 删除药物
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer drugId = Integer.valueOf(request.getParameter("drugId"));

        Boolean exeDelete = drugService.deleteDrug(drugId);
        if (exeDelete){
            request.setAttribute("errorMessage","删除成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseManageDrug").forward(request,response);

        }
    }

    /**
     * 添加药物
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void insertDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer drugId = Integer.valueOf(request.getParameter("drugId"));
        String drugName = request.getParameter("drugName");
        String drugType = request.getParameter("drugType");
        double drugPrice = Double.parseDouble(request.getParameter("drugPrice"));
        double drugRate = Double.parseDouble(request.getParameter("drugRate"));
        String drugAdd = request.getParameter("drugAdd");
        Integer drugNum = Integer.valueOf(request.getParameter("drugNum"));


        Boolean exeInsert = drugService.insertDrug(drugId,drugName,drugType,drugPrice,drugRate,drugAdd,drugNum);
        if (exeInsert){
            request.setAttribute("errorMessage","添加成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseManageDrug").forward(request,response);
        }
    }

    /**
     * 添加药物
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer drugId = Integer.valueOf(request.getParameter("drugId"));
        String drugName = request.getParameter("drugName");
        String drugType = request.getParameter("drugType");
        double drugPrice = Double.parseDouble(request.getParameter("drugPrice"));
        double drugRate = Double.parseDouble(request.getParameter("drugRate"));
        String drugAdd = request.getParameter("drugAdd");
        Integer drugNum = Integer.valueOf(request.getParameter("drugNum"));


        Boolean exeInsert = drugService.updateDrug(drugId,drugName,drugType,drugPrice,drugRate,drugAdd,drugNum);
        if (exeInsert){
            request.setAttribute("errorMessage","修改成功");
            request.getRequestDispatcher("/NurseWorkServlet?option=nurseManageDrug").forward(request,response);
        }
    }
}
