package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： CodeWater
 * @create ：2022-04-10-22:51
 * @Function Description ：
 */
@Controller
public class JspController {
    
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
