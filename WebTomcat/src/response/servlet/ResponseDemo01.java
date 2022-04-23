package response.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-14:58
 * @Function Description ：
 * 重定向
 */
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo01.........");

        //访问这个会自动跳到demo2,302和location是固定的（只有路径可以变化），下面那种方法是动态
//        resp.setStatus( 302 );
//        resp.setHeader( "location" , "/responseDemo02" );

        req.setAttribute("msg", "response");
        //动态获取虚拟目录
        String contextPath = req.getContextPath();

        //简单的重定向方法
        resp.sendRedirect(contextPath + "/responseDemo02");
//        resp.sendRedirect( "http://www.baidu.com" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

