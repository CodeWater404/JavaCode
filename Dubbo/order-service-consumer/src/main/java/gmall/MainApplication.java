package gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-06-12-21:37
 * @Function Description ：
 */
public class MainApplication {
    
    @SuppressWarnings("resource")
    public static void main(String[] args)  throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

//        OrderService orderService = applicationContext.getBean( OrderService.class );
//        orderService.initOrder( "1" );
        System.out.println("调用完成");
        System.in.read();
        
    }
}
