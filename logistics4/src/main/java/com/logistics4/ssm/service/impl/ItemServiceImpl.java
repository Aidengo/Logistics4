package com.logistics4.ssm.service.impl;

import com.logistics4.ssm.mapper.ItemMapper;
import com.logistics4.ssm.pojo.Item;
import com.logistics4.ssm.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public int updateByItemName(String itemname) {
        return itemMapper.updateByItemName(itemname);
    }

    @Override
    public int addItem(String itemname, int number) {
        return itemMapper.addItem(itemname,number);
    }

    @Override
    public List<Item> selectAllItem() {
        return itemMapper.selectAllItem();
    }

}
