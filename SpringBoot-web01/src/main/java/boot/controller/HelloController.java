package boot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author ： CodeWater
 * @create ：2022-04-23-22:06
 * @Function Description ：
 */
@RestController
public class HelloController {

    //    先出里请求，请求没有才会去找静态资源
    @RequestMapping("/bug.jpg")
    public String hello() {
        return "aaa";
    }

    //    @RequestMapping(value="/user" , method= RequestMethod.GET)
    @GetMapping("/user") // 复合注解
    public String getUser() {
        return "get---zhangsan";
    }

    //    @RequestMapping(value="/user" , method=RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser() {
        return "post----zhangsan";
    }

    //    @RequestMapping(value="/user" , method=RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser() {
        return "put----zhangsan";
    }

    //    @RequestMapping(value = "/user" , method=RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser() {
        return "delete-----zhangsan";
    }
}
