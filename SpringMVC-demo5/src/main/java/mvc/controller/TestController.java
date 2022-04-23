package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： CodeWater
 * @create ：2022-04-13-16:59
 * @Function Description ：
 */
@Controller
public class TestController {

    /*"/**表示多级目录"*/
    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(1 / 0);
//        上面出现数学异常之后就会跳转到指定的错误视图页面，而不会跳转到成功页面
        return "success";
    }
}
