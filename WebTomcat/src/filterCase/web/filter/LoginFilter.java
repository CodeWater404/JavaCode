package filterCase.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-19-10:01
 * @Function Description ：
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(req);
        HttpServletRequest request = (HttpServletRequest) req;

        String uri = request.getRequestURI();
//        判断是否包含登录相关资源路径,要注意排除掉 css/js/图片/验证码等资源
        if (uri.contains("/filterCase/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") ||
                uri.contains("/fonts") || uri.contains("/checkCodeServlet")) {
            //包含， 用户想登录，放行
            chain.doFilter(req, resp);
        } else {
            //不包含，需要验证用户是否登录
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                //没有登录， 就是跳转登录页面
                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}
