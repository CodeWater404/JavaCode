package demo1.test;

import demo1.Book;
import demo1.Order;
import demo1.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-16:29
 * @Function Description ：
 */
public class TestSpring {
    
    @Test
    public void testAdd(){
        //加载配置文件
        BeanFactory context = new ClassPathXmlApplicationContext("demo1/bean1.xml");

        User user = context.getBean( "user" , User.class );
        
        System.out.println( user );
        user.add();
    } 
    
    @Test
    public void testBook1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("demo1/bean1.xml");
        Book book = context.getBean( "book" , Book.class );
        System.out.println( book );
        book.testDemo();
    }
    
    @Test
    public void testOrder(){
        ApplicationContext context = new ClassPathXmlApplicationContext("demo1/bean1.xml");
        Order order = context.getBean( "order" , Order.class );
        
        System.out.println( order );
        order.ordersTest();
    }
}
