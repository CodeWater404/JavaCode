package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-15-16:47
 * @Function Description ：
 */
@WebServlet( "/sessionDemo03" )
public class SessionDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println( session );
        
//        期望客户端关闭后，session也能相同
        Cookie c = new Cookie( "JSESSIONID" , session.getId() );
        c.setMaxAge( 60 * 60 );
        resp.addCookie( c );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req , resp );
    }
}
