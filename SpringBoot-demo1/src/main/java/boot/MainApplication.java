package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ： CodeWater
 * @create ：2022-04-19-16:28
 * @Function Description ：
 *  主程序类;主配置类
 *  @SpringBootApplication：这是一个SpringBoot应用
 */

@SpringBootApplication(scanBasePackages="boot")//重新指定路径下的包扫描
//@ComponentScan也可以扫描
public class MainApplication {
    
    public static void main( String[] args ){
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class , args );
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for( String name : names ){
            System.out.println( name );
        }

//        //3、从容器中获取组件;单实例
//        Pet tom01 = run.getBean( "tomcatPet" , Pet.class );
//        Pet tom02 = run.getBean( "tomcatPet" , Pet.class );
//        System.out.println( tom01 == tom02 );//true
//
////        配置类也是一个组件，这里获取
//        //4、boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
//        MyConfig bean = run.getBean( MyConfig.class );
//        System.out.println( bean );
//        
////Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象  
//        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
//        User user1 = bean.user01();
//        User user2 = bean.user01();
////    @Configuration(proxyBeanMethods = false)会改变false    
//        System.out.println( user1 == user2 );//true
//        
////        测试@Configuration(proxyBeanMethods = true)时，user里面的属性pet是不是跟容器里面拿的pet同一个
//        User user01 = run.getBean( "user01" , User.class );
//        Pet tom = run.getBean( "tomcatPet" , Pet.class );
//        System.out.println( "用户的宠物：" + (user01.getPet() == tom ));
//        
////        测试@Import导入的组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println( "============= ================" );
//        for(String s : beanNamesForType ){
//            System.out.println( s );
//        }
//        DBHelper bean1 = run.getBean( DBHelper.class );
//        System.out.println( bean1 );
        
//        测试条件装配：容器中是否有tomcatPet组件
        boolean tom = run.containsBean( "tomcatPet" );
        System.out.println( "容器中是否有tomcatPet组件：" + tom );
        boolean user = run.containsBean( "user01" );
        System.out.println( "测试容器中是否有user组件：" + user );
        boolean tom22 = run.containsBean( "tom22" );
        System.out.println( "测试容器中是否tom22：" + tom22 );
        boolean haha = run.containsBean( "haha" );
        boolean hehe = run.containsBean( "hehe" );
        System.out.println( "haha：" + haha + "   , hehe: " + hehe  );
        
    }
}
