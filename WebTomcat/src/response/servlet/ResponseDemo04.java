package response.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-14:58
 * @Function Description ：
 */
@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //下面2句是一起写的设置自己的编码方式，然后发送给客户端的时候告诉他编码方式这样客户端才可以正确解析；不然只写一句客户端还是乱
//        resp.setCharacterEncoding( "utf-8" );
        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
//        resp.setHeader( "content-type" , "text/html;charset=utf-8" );

        //简单的形式，设置编码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write("你好");

    }
}
