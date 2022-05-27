package boot.controller;

import boot.bean.Person;
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
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params,
                                      @CookieValue("Idea-1fda507c") String _ga,
                                      @CookieValue("JSESSIONID") Cookie cookie) {

        Map<String, Object> map = new HashMap<>();
//        map.put( "id" , id );
//        map.put("name" , name );
//        map.put("pv" ,  pv );
//        map.put("userAgent" , userAgent );
//        map.put("headers" , header );
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
//        ps:cookie那里不同的电脑是不同的参数名，视频中是_ga , 我这里随便用了cookie中的一个参数名
        map.put("_ga", _ga);
        System.out.println(cookie.getName() + "=====> " + cookie.getValue());

        return map;
    }

    //    测试表单提交的内容
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    //    测试路径中的矩阵变量（用于浏览器禁用cookie时，来传递客户端方面的东西，对应到服务器端中的session）
    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
//2、SpringBoot默认是禁用了矩阵变量的功能
//      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
//              removeSemicolonContent（移除分号内容）支持矩阵变量的
//3、矩阵变量必须有url路径变量才能被解析PathVariable
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);

        return map;
    }

    //    矩阵变量中有相同的变量名 , 指定获取哪个
//    @MatrixVariable(value="age" , pathVar="bossId")指定获取bossid(随意取得键名)的age值（路径中的）
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);

        return map;
    }

    //    数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
    @PostMapping("/saveuser")
    public Person savauser(Person person) {
        return person;
    }

}
