package com.logistics4.ssm.service;

import com.logistics4.ssm.pojo.Courier;

import java.util.List;

public interface CourierService {

    List<Courier> queryAllCourier();

    int addCourier(String name,String sex ,Integer age,String phonenumber);

    int deleteCourierByName(String name);

    int updateCourierInfo( String newname, String sex, int age, String phonenumber,String name);
}
