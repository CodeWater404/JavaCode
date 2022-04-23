package demo1.test;

import demo1.bean.Emp;
import demo1.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-21:05
 * @Function Description ：
 */
public class TestBean {
    @Test
    public void testBean1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo1/bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testBean2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo1/bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }

    @Test
    public void testBean3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo1/bean4.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }
}
