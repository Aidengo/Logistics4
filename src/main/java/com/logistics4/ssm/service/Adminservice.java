package com.logistics4.ssm.service;

import com.logistics4.ssm.pojo.Admin;

public interface Adminservice {


    int addAdmin(String account, String password);

    Admin selectAdminByAP(String account, String password);

    Admin selectManagerByAP(String account, String password);

    int updateUserPassword(String newPassword,String account);

}
