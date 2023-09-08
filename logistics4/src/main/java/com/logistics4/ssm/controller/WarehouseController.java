package com.logistics4.ssm.controller;

import com.logistics4.ssm.pojo.Warehouse;
import com.logistics4.ssm.service.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class WarehouseController {

    @Resource
    private WarehouseService warehouseService;

    @RequestMapping(value = "/queryWareHouse")
    public String queryWareHouse(Model model){
        List<Warehouse> Warehouses = warehouseService.queryWarehouse();
        model.addAttribute("Warehouses",Warehouses);
        return "queryWareHouse";
    }

    @PostMapping(value = "/addWarehouseAction")
    public String addWareHouse(@RequestParam(value = "area") String area,@RequestParam(value = "name") String name,
                               @RequestParam(value = "size") double size,@RequestParam(value = "linkman") String linkman,
                               @RequestParam(value = "phonenumber") String phonenumber){
        int i = warehouseService.addWarehouse(area, name, size, linkman, phonenumber);
        if(i<=0){
            return "dail";
        }
        return "homepage";
    }


    @RequestMapping(value = "deleteWareHouseAction")
    public String deleteWareHouse(@RequestParam(value = "warehouse") String warehouse){
        int i = warehouseService.deleteWarehouse(warehouse);
        if(i<=0){
            return "fail";
        }
        return "homepage";
    }

}
