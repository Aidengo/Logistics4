package com.logistics4.ssm.service.impl;

import com.logistics4.ssm.mapper.OrderMapper;
import com.logistics4.ssm.pojo.Order;
import com.logistics4.ssm.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Resource
    private OrderMapper orderMapper;
    @Override
    public int addOrder(String shipments, String shipnumber, String path,String consignee, String consnumber,String itemname) {
        return orderMapper.addOrder(shipments,shipnumber,path ,consignee,consnumber,itemname);
    }

    @Override
    public int updateOrderInformation(String path,String shipments,String consignee) {
        return orderMapper.updatePath(path,shipments,consignee);
    }

    @Override
    public List<Order> queryAllOrder() {
        return orderMapper.queryAllOrder();
    }

    @Override
    public List<Order> queryAllOrderByaccount(String account) {
        return orderMapper.queryAllOrderByaccount(account);
    }

    @Override
    public int deleteOrder(String shipments, String consignee, String itemname) {
        return orderMapper.deleteOrder(shipments,consignee,itemname);
    }

}
