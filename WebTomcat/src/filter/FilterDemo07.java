package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-16:09
 * @Function Description ：
 */
@WebFilter("/*")
public class FilterDemo07 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo07......");

        chain.doFilter(req, resp);

        System.out.println("filterDemo07 is coming  back............");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
