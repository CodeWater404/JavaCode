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
 */
@WebServlet( "/cookieDemo04" )
public class CookieDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c1 = new Cookie( "msg" , "setMaxAge" );
        //将cookie持久化到硬盘，30秒后会自动删除cookie文件
        c1.setMaxAge(  10 );
        //删除Cookie
//        c1.setMaxAge( 0 );
        resp.addCookie( c1 );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req , resp );
    }
}
