package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-15-14:04
 * @Function Description ：
 * 创建多个cookie，服务器端查看
 */
@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c1 = new Cookie("msg", "hello");
        Cookie c2 = new Cookie("name", "zhangsan");
        resp.addCookie(c1);
        resp.addCookie(c2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
