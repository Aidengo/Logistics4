package com.logistics4.ssm.service;

import com.logistics4.ssm.pojo.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> queryWarehouse();


    int addWarehouse(String area, String name, double size, String linkman, String phonenumber);

    int deleteWarehouse(String warehouse);


}
