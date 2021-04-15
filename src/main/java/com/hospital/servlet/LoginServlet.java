package com.hospital.servlet;


import com.google.gson.Gson;
import com.hospital.entity.Build;
import com.hospital.entity.Doctor;
import com.hospital.entity.Nurse;
import com.hospital.service.ifc.DoctorService;
import com.hospital.service.ifc.NurseService;
import com.hospital.service.ifc.RoomService;
import com.hospital.service.impl.DoctorServiceImpl;
import com.hospital.service.impl.NurseServiceImpl;
import com.hospital.service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DoctorService doctorService = new DoctorServiceImpl();
    private NurseService nurseService = new NurseServiceImpl();
    private RoomService roomService = new RoomServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String option = request.getParameter("option");
        if ("login".equals(option)){
            login(request,response);
        }


    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer username = Integer.valueOf(request.getParameter("loginUserId"));
        String userPwd = request.getParameter("loginPassword");
        String userType = request.getParameter("a");

        HttpSession session = request.getSession();
        //判断登录对象是医生还是护士
        if ("doctor".equals(userType)){ //医生登录

            Doctor doctor = doctorService.doctorLogin(username,userPwd);
            //判断用户是否存在
            if (doctor != null){
                session.setAttribute("doctor",doctor);
                System.out.println("这是在servlet层获取到的doctor："+doctor);
                request.getRequestDispatcher("doctorWork.jsp").forward(request,response);
            } else {
                request.setAttribute("errorMessage","用户名或密码错误，请重新登陆");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }


        } else if ("nurse".equals(userType)){ //护士登录
            Nurse nurse = nurseService.nurseLogin(username,userPwd);
            List<Build> builds = roomService.allbuild();
            //判断用户是否存在
            if (nurse != null){
                session.setAttribute("nurse",nurse);
                session.setAttribute("builds",builds);
                System.out.println("这是在servlet层获取到的nurse："+nurse);
                request.getRequestDispatcher("/NurseWorkServlet?option=showPatientBe").forward(request,response);
            }
            else {
                request.setAttribute("errorMessage","用户名或密码错误，请重新登陆");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }

        }

    }

    }
