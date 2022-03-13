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
@WebServlet( "/requestDemo07" )
public class RequestDemo07 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "post" );
        //设置流的编码
        req.setCharacterEncoding( "utf-8" );
        String username = req.getParameter( "username" );
        System.out.println( username );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        和post做同样的动作;方法共用
        System.out.println( "get" );
        this.doPost(req, resp);
    }
}
