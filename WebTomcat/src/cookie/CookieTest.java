package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ： CodeWater
 * @create ：2022-03-15-14:40
 * @Function Description ：
 * 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 1. 有：不是第一次访问
 * 1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 2. 没有：是第一次访问
 * 1. 响应数据：您好，欢迎您首次访问
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前：" + str_date);

                    //URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后：" + str_date);
                    cookie.setValue(str_date);
                    //cookie存活一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(cookie);

                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    //URL解码
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);
                    resp.getWriter().write("<h1>欢迎回来，您上次访问时间为：" + value + "</h1>");
                    break;
                }

            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            //没有，第一次访问

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前：" + str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后：" + str_date);

            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(cookie);

            resp.getWriter().write("<h1> 您好，欢迎妮妮首次访问</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
