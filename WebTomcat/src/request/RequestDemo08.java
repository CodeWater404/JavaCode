package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-16:21
 * @Function Description ：
 */
@WebServlet( "/requestDemo08" )
public class RequestDemo08 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "requestDemo08被访问了。。。" );
//转发到demo9资源;不推荐的写法，因为只用一次；建议采用下面的链式写法
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher( "/requestDemo09" );
//        requestDispatcher.forward( req , resp );
        
        //存储数据到request域中
        req.setAttribute( "msg" , "hello " );
        req.getRequestDispatcher( "/requestDemo09" ).forward( req , resp );
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req , resp );
    }
}
