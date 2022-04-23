package demo4.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-22:32
 * @Function Description ：
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Before(value = "execution( * demo4.aopanno.User.add(..) )")
    public void before() {
        System.out.println("Person before.....");
    }

}
