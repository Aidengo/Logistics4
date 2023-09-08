package com.logistics4.ssm.service.impl;

import com.logistics4.ssm.mapper.WarehouseMapper;
import com.logistics4.ssm.pojo.Warehouse;
import com.logistics4.ssm.service.WarehouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Resource
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> queryWarehouse() {
        return warehouseMapper.queryWarehouse();
    }

    @Override
    public int addWarehouse(String area, String name, double size, String linkman, String phonenumber) {
        return warehouseMapper.addWarehouse(area,name,size,linkman,phonenumber);
    }

    @Override
    public int deleteWarehouse(String warehouse) {
        return warehouseMapper.deleteWarehouse(warehouse);
    }

}
