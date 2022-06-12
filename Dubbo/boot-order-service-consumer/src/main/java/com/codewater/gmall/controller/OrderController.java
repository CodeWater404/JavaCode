package com.codewater.gmall.controller;

import gmall.bean.UserAddress;
import gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-06-12-22:07
 * @Function Description ：
 */
@Controller
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @ResponseBody
    @RequestMapping("/initOrder")  //反问地址：localhost:8081/initOrder?uid=1  会把信息json打印在页面上
    public List<UserAddress> initOrder(@RequestParam("uid") String userId ){
        return orderService.initOrder( userId );
    }
}
