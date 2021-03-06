package filterCase.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-03-19-10:01
 * @Function Description ：
 * 敏感词汇过滤器
 */
@WebServlet("/*")
public class SensitiveWordsFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains((str))) {
                                value = value.replaceAll(str, "****");
                            }
                        }
                    }
                    return value;
                }
                //判断方法名是否是 getParameterMap

                //判断方法名是否是 getParameterValue

                return method.invoke(req, args);
            }
        });

        //放行
        chain.doFilter(proxy_req, resp);

    }

    //    敏感词汇集合
    private List<String> list = new ArrayList<String>();

    public void init(FilterConfig config) throws ServletException {
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/filterCase/敏感词汇.txt");
//            读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}
