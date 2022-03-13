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
 */
//@WebServlet( "/demo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse ) throws ServletException , IOException {
        System.out.println("doGet...........");
    }
    
    @Override
    protected void doPost( HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse ) throws ServletException , IOException {
        System.out.println( "doPost....." );
    }
    
}
