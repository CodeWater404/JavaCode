package boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-04-25-21:22
 * @Function Description ：
 */
@RestController//controller 和 responsebody（让返回值不再是跳转网页而是直接返回客户端字符串）的合成注解
public class ParameterTestController {
    
//    浏览器发送car/2/owner/zhangsan   动态获取路径上的参数不用#来区分
//    @PathVariable和@RequestHeader, @RequestParam从客户端那发过来的获取指定的参数
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String , Object> getCar(@PathVariable("id") Integer id ,
                                       @PathVariable("username") String name,
                                       @PathVariable Map<String , String> pv ,
                                       @RequestHeader("User-Agent") String userAgent ,
                                       @RequestHeader Map<String , String> header ,
                                       @RequestParam("age") Integer age,
                                       @RequestParam("inters")List<String>  inters ,
                                       @RequestParam Map<String , String> params ,
                                       @CookieValue("Idea-1fda507c") String _ga , 
                                       @CookieValue("JSESSIONID") Cookie cookie ){

        Map<String , Object> map = new HashMap<>();
//        map.put( "id" , id );
//        map.put("name" , name );
//        map.put("pv" ,  pv );
//        map.put("userAgent" , userAgent );
//        map.put("headers" , header );
        map.put("age" , age );
        map.put("inters" , inters );
        map.put("params" , params );
//        ps:cookie那里不同的电脑是不同的参数名，视频中是_ga , 我这里随便用了cookie中的一个参数名
        map.put("_ga" , _ga );
        System.out.println( cookie.getName() + "=====> " + cookie.getValue() );
        
        return map;
    }
    
//    测试表单提交的内容
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content ){
        Map<String , Object> map = new HashMap<>();
        map.put("content" , content );
        return map;
    }
}
