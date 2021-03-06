package response.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-16:12
 * @Function Description ：
 */
@WebServlet("/servletContextDemo05")
public class ServletContextDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
            ServletContext功能：
               1. 获取MIME类型：

                2. 域对象：共享数据
                3. 获取文件的真实(服务器)路径
         */
        ServletContext context = this.getServletContext();
        String b = context.getRealPath("/b.txt");
        //web目录下资源访问
        System.out.println(b);

        String c = context.getRealPath("/WEB-INF/c.txt");
        //WEB-INF目录下的资源访问
        System.out.println(c);
        String a = context.getRealPath("/WEB-INF/classes/a,txt");
        //src目录下的资源访问
        System.out.println(a);
    }

}
