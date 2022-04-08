package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ： CodeWater
 * @create ：2022-04-08-17:59
 * @Function Description ：
 * 1.requestMapping放在类上，那么客户端所有的请求都需要加上类上的再加上和方法上的
 *  进行路径匹配.value有多个值时，只要满足其中一个即可；
 * 2.method不设置值时，任何请求都可以匹配；
 * 3.params有多个值时，必须要同时满足才行
 *       "param"：要求请求映射所匹配的请求必须携带param请求参数
 *      "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
 *      "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
 *      "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value  
 * 4.模糊匹配
 *   ？：表示任意的单个字符
 *   *：表示任意的0个或多个字符
 *   \**：表示任意的一层或多层目录
 *   注意：在使用\**时，只能使用/ ** /xxx的方式
 */
@Controller
//@RequestMapping("/hello")//放在类上，用于区分不同的模块同一个页面
public class RequestMappingController {
//    如这个能正确匹配的路径是：服务器默认路径/hello/testRequestMapping
    @RequestMapping( value={"/testRequestMapping" , "/test" } ,
                method={RequestMethod.POST , RequestMethod.GET }
    )
    public String success(){
        return "success";
    }
    
//    requestMapping的派生，只允许get请求
    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }
    
    @RequestMapping(value="/testPut" , method=RequestMethod.PUT )
    public String testPut(){
        return "success";
    }
    

    @RequestMapping(value="/testParamsAndHeaders" , 
    params={"username" , "password!=123"} , 
        headers={"Host=localhost:8080"})
    public String testParamsAndHeaders(){
        return "success";
    }
    
//    模糊匹配
//    @RequestMapping("/a?a/testAnt")
//    @RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "success";
    }
    
//    /{id}从这开始表示路径中的这一位是数据而不是路径,原来浏览器中/1是个路径，如果有这个id=1
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable Integer id , @PathVariable  String  username){
        System.out.println( "从路径中获取到的id值：" + id + "  ，username： " + username );
        return "success";
    }
        
}
