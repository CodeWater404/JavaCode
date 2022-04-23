package jspCase.web.servlet;

import jspCase.domain.User;
import jspCase.service.UserService;
import jspCase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-03-17-14:45
 * @Function Description ：
 * web层，显示页面的
 */

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        //2.将list存入request域
        req.setAttribute("users", users);
        //3.转发到list.jsp
        req.getRequestDispatcher("/jspCase/list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
