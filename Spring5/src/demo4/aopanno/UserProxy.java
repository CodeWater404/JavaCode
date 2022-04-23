package demo4.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-21:50
 * @Function Description ：
 */
@Component
@Aspect//生成代理类
@Order(3)//值越小优先级越高
public class UserProxy {
    //    抽取公共的切入点
    @Pointcut(value = "execution( * demo4.aopanno.User.add(..) )")
    public void pointDemo() {

    }

    //    前置通知
//    @Before( value = "execution( * demo4.aopanno.User.add(..) )" )
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("user + before");
    }

    //    最终通知，在方法之后执行。不管怎么样都会执行
    @After(value = "execution( * demo4.aopanno.User.add(..) )")
    public void after() {
        System.out.println("after..");
    }

    //后置（返回）通知   在返回值之后执行 （有异常不会执行）
    @AfterReturning(value = "execution( * demo4.aopanno.User.add(..) )")
    public void afterReturning() {
        System.out.println("afterReturning.....");
    }

    //    异常通知，有异常的时候会执行
    @AfterThrowing(value = "execution( * demo4.aopanno.User.add(..) )")
    public void afterThrowing() {
        System.out.println("afterThrowing.....");

    }

    @Around(value = "execution( * demo4.aopanno.User.add(..) )")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");

    }


}
