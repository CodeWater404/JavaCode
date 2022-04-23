package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-12:27
 * @Function Description ：
 * 和demo07演示过滤器的执行顺序
 */
@WebFilter("/*")
public class FilterDemo06 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo06.............");

        chain.doFilter(req, resp);

        System.out.println("filterDemo06 is coming back,....");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
