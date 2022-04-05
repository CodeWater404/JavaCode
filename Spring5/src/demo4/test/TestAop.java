package demo4.test;

import demo4.aopanno.User;
import demo4.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-21:50
 * @Function Description ：
 */
public class TestAop {
    @Test
    public void testAopAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "/demo4/bean1.xml" );
        User user = context.getBean( "user" , User.class);
        user.add();
    }
    
//    测试完全用xml的配置增强
    @Test
    public void testAopXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "/demo4/bean2.xml" );
        Book book = context.getBean( "book" , Book.class );
        book.buy();
    }
}
