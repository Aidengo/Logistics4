package com.logistics4.ssm.controller;

import com.logistics4.ssm.pojo.Courier;
import com.logistics4.ssm.service.CourierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CourierController {
        @Resource
        private CourierService courierService;

        @RequestMapping(value = "/queryAllCourier")
        public String queryAllCourier(Model model){
            List<Courier> couriers = courierService.queryAllCourier();
            model.addAttribute("couriers",couriers);
            return "queryAllCourier";
        }


        @PostMapping(value = "/addCourierAction")
        public String addCourierAction(@RequestParam(value = "name")String name,@RequestParam(value = "sex") String sex,
                                       @RequestParam(value = "age") Integer age,@RequestParam(value = "phonenumber") String phonenumber){
            int i = courierService.addCourier(name, sex, age, phonenumber);
            if(i<=0){
                return "fail";
            }
            return "homepage";
        }

        @RequestMapping(value = "/updateCourierInfo")
        public String updateCourierInfo(@RequestParam("name") String name ,@RequestParam("newname") String newname ,
                                        @RequestParam("sex") String sex ,@RequestParam("age") int age ,
                                        @RequestParam("phonenumber") String phonenumber){
            int i = courierService.updateCourierInfo(newname, sex, age, phonenumber, name);
            if(i<=0){
                return "fail";
            }
            return "homepage";
        }


        @RequestMapping(value = "/deleteCouriersAction")
        public String deleteCourierByName(@RequestParam(value = "name") String name){
            int i = courierService.deleteCourierByName(name);
            if(i<=0){
                return "fail";
            }
            return "homepage";
        }
}
