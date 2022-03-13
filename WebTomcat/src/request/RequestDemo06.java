package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-16:20
 * @Function Description ：
 */
@WebServlet( "/requestDemo06" )
public class RequestDemo06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        //post获取请求参数
        String username = req.getParameter( "username" );
        System.out.println( "post" );
        System.out.println( username );
        
        System.out.println( "1-------------------------------2" );
        //根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues( "hobby" );
        for( String hobby : hobbies ){
            System.out.println( hobby );
        }
        
        System.out.println( "3-------------------" );
        //获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while( parameterNames.hasMoreElements() ){
            String name = parameterNames.nextElement() ;
            System.out.println( name );
            String value = req.getParameter( name );
            System.out.println( value );
            
        }
        
        System.out.println("4--------------------------" );
        // 获取所有参数的map集合
        Map<String , String[]> parameterMap = req.getParameterMap();

        Set<String> keyset = parameterMap.keySet();
        for( String name : keyset ){
            String[] values = parameterMap.get( name );
            System.out.println( name );
            //值是个数组
            for( String value : values ){
                System.out.println( value );
            }
        }
        
    } 
    
    @Override 
    protected void doGet( HttpServletRequest req , HttpServletResponse resp ) throws ServletException , IOException {
        //get获取请求参数;通用方法，不用写两边用this。doPost
//        String username = req.getParameter( "username" );
//        System.out.println( "get" );
//        System.out.println( username );
        this.doPost( req , resp );
        
    }
        
}
