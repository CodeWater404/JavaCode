package boot.config;

import boot.bean.Pet;
import boot.bean.User;
import ch.qos.logback.classic.db.DBHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ： CodeWater
 * @create ：2022-04-21-17:34
 * @Function Description ：
 * 
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 * 
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 * 
 * 
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 * 
 * 
 */
@Configuration( proxyBeanMethods = true )//告诉SpringBoot这是一个配置类 == 配置文件
@Import({User.class , DBHelper.class})
//@ConditionalOnBean( name = "tomcatPet" )//只有容器中有tomcatPet的bean，整个类中的才会生效
@ConditionalOnMissingBean( name = "tomcatPet" )//容器中没有tomcatPet的时候，类中的所有才会生效
@ImportResource( "classpath:beans.xml") //引入（旧工程中）资源配置文件（）如果xml中写了很多不想变成注解

//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
//@EnableConfigurationProperties( Car.class )

public class MyConfig {
    
//Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
//    @ConditionalOnBean( name = "tomcatPet" )//只有容器中有tomcatPet的bean，才会注册use的bean
    public User user01(){
        User zhangsan = new User( "zhangsan" , 18 );
//  proxyBeanMethods =true才能调
        zhangsan.setPet( tomcatPet() );
        return zhangsan;
    }
    
//    @Bean//注释掉测试@ConditionnalBean按照条件装入user的bean
    @Bean("tom22")//注册tom22，测试@ConditionalOnBean注册在类上，范围是所有
    public Pet tomcatPet(){
        return new Pet("tomcat" );
    }
    
    
}
