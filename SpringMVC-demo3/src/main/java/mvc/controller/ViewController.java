package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： CodeWater
 * @create ：2022-04-10-21:20
 * @Function Description ：
 * 视图控制器:有三种thymeleafview（不加任何前缀的都是这种）、InternalResourceView（转发视图，有前缀forward）、RedirectView（重定向视图，有前缀redirect）
 * 转发和重定向的区别：
 * 转发：一次请求（浏览器发出的）；地址栏还是转发前的地址
 * 重定向：2次；地址栏变成重定向之后的地址
 * 具体看readme笔记
 */
@Controller
public class ViewController {

    //    测试，没有任何前缀的视图就是ThymeleafView
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    //    测试转发视图，有forward前缀；解析的时候会把forward去掉；剩余部分路径通过转发跳转
    @RequestMapping("/testForward")
    public String testForward() {
// 转发到testThymeleaf页面，地址栏会显示请求之前的testFord  http://localhost:8080/SpringMVC_demo3/testForward
        return "forward:/testThymeleafView";
    }

    //    web——inf里面的资源不能再被重定向访问
    @RequestMapping("/testRedirect")
    public String testRedirect() {
//重定向，地址栏就会显示跳转之后的请求地址Thymeleaf  http://localhost:8080/SpringMVC_demo3/testThymeleafView
        return "redirect:/testThymeleafView";
    }

}
