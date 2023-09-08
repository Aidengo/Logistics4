package com.logistics4.ssm.pojo;

import lombok.Data;

@Data
public class Order {
    private String shipments;

    private String shipnumber;

    private String path;

    private  String consignee;

    private String consnumber;

    private String itemname;

    private String state;  //表示当前订单状态：如已发货，已签收...
}
