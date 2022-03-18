package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-12:27
 * @Function Description ：
 */
//@WebFilter( "/*" )
public class FilterDemo02 implements Filter {
    @Override
    public void doFilter(ServletRequest req , ServletResponse resp , FilterChain chain )throws ServletException , IOException {
        /*先执行这一句，因为过滤掉了所有的资源；这句执行完了下面又放行（从放行下面开始执行），就会执行index.jsp上面的打印
        * 内容；然后执行完，回到这里执行最后的输出*/
        //这里一般对request对象请求消息增强
        System.out.println( "filterDemo2执行了" );
//        这中间的代码不会执行
        chain.doFilter( req , resp );
        
        //这里一般对resp对象的响应消息增强
        System.out.println( "filterDemo02回来了" );
    }
    
    public void init(FilterConfig config ) throws ServletException{
        
    }
    
    public void destroy(){}
}
