package com.logistics4.ssm.service.impl;

import com.logistics4.ssm.mapper.AdminMapper;
import com.logistics4.ssm.pojo.Admin;
import com.logistics4.ssm.service.Adminservice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class AdminserviceImpl implements Adminservice {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int addAdmin(String account, String password) {
        return adminMapper.addAdmin(account,password);
    }


    @Override
    public Admin selectAdminByAP(String account, String password) {
        return adminMapper.selectAdminByAP(account, password);
    }

    @Override
    public Admin selectManagerByAP(String account, String password) {
        return adminMapper.selectManagerByAP(account,password);
    }

    @Override
    public int updateUserPassword(String newPassword, String account) {
        return adminMapper.updateUserPassword(newPassword,account);
    }


}


