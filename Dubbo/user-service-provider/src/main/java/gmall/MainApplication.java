package gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-06-12-18:03
 * @Function Description ：
 */
public class MainApplication {
    public static void main(String[] args)  throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();
        
        //为了不让程序结束，读取一个输入
        System.in.read();
        
    }
}
