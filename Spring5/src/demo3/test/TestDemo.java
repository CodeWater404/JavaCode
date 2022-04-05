package demo3.test;

import demo3.config.SpringConfig;
import demo3.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-19:27
 * @Function Description ：
 */
public class TestDemo {
    @Test
    public void testService1(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "/demo3/bean1.xml" );
        UserService userService = context.getBean( "userService" , UserService.class );
        System.out.println( userService );
        userService.add();
    }
    
//    测试完全用注解开发的
    @Test
    public void testService2(){
        ApplicationContext context = new AnnotationConfigApplicationContext( SpringConfig.class );
        UserService userService = context.getBean( "userService" , UserService.class );
        System.out.println( userService );
        userService.add();
    }
}
