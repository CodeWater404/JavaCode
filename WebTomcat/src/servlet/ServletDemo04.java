package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-15:04
 * @Function Description ：
 * Servlet配置路径
 */
//@WebServlet( "/demo04")
//@WebServlet( {"/d4" , "/dd4" , "/ddd4" })
//@WebServlet( "/user/demo04" )
//@WebServlet( "/*" )
//@WebServlet( "*.do" )
public class ServletDemo04 extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse ) throws ServletException , IOException {
        System.out.println( "demo04" );
        System.out.println( httpServletRequest );
    }
}
