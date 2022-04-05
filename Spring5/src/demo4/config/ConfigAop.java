package demo4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-23:00
 * @Function Description ：
 * 完全使用注解的配置类
 */
@Configuration
@ComponentScan( basePackages={"demo4"})
@EnableAspectJAutoProxy( proxyTargetClass=true)
public class ConfigAop {
}
