package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-12:27
 * @Function Description ：
 * 过滤器的快速入门
 */
// "/*" 表示访问所有资源之前，都会执行该过滤器
//@WebFilter( "/*" )
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo01被执行了。。。");
        //放行.在测试过滤器之前，记得注释这句，
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
