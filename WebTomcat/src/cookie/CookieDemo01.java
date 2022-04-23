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
 * @create ：2022-03-15-14:03
 * @Function Description ：
 * Cookie快速入门：创建一个cookie，demo2中查看
 */
@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c = new Cookie("msg", "hello");
        resp.addCookie(c);
        System.out.println(
                "hello，to" +
                        ""
        );
    }
}
