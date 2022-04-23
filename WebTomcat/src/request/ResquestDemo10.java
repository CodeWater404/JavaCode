package request;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-20:31
 * @Function Description ：
 * 服务器会为每一个工程创建一个对象，这个对象就是ServletContext对象。这个对象全局唯一，
 * 而且工程内部的所有servlet都共享这个对象。所以叫全局应用程序共享对象。
 * 是一个域对象
 * 可以读取全局配置参数
 * 可以搜索当前工程目录下面的资源文件
 * 可以获取当前工程名字（了解）
 * servletContext是一个域对象
 * 域对象是服务器在内存上创建的存储空间，用于在不同动态资源（servlet）之间传递与共享数据。
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo10")
public class ResquestDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
