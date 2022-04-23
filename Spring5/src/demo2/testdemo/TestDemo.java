package demo2.testdemo;

import demo2.autowire.Emp;
import demo2.bean.Orders;
import demo2.collectionType.Book;
import demo2.collectionType.Course;
import demo2.collectionType.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-22:14
 * @Function Description ：
 * 测试集合类型的依赖注入
 */
public class TestDemo {
    @Test
    public void testConllection1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/demo2/bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void testCollection2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/demo2/bean2.xml");
//        Book book = context.getBean( "book" , Book.class );
//        book.test();

//        测试默认是单实例。
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1);//看两个热地址是否相同
        System.out.println(book2);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/demo2/bean3.xml");
//       用factoryBean实现的，xml中初始化的是mybean，但这里new的是course。mybean实现了factorybean接口，重写方法时实现course
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testBean3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/demo2/bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取bean的实例");
        System.out.println(orders);
        //手动关闭bean
        context.close();
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/demo2/bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
