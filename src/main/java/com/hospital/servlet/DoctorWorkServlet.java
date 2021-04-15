package com.hospital.servlet;
/**
 * 医生工作用servlet
 * 进行病人信息登记
 * 管理病人病历
 * 发布短期/长期医嘱
 * 安排病人进行住院
 */

import com.hospital.entity.Advice;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.service.ifc.DoctorService;
import com.hospital.service.impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/DoctorWorkServlet")
public class DoctorWorkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DoctorService doctorService = new DoctorServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String option = request.getParameter("option");
        System.out.println(option);
        if ("createNewPatient".equals(option)){
            createNewPatient(request,response);
        } else if ("selectPatientAndAdvice".equals(option)){
            selectPatientAndAdvice(request,response);
        } else if ("updateAdvice".equals(option)){
            updateAdvice(request,response);
        }
    }

    /**
     * 新病人信息录入
     * 姓名、年龄、性别、症状、短期医嘱、长期医嘱、是否住院、医保等级
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createNewPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String patientName = request.getParameter("patientName");
        Integer patientAge = Integer.valueOf(request.getParameter("patientAge"));
        String patientSex = request.getParameter("sex");
        String patientHistory = request.getParameter("patientHistory");
        String shortAdvice = request.getParameter("shortAdvice");
        String longAdvice = request.getParameter("longAdvice");
        String beHospitalized = request.getParameter("beHospitalized");
        Integer patientRank = Integer.valueOf(request.getParameter("patientRank"));
        String patientPhone = request.getParameter("patientPhone");
//        主治医师id
        Integer doctorId = Integer.valueOf(request.getParameter("doctorId"));

        //装入病人信息
        Patient patient = new Patient();
        patient.setPatientName(patientName);
        patient.setPatientAge(patientAge);
        patient.setPatientSex(patientSex);
        patient.setPatientPhone(patientPhone);
        patient.setPatientHistory(patientHistory);
        patient.setPatientRank(patientRank);
        //获取当前时间
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        String insertTime = ft.format(dNow);
        System.out.println("Current Date: " + ft.format(dNow));

//        判断是否需要住院
        if ("y".equals(beHospitalized)){
//            需要住院，转交护士台处理
            patient.setPatientBe("y");
            System.out.println("需要住院");
            Boolean exeCreatPatient = doctorService.creatPatient(doctorId,patient,shortAdvice,longAdvice,insertTime);
            if (exeCreatPatient)  {
                //前往编辑页面
                System.out.println("新建病人成功");
                request.setAttribute("exeCreatPatient",1);
                request.getRequestDispatcher("/DoctorWorkServlet?option=selectPatientAndAdvice&doctorId="+doctorId).forward(request,response);
            }
        } else {
//            无需住院，转交结账台处理
            patient.setPatientBe("n");
            System.out.println("无需住院");
        }
    }

    /**
     * 查询病人信息以及医嘱
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void selectPatientAndAdvice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //拿到对应医生id
        Integer doctorId = Integer.valueOf(request.getParameter("doctorId"));
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);

        //通过医生id查询d_p表获取对应的病人信息与医嘱、时间
        List<Advice> adviceList = doctorService.findPatientMessage(doctor);
        System.out.println("回到了servlet");
        //返回工作页面
        request.setAttribute("adviceList",adviceList);
        request.getRequestDispatcher("doctorEditPatient.jsp").forward(request,response);
//        request.getRequestDispatcher("test1.jsp").forward(request,response);

    }

    /**
     * 更新医嘱
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateAdvice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //拿到对应dpid 、长短医嘱
        Integer doctorId = Integer.valueOf(request.getParameter("doctorId"));
        Integer dpId = Integer.valueOf(request.getParameter("dpId"));
        String shortAdvice = request.getParameter("shortAdvice");
        String longAdvice = request.getParameter("longAdvice");
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
        String insertTime = ft.format(dNow);

        Advice advice = new Advice();
        advice.setDpId(dpId);
        advice.setShortAdvice(shortAdvice);
        advice.setLongAdvice(longAdvice);
        advice.setTime(insertTime);

        System.out.println(advice);

        Boolean exeUpdateAdvice = doctorService.updateAdvice(advice);
        if (exeUpdateAdvice){
            System.out.println("医嘱修改成功");
            //返回工作页面
            request.setAttribute("exeUpdateAdvice",exeUpdateAdvice);
            request.getRequestDispatcher("/DoctorWorkServlet?option=selectPatientAndAdvice&doctorId="+doctorId).forward(request,response);
//        request.getRequestDispatcher("test1.jsp").forward(request,response);
        }



    }



    }
