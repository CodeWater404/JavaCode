package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-12:27
 * @Function Description ：
 */
//@WebFilter( "/*" )
public class FilterDemo03 implements Filter {
//    每一次请求被拦截资源时，会执行。执行多次
    public void doFilter(ServletRequest req , ServletResponse resp , FilterChain chain ) throws ServletException , IOException {
        System.out.println( "dfilglter" );
        chain.doFilter( req , resp ); 
     }
     
     public void init( FilterConfig condig) throws ServletException{
        System.out.println( "init........." );
     } 
     
     public void destroy( ){
        System.out.println( "destroy.............." );
     }
}
