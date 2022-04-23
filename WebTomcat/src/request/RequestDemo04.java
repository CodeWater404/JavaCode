package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-16:20
 * @Function Description ：
 */
@WebServlet("/requestDemo04")
public class RequestDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据
        String referer = req.getHeader("referer");
        System.out.println(referer);

        //防盗链
        if (referer != null) {

            if (referer.contains("/day1")) {
                //正常访问，到这里的路径就是localhost/day1/requestDemo04
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("播放电影");
            } else {
                //防盗链
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("想看电影吗？来CodeWater。。");
            }
        }
    }
}
