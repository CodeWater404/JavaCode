package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： CodeWater
 * @create ：2022-04-08-17:28
 * @Function Description ：
 */
@Controller
public class TestController {
    
//   客户端的请求和requestmapping的内容经相匹配就能返回正确的页面
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
//    这里就是客户端的请求路径再加上/param进行匹配
    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }
    
}
