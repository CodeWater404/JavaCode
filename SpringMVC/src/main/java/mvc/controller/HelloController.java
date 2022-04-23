package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： CodeWater
 * @create ：2022-04-07-22:38
 * @Function Description ：
 */
@Controller
public class HelloController {

    //  通过@RequestMapping注解，可以通过请求路径匹配要处理的具体的请求
    //  /表示的当前工程的上下文路径 "/" -> /WEB-INF/templates/index.html
    @RequestMapping("/")//省略了value
    public String index() {
//        返回的视图页面
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
