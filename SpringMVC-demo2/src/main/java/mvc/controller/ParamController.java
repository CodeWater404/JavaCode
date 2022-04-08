package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ： CodeWater
 * @create ：2022-04-08-21:33
 * @Function Description ：
 */
@Controller
public class ParamController {
    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求(值从客户端的页面请求而来)
    public String testServletAPI(HttpServletRequest request ){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password" );
        System.out.println( "username:" + username + ", password:" + password );
        return "success";
    }
    
//    这种方式获取请求的参数，只需要哦形参名和请求参数名字一样即可
    @RequestMapping("/testParam")
//requestParam映射请求参数名字和方法里面的参数对应关系，user_name请求的;required默认true，不传就报错，false可以为空
//defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值
    public String testParam( @RequestParam(value="user_name" , required=false , defaultValue="hehe")String username , 
                             String password , 
                             String hobby){
//        获取到的参数还是以实际请求中的参数为准，不要只看test_param。html中的初值参数
        System.out.println( "username:" + username + "  , password:" + password +" , hobby:" + hobby);
        return "success";
    }
    
//    测试获取多个参数名一样的参数
//    @RequestMapping("/testParam2")
////    username:CodeWater ,password:123 ,hobby:a,b,c
////    public String testParam2(String username , String password , String hobby ){
//    public String testParam2(String username , String password , String[] hobby ){
////        多个重名参数写成数组形式username:CodeWater ,password:das ,hobby:[a, b, c]
//        System.out.println( "username:" + username + " ,password:" + password + " ,hobby:" + Arrays.toString( hobby) );
//        return "success";
//    }
}
