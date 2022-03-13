package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-16:20
 * @Function Description ：
 * 演示Request对象获取请求行
 */
@WebServlet( "/requestDemo01" )
public class RequestDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException {
        
    }
    
    protected void doGet(HttpServletRequest request , HttpServletResponse response ) throws ServletException , IOException {
        /*
            1. 获取请求方式 ：GET
                * String getMethod()
            2. (*)获取虚拟目录：/day14
                * String getContextPath()
            3. 获取Servlet路径: /requestDemo1
                * String getServletPath()
            4. 获取get方式请求参数：name=zhangsan:输入地址后要加？name=zhangsan
                * String getQueryString()
            5. (*)获取请求URI：/day14/demo1
                * String getRequestURI():		/day14/requestDemo1
                * StringBuffer getRequestURL()  :http://localhost/day14/requestDemo1
            6. 获取协议及版本：HTTP/1.1
                * String getProtocol()

            7. 获取客户机的IP地址：
                * String getRemoteAddr()

         */
        String method = request.getMethod();
        System.out.println( method );
        
        String contextPath = request.getContextPath();
        System.out.println( contextPath );
        
        String servletPath = request.getServletPath();
        System.out.println( servletPath );
        
        String queryString = request.getQueryString();
        System.out.println( queryString );
        
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println( requestURI + "I-------L" +requestURL );
        
        String protocol = request.getProtocol();
        System.out.println( protocol );
        
        String remoteAddr = request.getRemoteAddr();
        System.out.println( remoteAddr );
    }
}
