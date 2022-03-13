package servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-15:04
 * @Function Description ：
 */
//@WebServlet( "/demo02" )
public class ServletDemo02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest , ServletResponse servletResponse ) throws ServletException , IOException {
        System.out.println( "demo02...." );
    }
}
