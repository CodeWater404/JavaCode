package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

/**
 * @author ： CodeWater
 * @create ：2022-03-12-12:01
 * @Function Description ：
 * 快速入门
 */
//用注解配置路径
@WebServlet( "/demo02" )
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig ) throws ServletException {
        
    }
    
    @Override 
    public ServletConfig getServletConfig(){
        return null;
    }
    
    @Override
    public void service(ServletRequest servletRequest , ServletResponse servletResponse ) throws ServletException {
        System.out.println( "Servlet3.0来了。。。。。。" );
    }
    
    @Override
    public String getServletInfo(){
        return null;
    }
    
    @Override
    public void destroy(){
        
    }
}
