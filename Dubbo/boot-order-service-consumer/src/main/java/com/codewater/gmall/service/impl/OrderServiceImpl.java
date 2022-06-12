package com.codewater.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import gmall.bean.UserAddress;
import gmall.service.OrderService;
import gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-06-12-16:03
 * @Function Description ：
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 *  
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {
    
//    @Autowired
    @Reference  //用dubbo的远程注解
    UserService userService;

    /**
     * 面向接口编程的方式，会报错，因为userService的实现不在这一个项目中（机器），而在另一个项目中（服务器）
     * @param userId
     */
    @Override
        public List<UserAddress> initOrder( String userId ){
        System.out.println( "用户id： " + userId );
        
        //1. 查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList( userId );
        return addressList;
    }
    
}
