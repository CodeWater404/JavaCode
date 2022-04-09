package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ： CodeWater
 * @create ：2022-04-09-22:54
 * @Function Description ：
 */
@Controller
public class ScopeController {
//    使用servletAPI向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request ){
        request.setAttribute("testRequestScope" , "hello , servletAPI");
        return "success";
    }
    
    
}
