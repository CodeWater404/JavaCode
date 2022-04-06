package demo6.test;

import demo6.config.TxConfig;
import demo6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-21:04
 * @Function Description ：
 */
public class TestDemo {
    
    @Test//基于注解的测试（有事务参数）
    public void testAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext( "/demo6/bean1.xml" );
        UserService userService = context.getBean( "userService" , UserService.class );
        userService.accountMoney();
    }
    
    @Test//测试xml的声明式事务管理
    public void testAccount1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/demo6/bean2.xml" );
        UserService userService = context.getBean( "userService" , UserService.class );
        userService.accountMoney();
    }
    
    @Test//测试全注解开发的，事务。。。
    public void testAccount2(){
//        注意这里的new不一样，因为是读取注解的配置
        ApplicationContext context = new AnnotationConfigApplicationContext( TxConfig.class );
        UserService userService = context.getBean( "userService" , UserService.class ); 
        userService.accountMoney();
    }
}
