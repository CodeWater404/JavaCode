package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： CodeWater
 * @create ：2022-04-13-21:33
 * @Function Description ：
 */
@Controller
public class testController {
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
