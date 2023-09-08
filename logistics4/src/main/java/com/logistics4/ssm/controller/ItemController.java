package com.logistics4.ssm.controller;

import com.logistics4.ssm.pojo.Item;
import com.logistics4.ssm.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemController {
    @Resource
    private ItemService itemService;

    @RequestMapping(value = "/addItemAction")
    public String addItem(@RequestParam(value = "itemname") String itemname,@RequestParam(value = "number") int number){
        int i = itemService.addItem(itemname, number);
        if(i<=0){
            return "fail";
        }
        return "homepage";
    }

    @RequestMapping(value = "/queryAllItem")
    public String queryAllItem(Model model){
        List<Item> items = itemService.selectAllItem();
        model.addAttribute("items",items);
        return "queryAllItem";
    }
}
