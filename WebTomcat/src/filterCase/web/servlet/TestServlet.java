package filterCase.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*测试敏感词汇的servlet*/
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String name = req.getParameter("name");
        String msg = req.getParameter("msg");

        System.out.println(name + ": " + msg);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        this.doPost(req, resp);
    }

}
