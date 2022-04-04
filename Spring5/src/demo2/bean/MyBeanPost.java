package demo2.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-23:52
 * @Function Description ：
 * bean的后置处理器
 */
public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization( Object bean , String beanName ) throws BeansException {
        System.out.println( "在初始化之前的执行方法" );
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization( Object bean , String beanName ) throws BeansException{
        System.out.println( "在初始化之后执行的方法" );
        return bean;
    }
}
