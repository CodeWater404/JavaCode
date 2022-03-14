package response.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-14:59
 * @Function Description ：
 */
@WebServlet( "/responseDemo05" )
public class ResponseDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req , resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        setContentType设置编码的
        resp.setContentType( "text/html;charset=utf-8" );
        ServletOutputStream sos = resp.getOutputStream();
//        字节流输出字符，需要用getBytes来获取字节
        sos.write( "你好".getBytes("utf-8" ) );
    }
}
