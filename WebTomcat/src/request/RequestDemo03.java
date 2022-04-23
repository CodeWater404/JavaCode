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
@WebServlet("/requestDemo03")
public class RequestDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据
        String agent = req.getHeader("user-agent");
        //先写edg，后写Chrome。因为edge里面内容也是有chrom
        if (agent.contains("Edg")) {
            System.out.println("Edge来了");

        } else if (agent.contains("chrome")) {
            System.out.println("谷歌来了");
        }
    }
}
