package com.hospital.servlet;


import com.hospital.entity.Build;

import java.util.ArrayList;
import java.util.List;

public class TestServlet  {


    public static void main(String[] args) {


        List<Build> buildList = new ArrayList<>();
        buildList.add(new Build("DH0001",4,18));
        buildList.add(new Build("DH0002",3,18));
        for (int i = 0; i < buildList.size(); i++) {
            Build s = (Build) buildList.get(i);
            System.out.println(s.getBuildName()+" : "+s.getBuildTierNum()+" : "+s.getTier());

        }


    }



}
