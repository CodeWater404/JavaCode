package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-15:04
 * @Function Description ：
 */

//@WebServlet( "/demo01" )
public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo01...");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

