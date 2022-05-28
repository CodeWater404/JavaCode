package com.codewater.redis_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-05-28-20:37
 * @Function Description ：把redis整合到springboot中去
 */
@RestController
@RequestMapping("/redisTest")
public class RedisTestController {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @GetMapping
    public String testRedis(){
        //设置值到redis
        redisTemplate.opsForValue().set("name" , "lucy" );
        //从redis中取值
        String name = (String) redisTemplate.opsForValue().get("name");
        return name;
    }
    
    
}
