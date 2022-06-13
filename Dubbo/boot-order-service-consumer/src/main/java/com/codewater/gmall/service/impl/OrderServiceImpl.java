package com.codewater.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import gmall.bean.UserAddress;
import gmall.service.OrderService;
import gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    
    /**
     * @Reference  //用dubbo的远程注解
     * @Reference (url= "127.0.0.1:20882")  //这样可以绕过注册中心zookeeper，直接调用远程生产者
     * @Reference (loadbalance = "" ) 指定负载均衡的模式：random、roundroubin
     */
    @Reference(url= "127.0.0.1:20882")  
    UserService userService;

    /**
     * 面向接口编程的方式，会报错，因为userService的实现不在这一个项目中（机器），而在另一个项目中（服务器）
     * @param userId
     * @HystrixCommand( fallbackMethod = "hello") : 消费方一旦调用远程服务出错，就会执行hello方法
     */
    @HystrixCommand( fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder( String userId ){
        System.out.println( "用户id： " + userId );
        
        //1. 查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList( userId );
        return addressList;
    }

    /**
     * 上面方法调用服务失败才会执行的一个默认实现
     * @param hello
     * @return
     */
    public List<UserAddress> hello( String hello ){
        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }
}
