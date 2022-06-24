package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-1:11
 * @Function Description ：cglib
 * 代理对象
 * 需要jar包：
 *      asm-tree.jar
 *      asm-commons.jar
 *      cglib-2.2.jar
 *      asm.jar
 */
public class ProxyFactory implements MethodInterceptor {
    //维护一个目标对象
    private Object target;
    
    //构造器，传入一个被代理的对象
    public ProxyFactory(Object target) {
        this.target = target;
    }
    
    //返回一个代理对象: 是 target 对象的代理对象
    public Object getProxyInstance() {
//1. 创建一个工具类
        Enhancer enhancer = new Enhancer();
//2. 设置父类为目标对象
        enhancer.setSuperclass(target.getClass());
//3. 设置回调函数
        enhancer.setCallback(this);
//4. 创建子类对象，即代理对象
        return enhancer.create();
    }
    
    //重写 intercept 方法，会调用目标对象的方法
    @Override
    public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
// TODO Auto-generated method stub
        System.out.println("Cglib 代理模式 ~~ 开始");
        Object returnVal = method.invoke(target, args);
        System.out.println("Cglib 代理模式 ~~ 提交");
        
//      在这里输出这两个参数会栈溢出。。。。StackOverflowError
//        System.out.println("arg3: " + arg3   + "   arg0: " + arg0 );
        
        return returnVal;
    }
}
