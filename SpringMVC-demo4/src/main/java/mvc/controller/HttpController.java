package mvc.controller;

import mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-04-12-20:24
 * @Function Description ：
 */
@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    /*post请求有请求题，get请求无，他是把体放到了地址栏，也就是那些参数
     * */
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("请求头:" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello , response");

    }

    //    @RequestMapping("/testResponseBody")
    @RequestMapping(value = "/testResponseBody", produces = "text/html;charset=UTF-8")//处理中文
    @ResponseBody //加了这个注解之后，方法的返回值就是响应浏览器的数据，而不再是请求页面的跳转了
    public String testResponseBody() {
//        return "success";//这个success就直接输出在页面上了，而不是跳转到success页面
        return "成功";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody//方法返回值作为响应浏览器的数据
    public User testResponseUser() {
        return new User(1001, "admin", "!23456", 23, "男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println(username + ", " + password);
        return "hello , axios ";
    }

}
