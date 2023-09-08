package com.logistics4.ssm.controller;

import com.logistics4.ssm.mapper.ItemMapper;
import com.logistics4.ssm.pojo.Order;
import com.logistics4.ssm.service.ItemService;
import com.logistics4.ssm.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private ItemService itemService;

    @PostMapping(value = "/orderAddAction")
    public String orderAddAction(@RequestParam(value = "shipments") String shipments,@RequestParam(value = "shipnumber") String shipnumber,
                                 @RequestParam(value = "path") String path,@RequestParam(value = "consignee") String consignee,
                                 @RequestParam(value = "consnumber") String consnumber,
                                 @RequestParam(value = "itemname") String itemname){
        int i = orderService.addOrder(shipments, shipnumber, path,consignee, consnumber,itemname);
        if(i<=0){
            return "fail";
        }
        itemService.updateByItemName(itemname);
        return "homepage";
    }

    @RequestMapping(value = "/updateOrderInformation")
    public String updateOrderInformation(@RequestParam(value = "path") String path,@RequestParam(value = "shipments") String shipments,
                                         @RequestParam(value = "consignee") String consignee){
        int i = orderService.updateOrderInformation(path, shipments, consignee);
        if(i<=0){
            return "fail";
        }
        return "homepage";
    }

    @RequestMapping(value = "/queryAllOrder")
    public String queryAllOrder(Model model){
        List<Order> orders = orderService.queryAllOrder();
        model.addAttribute("orders",orders);
        return "queryAllOrder";
    }

    @RequestMapping(value = "/deleteOrder")
    public String deleteOrder(@RequestParam("shipments") String shipments,@RequestParam("consignee") String consignee,
                              @RequestParam("itemname") String itemname){
        int i = orderService.deleteOrder(shipments, consignee, itemname);
        if(i<=0){
            return "fail";
        }
        return "homepage";
    }


}
