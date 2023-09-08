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

    private String ordernumber;
}
