package com.codewater.boot.controller;

import com.codewater.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-04-22-22:25
 * @Function Description ：
 */
@RestController//是 @Controller 和 @ResponseBody 两个注解的结合体。
public class HelloController {
    @Autowired
    Person person;
    
    @RequestMapping("/hello")
    public Person hello(){
        return person;
    }
}
