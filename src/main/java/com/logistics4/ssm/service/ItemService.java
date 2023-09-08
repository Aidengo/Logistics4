package com.logistics4.ssm.service;

import com.logistics4.ssm.pojo.Item;

import java.util.List;

public interface ItemService {
    int updateByItemName(String itemname);

    int addItem(String itemname,int number);

   List<Item> selectAllItem();
}
