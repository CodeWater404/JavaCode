package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-13-16:20
 * @Function Description ：
 */
@WebServlet("/requestDemo05")
public class RequestDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求消息体-请求参数(只有post才有消息体,不要写到get里面去)
        BufferedReader br = req.getReader();
        String line = null;
        while ((line = br.readLine()) != null) {
            //打印了从regist提交的数据username=CodeWater&password=fddfd

            System.out.println(line);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
