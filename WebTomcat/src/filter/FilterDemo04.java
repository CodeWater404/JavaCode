package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-12:27
 * @Function Description ：
 * 过滤器拦截器配置路径
 */
//@WebFilter( "/index.jsp" )
//@WebFilter( "/user/*" )
//@WebFilter( "*.jsp" )
public class FilterDemo04 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo04....");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}
