package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-12:27
 * @Function Description ：
 */
//@WebFilter( value="/*" , dispatcherTypes = DispatcherType.REQUEST )
// 直接请求访问index会过滤掉；通过updateServlet访问就不会过滤掉

//只有转发访问index.jsp时，该过滤器才会被执行
//@WebFilter( value="/index.jsp" , dispatcherTypes = DispatcherType.FORWARD)

//浏览器直接请求index.jsp或者转发访问index.jsp。该过滤器才会被执行
//@WebFilter( value="/*" , dispatcherTypes = {DispatcherType.FORWARD , DispatcherType.REQUEST})
public class FilterDemo05 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo05.....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }


}
