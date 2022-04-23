package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;

/**
 * @author ： CodeWater
 * @create ：2022-03-19-12:38
 * @Function Description ：
 */
//@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源文件
        //1.获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        //加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        String realPath = servletContext.getRealPath(contextConfigLocation);
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContect对象被销毁了");
    }
}
