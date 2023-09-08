package com.logistics4.ssm.service;

import com.logistics4.ssm.pojo.Order;

import java.util.List;

public interface OrderService {
    int addOrder(String shipments,String shipnumber,String path,String consignee,String consnumber,String itemname);

    int updateOrderInformation(String path,String shipments,String consignee);

    List<Order> queryAllOrder();

    List<Order> queryAllOrderByaccount(String account);

    int deleteOrder(String shipments, String consignee, String itemname);
}
