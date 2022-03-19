package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ： CodeWater
 * @create ：2022-03-19-11:06
 * @Function Description ：
 * 
 */
public class ProxyTest {
    public static void main(String[] args){
//        真实对象
        Lenovo lenovo = new Lenovo();
        
//        动态代理（在内存中）增强lenovo对象
        /*Proxy.newProxyInstance会返回一个对象，这个对象就是代理对象（Object）。代理对象和真实对象都实现了相同的接口SaleComputer，所以可以从Object转换
        成SaleComputer接口类型。至此，代理对象和真实对象都实现了相同的接口，所以后面用方法的时候就不用真实对象lenovo，而是用代理对象去调用。
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance( lenovo.getClass().getClassLoader() , lenovo.getClass().getInterfaces() , new InvocationHandler(){
            /*
               invoke  代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                     参数：
                         1. proxy:代理对象
                         2. method：代理对象调用的方法，被封装为的对象
                         3. args:代理对象调用的方法时，传递的实际参数(可能不止一个) 
              */ 
            @Override
            public Object invoke(Object proxy , Method method , Object[] args ) throws Throwable {
//                System.out.println("方法执行了");
//                System.out.println("调用的方法被封装为method对象，方法是：" + method.getName() );
//                System.out.println( "调用的方法所需要的参数列表：" + args[0] );
//                return null;
                
//                使用真实对象调用该方法;这样在真实对象中的方法就会运行（比如上面的代码执行了，但是在真实对象中的“花了多少钱买了一台电脑”却没有输出）
//                Object obj = method.invoke( lenovo , args );
//                return obj;
                
//                厂商代理的卖电脑，进货价格会便宜点.    这里只对sale卖电脑方法进行了增强，如果是show就不会
                if( method.getName().equals( "sale" ) ){
//                    1.增强参数
                    double money = (double) args[0];
                    money = money * 0.85 ;
                    
//                    3.增强方法体逻辑，如，去代理商那买电脑会有专车接送
                    System.out.println( "专车接你。。。。。" );
                    
//                    这里调用的时候就不传args了，而是对厂商优惠之后的价格
                    Object obj = method.invoke( lenovo , money );
                    
//                    3.增强方法体
                    System.out.println( "专车送你。。。。。。。。。。。" );
                    
                    
//                    2.增强返回值（从代理商那买电脑，还送了个鼠标垫）
                    return obj + " + 鼠标垫";
                }else{
//                    个人买电脑就原价
                    Object obj = method.invoke( lenovo , args );
                    return obj;
                }
            }
            
            
        } );
            
        //调用方法
        String computer = proxy_lenovo.sale( 8000 );
        System.out.println( computer );
        
//        proxy_lenovo.show();
    }
}
