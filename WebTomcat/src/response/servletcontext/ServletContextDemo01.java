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
 * @create ：2022-03-14-16:11
 * @Function Description ：
 */
@WebServlet( "/servletContextDemo01" )
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req , resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*
            ServletContext对象获取：
                1. 通过request对象获取
			        request.getServletContext();
                2. 通过HttpServlet获取
                    this.getServletContext();
         */

        ServletContext context1 = req.getServletContext();
        ServletContext context2 = this.getServletContext();

        System.out.println(context1);
        System.out.println(context2);
        //true
        System.out.println(context1 == context2);
    }
}
