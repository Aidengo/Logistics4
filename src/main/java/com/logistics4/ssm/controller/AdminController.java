package com.logistics4.ssm.controller;

import com.logistics4.ssm.pojo.Admin;
import com.logistics4.ssm.pojo.CpachaUtil;
import com.logistics4.ssm.pojo.Order;
import com.logistics4.ssm.service.Adminservice;
import com.logistics4.ssm.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    //用于返回页面
    @RequestMapping("/home")
    public String home(){
        return "homepage";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam(value = "account") String account, @RequestParam(value = "usertype") String usertype,
                        @RequestParam(value = "password") String password, Model model, @Param("vcodeImg") String vcode, HttpServletRequest request){
        String loginCpacha = (String)request.getSession().getAttribute("loginCpacha");
        if (vcode==null){
            return "fail";
        }
        if(!vcode.equals(loginCpacha.toUpperCase())){
            return "fail";
        }
        if ((account!=null)&&(password!=null)&&(usertype!=null)){
            if (usertype.equals("admin")){
                Admin admin = adminservice.selectAdminByAP(account, password);
                model.addAttribute("admin",admin);
                return "homepage";
            }
            if(usertype.equals("user")){
                Admin users = adminservice.selectManagerByAP(account, password);
                model.addAttribute("account1",users);
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
    @RequestMapping(value="/get_cpacha",method= RequestMethod.GET)
    public void getCpacha(HttpServletRequest request,
                          @RequestParam(value="vl",defaultValue="4",required=false) Integer vl,
                          @RequestParam(value="w",defaultValue="98",required=false) Integer w,
                          @RequestParam(value="h",defaultValue="33",required=false) Integer h,
                          HttpServletResponse response){
        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute("loginCpacha", generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
