package response.download;

import response.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-17:39
 * @Function Description ：
 */
@WebServlet( "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req , resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter( "filename" );
        ServletContext servletContext = this.getServletContext();
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        String realPath = servletContext.getRealPath( "/img/" + filename );
        FileInputStream fis = new FileInputStream( realPath );

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType( filename );
        resp.setHeader( "content-type" , mimeType );
        //3.2设置响应头打开方式:content-disposition
        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = req.getHeader( "user-agent" );
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName( agent , filename );
        
        resp.setHeader( "content-disposition" , "attachment;filename=" + filename );
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while( ( len = fis.read(buff)) != -1 ){
            sos.write(buff , 0 , len );
        }
        fis.close();
    }
}
