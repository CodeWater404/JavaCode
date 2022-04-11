package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ： CodeWater
 * @create ：2022-04-11-19:19
 * @Function Description ：
 * 比较不同风格的请求，传统的和restful
 */
@Controller
public class UserController {

    /**
     * 使用RESTFul模拟用户资源的增删改查
     * /user    GET     查询所有用户信息
     * /user/1    GET     根据用户id查询用户信息
     * /user    POST     添加用户信息
     * /user/1    DELETE     删除用户信息
     * /user    PUT     修改用户信息
     * GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE 用来删除资源。
     */
    @RequestMapping(value="/user" , method= RequestMethod.GET)
    public String getAllUser(){
        System.out.println( "查询所有用户的信息");
        return "success";
    }
    
//    {}占位符,用于接受参数
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    public String getUserById(){
        System.out.println( "根据用户id查询用户信息" );
        return "success";
    }
    
    @RequestMapping(value="/user" , method=RequestMethod.POST)
    public String insertUser(String username , String password ){
        System.out.println( "添加用户：" + username + " , 密码： " + password );
        return "success";
    }
    
    @RequestMapping(value="/user" , method=RequestMethod.PUT)
    public String updateUser(String username , String password){
        System.out.println( "修改用户信息：" + username + "  ， 密码："  + password );
        return "success";
    }
}
