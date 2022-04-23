package request.test.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import request.test.dao.UserDao;
import request.test.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-12:15
 * @Function Description ：
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        /*
        String username = req.getParameter( "username" );
        String password = req.getParameter( "password" );

        User loginUser = new User();
        loginUser.setUsername( username );
        loginUser.setPassword( password );
        */

//        获取所有的请求参数
        Map<String, String[]> map = req.getParameterMap();
        User loginUser = new User();
        try {
//        beanutils封装javabean；
//        populate（参数一是个对象，参数二是map）将map集合的键值对信息，封装到对应的们avaBean对象中，键是属性名称，值为属性值
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        if (user == null) {
            req.getRequestDispatcher("/failServlet").forward(req, resp);

        } else {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
