package boot.controller;

import boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-04-19-16:29
 * @Function Description ：
 */
//@ResponseBody  //将该方法的返回值直接作为响应报文的响应体响应到浏览器
//@Controller
@RestController  //复合注解
@Slf4j //记录日志
public class HelloController {
    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    //   测试会不会乱码(boot自动配置了)
    @RequestMapping("/hello2")
    public String handle01(@RequestParam("name") String name) {
//        打印日志
        log.info("请求来了。。。。。");
        return "Hello , springboot2 !" + "你好： " + name;
    }
}
