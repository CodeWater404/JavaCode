package boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-04-25-23:01
 * @Function Description ：
 */
@Controller
public class RequestController {
    //    请求路径是gotto并且请求方法必须是get才能匹配
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了。。。");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    //    @RequestAttribute获取指定名字的域中参数
    @ResponseBody//设置之后方法的返回值就只是一个正常放回值，而不是跳转到指定的网页
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();

        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);

        return map;
    }
}
