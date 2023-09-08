package com.logistics4.ssm.service.impl;

import com.logistics4.ssm.mapper.CourierMapper;
import com.logistics4.ssm.pojo.Courier;
import com.logistics4.ssm.service.CourierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CourierServiceImpl implements CourierService {

    @Resource
    private CourierMapper courierMapper;

    @Override
    public List<Courier> queryAllCourier() {
        return courierMapper.queryAllCourier();
    }

    @Override
    public int addCourier(String name,String sex ,Integer age,String phonenumber) {
        return courierMapper.addCourier(name,sex,age,phonenumber);
    }

    @Override
    public int deleteCourierByName(String name) {
        return courierMapper.deleteCourierByName(name);
    }

    @Override
    public int updateCourierInfo(String newname, String sex, int age, String phonenumber,String name) {
        return courierMapper.updateCourierInfo(newname,sex,age,phonenumber,name);
    }


}
