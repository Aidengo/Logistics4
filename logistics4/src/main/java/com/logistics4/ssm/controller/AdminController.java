package com.logistics4.ssm.controller;

import com.logistics4.ssm.pojo.Admin;
import com.logistics4.ssm.pojo.Order;
import com.logistics4.ssm.service.Adminservice;
import com.logistics4.ssm.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private Adminservice adminservice;
    @Resource
    private OrderService orderService;

    //用于其他网页跳转到登录界面
    @RequestMapping("/returnlogin")
    public String returnLogin(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam(value = "account") String account,@RequestParam(value = "usertype") String usertype,
                        @RequestParam(value = "password") String password, Model model){
        Admin admin = adminservice.selectAdminByAP(account, password);
        if (admin!=null){
            if (usertype.equals("admin")){
                model.addAttribute("admin",admin);
                return "homepage";
            }
            if(usertype.equals("user")){
                String account1 = admin.getAccount();
                model.addAttribute("account1",account1);
                return "user";
            }
            return "fail";
        }else {
            return "fail";
        }
    }

    //用于返回注册页面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping(value = "/registerAction")
    public String registerAction(@RequestParam(value = "account")String account,
                                 @RequestParam(value = "password")String password) {
        Admin admin = adminservice.selectAdminByAP(account, password);
        if (admin==null){
            adminservice.addAdmin(account,password);
            return "login";
        }
        return "fail";
    }

    @RequestMapping(value = "/queryAllOrderByaccount")
    public String queryAllOrderByname(@RequestParam(value = "account1") String account1,Model model){
        List<Order> orders = orderService.queryAllOrderByaccount(account1);
        model.addAttribute("orders",orders);
        return "queryAllOrderByaccount";
    }

    @RequestMapping(value = "/updateUserPassword")
    public String updateUserPassword(@RequestParam(value = "newPassword") String newPassword,
                                     @RequestParam(value = "account1") String account1){
        int i = adminservice.updateUserPassword(newPassword, account1);
        if(i<=0){
            return "fail";
        }
        return "user";
    }

}
