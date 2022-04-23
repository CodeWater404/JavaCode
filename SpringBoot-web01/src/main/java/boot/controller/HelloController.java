package boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-04-23-22:06
 * @Function Description ：
 */
@RestController
public class HelloController {
    
//    先出里请求，请求没有才会去找静态资源
    @RequestMapping("/bug.jpg")
    public String hello(){
        return "aaa";
    }
}
