package demo6.test;

import demo6.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ： CodeWater
 * @create ：2022-04-07-17:00
 * @Function Description ：
 * 下面两个注解其实对应于：
 *  @Test//基于注解的测试（有事务参数）
 *   
 *  ApplicationContext context = new ClassPathXmlApplicationContext( "/demo6/bean1.xml" );
 */
@RunWith(SpringJUnit4ClassRunner.class) //单元测试框架采用4
@ContextConfiguration("classpath:/demo6/bean1.xml")//加载配置文件
public class JTest4 {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void test1(){
        userService.accountMoney();
    }
}
